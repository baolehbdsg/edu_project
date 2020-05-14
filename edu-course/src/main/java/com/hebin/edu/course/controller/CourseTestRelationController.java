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

import com.hebin.edu.course.entity.CourseTestRelationEntity;
import com.hebin.edu.course.service.CourseTestRelationService;




/**
 * 加入到课程区的，或课程区测试
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "加入到课程区的，或课程区测试 管理")
@RestController
@RequestMapping("course/coursetestrelation")
public class CourseTestRelationController {
    @Autowired
    private CourseTestRelationService courseTestRelationService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:coursetestrelation:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseTestRelationService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:coursetestrelation:info')")
    public Resp<CourseTestRelationEntity> info(@PathVariable("id") Long id){
		CourseTestRelationEntity courseTestRelation = courseTestRelationService.getById(id);

        return Resp.ok(courseTestRelation);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:coursetestrelation:save')")
    public Resp<Object> save(@RequestBody CourseTestRelationEntity courseTestRelation){
		courseTestRelationService.save(courseTestRelation);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:coursetestrelation:update')")
    public Resp<Object> update(@RequestBody CourseTestRelationEntity courseTestRelation){
		courseTestRelationService.updateById(courseTestRelation);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursetestrelation:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseTestRelationService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
