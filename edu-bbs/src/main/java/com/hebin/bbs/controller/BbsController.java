/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.bbs.entity.BbsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.hebin.bbs.service.BbsService;


/**
 * @author hebin
 * @email 649980884@@qq.com
 */
@Api(tags = "论坛 管理")
@RestController
@RequestMapping("bbs/bbs")
public class BbsController {
    @Autowired
    private BbsService bbsService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('bbs:bbs:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = bbsService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{bbsId}")
    @PreAuthorize("hasAuthority('bbs:bbs:info')")
    public Resp<BbsEntity> info(@PathVariable("bbsId") Long bbsId){
		BbsEntity bbs = bbsService.getById(bbsId);

        return Resp.ok(bbs);
    }

    /**
     * 随着课程创建同时创建课程论坛
     * openfeign的远程调用
     */
    @ApiOperation("创建课程论坛")
    @PostMapping("/bbsapi/createcoursebbs")
    @PreAuthorize("hasAuthority('bbs:bbs:save')")
    public Resp<String> createcoursebbs(@RequestParam(value = "bbsName",required = true) String bbsName){
        BbsEntity bbsEntity=new BbsEntity();
        bbsEntity.setBbsId("");
        bbsEntity.setForumName(bbsName);
		bbsService.save(bbsEntity);
        return Resp.ok(bbsEntity.getBbsId());
    }
    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('bbs:bbs:update')")
    public Resp<Object> update(@RequestBody BbsEntity bbs){
		bbsService.updateById(bbs);
        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('bbs:bbs:delete')")
    public Resp<Object> delete(@RequestBody Long[] bbsIds){
		bbsService.removeByIds(Arrays.asList(bbsIds));

        return Resp.ok(null);
    }

}
