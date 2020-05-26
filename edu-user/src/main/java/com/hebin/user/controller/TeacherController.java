/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;

import java.util.Arrays;


import com.hebin.user.entity.TeacherEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.user.service.TeacherService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
@Api(tags = "教师用户个人信息管理")
@RestController
@RequestMapping("user/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;




    /**
     * 查看个人信息
     */
    @ApiOperation("教师个人信息查询")
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('user:teacher:info')")
    public Resp<TeacherEntity> info(@PathVariable("userId") Long userId){
		TeacherEntity teacher = teacherService.getById(userId);

        return Resp.ok(teacher);
    }

    /**
     * 修改个人信息
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:teacher:update')")
    public Resp<Object> update(@RequestBody TeacherEntity teacher){
		teacherService.updateById(teacher);

        return Resp.ok("修改成功");
    }

}
