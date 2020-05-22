/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.lesson.VO.LessonHomeworkVO;
import com.hebin.lesson.entiry.TeacherHomeworkEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.lesson.service.TeacherHomeworkService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = "教师与作业 管理")
@RestController
@RequestMapping("lesson/teacherhomework")
public class TeacherHomeworkController {
    @Autowired
    private TeacherHomeworkService teacherHomeworkService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('lesson:teacherhomework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = teacherHomeworkService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('lesson:teacherhomework:info')")
    public Resp<TeacherHomeworkEntity> info(@PathVariable("id") Long id){
		TeacherHomeworkEntity teacherHomework = teacherHomeworkService.getById(id);

        return Resp.ok(teacherHomework);
    }

    /**
     * 通过课程区同时保存到备课区
     */
    @ApiOperation("通过课程区同时保存到备课区")
    @PostMapping("/save/homework")
    @PreAuthorize("hasAuthority('lesson:teacherhomework:save')")
    public void saveHomework(@RequestBody TeacherHomeworkEntity teacherHomework){

		teacherHomeworkService.save(teacherHomework);

    }

    /**
     * 通过课程区同时保存到备课区
     */
    @ApiOperation("通过备课区直接创建作业")
    @PostMapping("/create/homework")
    @PreAuthorize("hasAuthority('lesson:teacherhomework:save')")
    public void createHomework(@RequestBody LessonHomeworkVO lessonHomeworkVO){

        teacherHomeworkService.createHomework(lessonHomeworkVO);

    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('lesson:teacherhomework:update')")
    public Resp<Object> update(@RequestBody TeacherHomeworkEntity teacherHomework){
		teacherHomeworkService.updateById(teacherHomework);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('lesson:teacherhomework:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		teacherHomeworkService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
