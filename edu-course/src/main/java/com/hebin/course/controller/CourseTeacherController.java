/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.controller;

import java.util.Arrays;


import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.service.CourseTeacherService;




/**
 * 教师与课程
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "教师与课程 管理")
@RestController
@RequestMapping("course/courseteacher")
public class CourseTeacherController {
    @Autowired
    private CourseTeacherService courseTeacherService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:courseteacher:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseTeacherService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:courseteacher:info')")
    public Resp<CourseTeacherEntity> info(@PathVariable("id") Long id){
		CourseTeacherEntity courseTeacher = courseTeacherService.getById(id);

        return Resp.ok(courseTeacher);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:courseteacher:save')")
    public Resp<Object> save(@RequestBody CourseTeacherEntity courseTeacher){
		courseTeacherService.save(courseTeacher);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:courseteacher:update')")
    public Resp<Object> update(@RequestBody CourseTeacherEntity courseTeacher){
		courseTeacherService.updateById(courseTeacher);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:courseteacher:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseTeacherService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
