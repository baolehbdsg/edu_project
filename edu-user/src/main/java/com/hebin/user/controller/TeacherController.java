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
@Api(tags = " 管理")
@RestController
@RequestMapping("user/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('user:teacher:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = teacherService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('user:teacher:info')")
    public Resp<TeacherEntity> info(@PathVariable("userId") Long userId){
		TeacherEntity teacher = teacherService.getById(userId);

        return Resp.ok(teacher);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('user:teacher:save')")
    public Resp<Object> save(@RequestBody TeacherEntity teacher){
		teacherService.save(teacher);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:teacher:update')")
    public Resp<Object> update(@RequestBody TeacherEntity teacher){
		teacherService.updateById(teacher);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:teacher:delete')")
    public Resp<Object> delete(@RequestBody Long[] userIds){
		teacherService.removeByIds(Arrays.asList(userIds));

        return Resp.ok(null);
    }

}
