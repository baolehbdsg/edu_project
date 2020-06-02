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
import com.hebin.user.VO.UserRegisterVO;
import com.hebin.user.entity.StudentEntity;
import com.hebin.user.entity.TeacherEntity;
import com.hebin.user.entity.UserRoleEntity;
import com.hebin.user.service.StudentService;
import com.hebin.user.service.TeacherService;
import com.hebin.user.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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

    @ApiOperation("用户注册")
    @PreAuthorize("hasAuthority('user:register:save')")
    public Resp<Object> userRegister(@RequestBody UserRegisterVO userRegisterVO) throws Exception {
        //先查一下看看是否注册过，没有注册过再往下走
        //条件构造器
        QueryWrapper<StudentEntity> qwStu = new QueryWrapper<>();
        QueryWrapper<TeacherEntity> qwTea = new QueryWrapper<>();
        //如果注册手机或者邮箱已经存在
        StudentEntity student = new StudentEntity();
        //属性值复制
        BeanUtils.copyProperties(userRegisterVO,student);
        qwStu.eq("user_tel",student.getUserTel()).or().eq("user_mail",student.getUserMail());
        TeacherEntity teacher = new TeacherEntity();
        BeanUtils.copyProperties(userRegisterVO,teacher);
        qwTea.eq("user_tel",teacher.getUserTel()).or().eq("user_mail",teacher.getUserMail());
        if(!studentService.list(qwStu).isEmpty()||!teacherService.list(qwTea).isEmpty())
        {
            return Resp.fail("用户已存在");
        }
        //短信校验
        //成功往下走
        //失败返回失败
        if(userRegisterVO.getUserType()==0)
        {
            return saveStudent(student);
        }
        else
        {
            return saveTeacher(teacher);
        }
    }

    public Resp<Object> saveStudent(StudentEntity student){
        //预处理，对传入的Id部分进行预处理
        if(student.getUserId()!="")
        {
            student.setUserId("");
        }

        studentService.save(student);

        //保存角色信息逻辑
        //未来将使用springsecurity代替
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        //设置用户角色
        userRoleEntity.setUserRoleRole(1L);
        //对应的用户id
        userRoleEntity.setUserRoleUserid(student.getUserId());
        userRoleService.save(userRoleEntity);
        //注册成功可以返回一个session或者保存到token中
        return Resp.ok("注册成功");
    }

    public Resp<Object> saveTeacher(TeacherEntity teacher){
        //数据预处理
        if(teacher.getUserId()!="")
        {
            teacher.setUserId("");
        }

        teacherService.save(teacher);

        //保存角色信息逻辑
        //未来将使用springsecurity代替
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        //设置用户角色
        userRoleEntity.setUserRoleRole(2L);
        //对应的用户id
        userRoleEntity.setUserRoleUserid(teacher.getUserId());
        userRoleService.save(userRoleEntity);
        //注册成功可以返回一个session或者保存到token中
        return Resp.ok("注册成功");
    }



}
