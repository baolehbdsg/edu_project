/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.Resp;
import com.hebin.user.entity.StudentEntity;
import com.hebin.user.entity.TeacherEntity;
import com.hebin.user.entity.UserRoleEntity;
import com.hebin.user.service.StudentService;
import com.hebin.user.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(tags = "用户登录")
@RestController
@RequestMapping(value = "user/login")
public class UserLoginController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @ApiOperation("用户账号密码登录")
    @PostMapping("/normal")
    @PreAuthorize("hasAuthority('user:register:save')")
    public Resp<Object> userLogin(String userInfo,String userPassword){
        //条件构造器
        QueryWrapper<StudentEntity> qwStu = new QueryWrapper<>();
        QueryWrapper<TeacherEntity> qwTea = new QueryWrapper<>();
        qwStu.eq("user_tel",userInfo).or().eq("user_mail",userInfo);
        qwTea.eq("user_tel",userInfo).or().eq("user_mail",userInfo);
        StudentEntity stu=studentService.getOne(qwStu);
        TeacherEntity tea=teacherService.getOne(qwTea);
        System.out.println(stu+"  "+tea);
//      未来将使用redis保存用户登录信息
       if(stu==null && tea == null)
       {
           return Resp.fail("用户不存在");
       }
       if(stu!=null)
       {
           if(userPassword.equals(stu.getUserPassword()))
           {

               return Resp.ok(stu);
           }
           else
           {
               return Resp.fail("登录失败,用户名或密码错误");
           }
       }
       else
       {
           if(userPassword.equals(tea.getUserPassword()))
           {
//               session.setAttribute("userInfo",userInfo);
               return Resp.ok(tea);
           }
           else
           {
               return Resp.fail("登录失败，用户名或者密码错误");
           }
       }
    }
}
