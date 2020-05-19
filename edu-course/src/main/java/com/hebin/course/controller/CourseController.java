package com.hebin.course.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;

import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.course.service.CourseTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiOperation("创建课程")
    @PostMapping("/create/course")
    @PreAuthorize("hasAuthority('course:course:save')")
    public Resp<Object> save(String teacherid,@RequestBody CourseEntity course){
        //校验course的id值是否合法
        if(course.getCourseId()!="")
        {
            course.setCourseId("");
        }
		courseService.save(course);
        CourseTeacherEntity courseTeacherEntity = new CourseTeacherEntity();
        courseTeacherEntity.setCourseId(Long.parseLong(course.getCourseId()));
        courseTeacherEntity.setUserId(Long.parseLong(teacherid));
        courseTeacherService.save(courseTeacherEntity);
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
