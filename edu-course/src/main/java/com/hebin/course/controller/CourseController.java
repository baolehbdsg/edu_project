package com.hebin.course.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebin.core.bean.*;

import com.hebin.course.entity.CourseStuEntity;
import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.course.service.CourseStuService;
import com.hebin.course.service.CourseTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.CourseEntity;
import com.hebin.course.service.CourseService;




/**
 * 课程
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程 管理")
@RestController
@RequestMapping("course/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseTeacherService courseTeacherService;
    @Autowired
    private CourseStuService courseStuService;
    /**
     * 列表
     */
    @ApiOperation("获取教师已创建课程页面")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:course:list')")
    public Resp<PageVo> list(QueryCondition queryCondition,String userId) {
        //改进根据redis中的教师id进行查询,从带来的cookie中找
        //这里先完成基础流程，即直接从前端传一个userid

        PageVo page=courseTeacherService.getCourseList(queryCondition,userId);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("获取课程详情")
    @GetMapping("/info/{courseId}")
    @PreAuthorize("hasAuthority('course:course:info')")
    public Resp<CourseEntity> info(@PathVariable("courseId") Long courseId){


		CourseEntity course = courseService.getById(courseId);

        return Resp.ok(course);
    }

    /**
     * 保存
     */
    @ApiOperation("创建课程")
    @PostMapping("/create/course")
    @PreAuthorize("hasAuthority('course:course:save')")
    public Resp<Object> save(String teacherid,@RequestBody CourseEntity course){
        //save必须在一个事务中
        //校验course的id值是否合法
        if(course.getCourseId()!="")
        {
            course.setCourseId("");
        }
        //保存课程信息
		courseService.save(course);
        CourseTeacherEntity courseTeacherEntity = new CourseTeacherEntity();
        courseTeacherEntity.setCourseId(Long.parseLong(course.getCourseId()));
        courseTeacherEntity.setUserId(Long.parseLong(teacherid));
        //保存教师与课程之间的关系
        courseTeacherService.save(courseTeacherEntity);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改课程信息")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:course:update')")
    public Resp<Object> update(@RequestBody CourseEntity course){

		courseService.updateById(course);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除课程")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:course:delete')")
    public Resp<Object> delete(@RequestBody Long[] courseIds){
		courseService.removeByIds(Arrays.asList(courseIds));
        return Resp.ok(null);
    }



}
