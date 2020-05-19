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
import com.hebin.user.entity.TeacherEntity;
import com.hebin.user.entity.UserRoleEntity;
import com.hebin.user.service.RoleService;
import com.hebin.user.service.StudentService;
import com.hebin.user.service.TeacherService;
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
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation("学生用户注册")
    @PostMapping("/create/student")
    @PreAuthorize("hasAuthority('user:register:save')")
    public Resp<Object> saveStudent(@RequestBody StudentEntity student){
        //条件构造器
        QueryWrapper<StudentEntity> qw = new QueryWrapper<>();
        //如果注册手机已经存在
        qw.eq("user_tel",student.getUserTel()).or().eq("user_mail",student.getUserMail());

        if(!studentService.list(qw).isEmpty())
        {
            return Resp.fail("用户已经存在");
        }

        studentService.save(student);
        StudentEntity stu=studentService.getOne(qw);

        //保存角色信息逻辑
        //未来将使用springsecurity代替
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        //设置用户角色
        userRoleEntity.setUserRoleRole(1L);
        //对应的用户id
        userRoleEntity.setUserRoleUserid(Long.parseLong(stu.getUserId()));
        userRoleService.save(userRoleEntity);

        return Resp.ok("注册成功");
    }

    @ApiOperation("教师用户注册")
    @PostMapping("/create/teacher")
    @PreAuthorize("hasAuthority('user:register:save')")
    public Resp<Object> saveTeacher(@RequestBody TeacherEntity teacher){
        //条件构造器
        QueryWrapper<TeacherEntity> qw = new QueryWrapper<>();
        //如果注册手机已经存在
        qw.eq("user_tel",teacher.getUserTel()).or().eq("user_mail",teacher.getUserMail());
        if(!teacherService.list(qw).isEmpty())
        {
            return Resp.fail("用户已经存在");
        }
        //如果注册手机或者邮箱不存在
        teacherService.save(teacher);

        TeacherEntity tea=teacherService.getOne(qw);

        //保存角色信息逻辑
        //未来将使用springsecurity代替
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        //设置用户角色
        userRoleEntity.setUserRoleRole(2L);
        //对应的用户id
        userRoleEntity.setUserRoleUserid(Long.parseLong(tea.getUserId()));
        userRoleService.save(userRoleEntity);
        return Resp.ok("注册成功");
    }

}
