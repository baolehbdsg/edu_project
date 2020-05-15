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
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:coursehomework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseHomeworkService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:coursehomework:info')")
    public Resp<CourseHomeworkEntity> info(@PathVariable("id") Long id){
		CourseHomeworkEntity courseHomework = courseHomeworkService.getById(id);

        return Resp.ok(courseHomework);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:coursehomework:save')")
    public Resp<Object> save(@RequestBody CourseHomeworkEntity courseHomework){
		courseHomeworkService.save(courseHomework);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:coursehomework:update')")
    public Resp<Object> update(@RequestBody CourseHomeworkEntity courseHomework){
		courseHomeworkService.updateById(courseHomework);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursehomework:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseHomeworkService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
