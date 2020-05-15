/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;

import java.util.Arrays;


import com.hebin.user.entity.StudentEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.user.service.RoleService;
import com.hebin.user.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.user.service.StudentService;




/**
 * ѧ
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
@Api(tags = "学生用户 管理")
@RestController
@RequestMapping("user/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('user:student:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = studentService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('user:student:info')")
    public Resp<StudentEntity> info(@PathVariable("userId") Long userId){
		StudentEntity student = studentService.getById(userId);

        return Resp.ok(student);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('user:student:save')")
    public Resp<Object> save(@RequestBody StudentEntity student){
		studentService.save(student);


        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:student:update')")
    public Resp<Object> update(@RequestBody StudentEntity student){
		studentService.updateById(student);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:student:delete')")
    public Resp<Object> delete(@RequestBody Long[] userIds){
		studentService.removeByIds(Arrays.asList(userIds));

        return Resp.ok(null);
    }

}
