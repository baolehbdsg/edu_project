/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.controller;

import java.util.Arrays;


import com.hebin.course.entity.CourseTestEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.service.CourseTestService;




/**
 * 课程测试
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "课程测试 管理")
@RestController
@RequestMapping("course/coursetest")
public class CourseTestController {
    @Autowired
    private CourseTestService courseTestService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:coursetest:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseTestService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{testId}")
    @PreAuthorize("hasAuthority('course:coursetest:info')")
    public Resp<CourseTestEntity> info(@PathVariable("testId") Long testId){
		CourseTestEntity courseTest = courseTestService.getById(testId);

        return Resp.ok(courseTest);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:coursetest:save')")
    public Resp<Object> save(@RequestBody CourseTestEntity courseTest){
		courseTestService.save(courseTest);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:coursetest:update')")
    public Resp<Object> update(@RequestBody CourseTestEntity courseTest){
		courseTestService.updateById(courseTest);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursetest:delete')")
    public Resp<Object> delete(@RequestBody Long[] testIds){
		courseTestService.removeByIds(Arrays.asList(testIds));

        return Resp.ok(null);
    }

}
