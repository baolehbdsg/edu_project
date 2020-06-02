/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.user.VO.CourseStuVO;
import com.hebin.user.entity.StudentEntity;
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
@Api(tags = "学生用户个人信息管理")
@RestController
@RequestMapping("user/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 信息
     */
    @ApiOperation("学生用户个人信息查询")
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('user:student:info')")
    public Resp<StudentEntity> info(@PathVariable("userId") Long userId){
		StudentEntity student = studentService.getById(userId);

        return Resp.ok(student);
    }


    /**
     * 修改个人信息
     */
    @ApiOperation("修改个人信息")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:student:update')")
    public Resp<Object> update(@RequestBody StudentEntity student){
		studentService.updateById(student);

        return Resp.ok("修改成功");
    }

//    @ApiOperation("学生用户个人信息查询")
//    @PostMapping("/getcoursestudent")
//    public Resp<PageVo> getCourseStudent(@RequestBody CourseStuVO courseStuVO)
//    {
//
//        PageVo pageVo = studentService.getCourseStu(courseStuVO);
//        return Resp.ok(null);
//    }

    @ApiOperation("选课学生列表")
    @GetMapping("/userlist")
    public PageVo userlist(QueryCondition params, String []userIds){

        IPage<StudentEntity> page = new Query<StudentEntity>().getPage(params);
        QueryWrapper<StudentEntity> qw = new QueryWrapper<StudentEntity>();
        qw.in("user_id",userIds);
        studentService.page(page,qw);
        return new PageVo(page);
    }
}
