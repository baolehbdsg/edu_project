package com.hebin.edu.bbs.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.bbs.entity.BbsEntity;
import com.hebin.edu.bbs.service.BbsService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 */
@Api(tags = " 管理")
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
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('bbs:bbs:save')")
    public Resp<Object> save(@RequestBody BbsEntity bbs){
		bbsService.save(bbs);

        return Resp.ok(null);
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
