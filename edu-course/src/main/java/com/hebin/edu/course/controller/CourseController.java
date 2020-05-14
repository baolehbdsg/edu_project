package com.hebin.edu.course.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.course.entity.CourseEntity;
import com.hebin.edu.course.service.CourseService;




/**
 * 课程
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "课程 管理")
@RestController
@RequestMapping("course/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:course:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{courseId}")
    @PreAuthorize("hasAuthority('course:course:info')")
    public Resp<CourseEntity> info(@PathVariable("courseId") Long courseId){
		CourseEntity course = courseService.getById(courseId);

        return Resp.ok(course);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:course:save')")
    public Resp<Object> save(@RequestBody CourseEntity course){
		courseService.save(course);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:course:update')")
    public Resp<Object> update(@RequestBody CourseEntity course){
		courseService.updateById(course);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:course:delete')")
    public Resp<Object> delete(@RequestBody Long[] courseIds){
		courseService.removeByIds(Arrays.asList(courseIds));

        return Resp.ok(null);
    }

}
