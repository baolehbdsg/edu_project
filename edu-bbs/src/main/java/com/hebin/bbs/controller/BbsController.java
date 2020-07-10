/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.controller;
import java.util.Arrays;
import com.hebin.bbs.DTO.CoursebbsDTO;
import com.hebin.bbs.entity.BbsEntity;
import com.hebin.bbs.entity.CourseBbsEntity;
import com.hebin.bbs.service.CourseBbsService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
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
    @Autowired
    private CourseBbsService courseBbsService;
    /**
     * 信息
     */
    @ApiOperation("查看课程论坛")
    @GetMapping("/info/{bbsId}")
    @PreAuthorize("hasAuthority('bbs:bbs:info')")
    public Resp<BbsEntity> info(@PathVariable("bbsId") Long bbsId){
		BbsEntity bbs = bbsService.getById(bbsId);
        //返回一个bbs的基本信息
        return Resp.ok(bbs);
    }

    /**
     * 随着课程创建同时创建课程论坛
     * openfeign的远程调用
     */
    @ApiOperation("创建课程论坛")
    @PostMapping("/bbsapi/createcoursebbs")
    @PreAuthorize("hasAuthority('bbs:bbs:save')")
    public Resp<String> createcoursebbs(@RequestBody CoursebbsDTO coursebbsDTO){

        courseBbsService.createBBS(coursebbsDTO);
        return Resp.ok(null);
    }
    /**
     *
     * 修改课程，修改课程论坛名称
     * 远程调用
     */
    @ApiOperation("修改论坛名称")
    @PostMapping("/bbsapi/update")
    @PreAuthorize("hasAuthority('bbs:bbs:update')")
    public Resp<Object> updateBBS(@RequestBody CoursebbsDTO coursebbsDTO){
		bbsService.update();
        return Resp.ok(null);
    }

    /**
     *
     * 删除课程时删除论坛
     * 远程调用
     */
    @ApiOperation("删除")
    @PostMapping("/bbsapi/delete")
    @PreAuthorize("hasAuthority('bbs:bbs:delete')")
    public Resp<Object> delete(@RequestBody Long[] bbsIds){
		bbsService.removeByIds(Arrays.asList(bbsIds));

        return Resp.ok(null);
    }

}
