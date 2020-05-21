package com.hebin.course.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.CourseHomeworkEntity;
import com.hebin.course.service.CourseHomeworkService;




/**
 * 课程与作业
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程与作业 管理")
@RestController
@RequestMapping("course/coursehomework")
public class CourseHomeworkController {
    @Autowired
    private CourseHomeworkService courseHomeworkService;
    /**
     * 获取课程作业列表
     */
    @ApiOperation("获取课程作业列表")
    @GetMapping("/list/homework/{courseId}")
    @PreAuthorize("hasAuthority('course:coursehomework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition,@PathVariable("courseId") String courseId)
    {
        //学生和教师都可以获取
        PageVo page = courseHomeworkService.getCourseHomeworkList(queryCondition,courseId);
        return Resp.ok(page);
    }


    /**
     * 作业详情查看
     */
    @ApiOperation("作业详情查看")
    @GetMapping("/info/homework/{id}")
    @PreAuthorize("hasAuthority('course:coursehomework:info')")
    public Resp<CourseHomeworkEntity> info(@PathVariable("id") String id){
		CourseHomeworkEntity courseHomework = courseHomeworkService.getById(id);

        return Resp.ok(courseHomework);
    }

    /**
     * 发布作业
     */
    @ApiOperation("发布作业")
    @PostMapping("/create/homework")
    @PreAuthorize("hasAuthority('course:coursehomework:save')")
    public Resp<Object> createhomework(@RequestBody CourseHomeworkEntity courseHomework){
        //校验id是否合法
        //
        if(courseHomework.getId()!="")
        {
            courseHomework.setId("");
        }

		courseHomeworkService.save(courseHomework);

        return Resp.ok(null);
    }

    /**
     * 修改作业信息
     */
    @ApiOperation("修改作业信息")
    @PostMapping("/updat/homework")
    @PreAuthorize("hasAuthority('course:coursehomework:update')")
    public Resp<Object> update(@RequestBody CourseHomeworkEntity courseHomework){
		courseHomeworkService.updateById(courseHomework);

        return Resp.ok("sucsess");
    }
    /**
     * 删除作业
     */
    @ApiOperation("删除作业")
    @PostMapping("/delete/homework")
    @PreAuthorize("hasAuthority('course:coursehomework:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		courseHomeworkService.removeByIds(Arrays.asList(ids));
        return Resp.ok(null);
    }



}
