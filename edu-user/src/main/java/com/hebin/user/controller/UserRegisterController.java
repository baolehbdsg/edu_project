/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.user.entity.StudentEntity;
import com.hebin.user.entity.UserRoleEntity;
import com.hebin.user.service.RoleService;
import com.hebin.user.service.StudentService;
import com.hebin.user.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户注册")
@RestController
@RequestMapping("user/register")
public class UserRegisterController {
    @Autowired
    private StudentService studentService;
    private UserRoleService userRoleService;
    @ApiOperation("用户注册")
    @PostMapping("/save/student")
    @PreAuthorize("hasAuthority('user:register:save')")
    public Resp<Object> save(@RequestBody StudentEntity student){
        //条件构造器
        QueryWrapper<StudentEntity> wrapper = new QueryWrapper<>();
        //如果注册手机已经存在
        student.setUserId(999L);
        if(student.getUserTel()!=null)
        {

        }
        //如果注册手机不存在
        studentService.save(student);
//        UserRoleEntity userRoleEntity = new UserRoleEntity();

        return Resp.ok(null);
    }
}
