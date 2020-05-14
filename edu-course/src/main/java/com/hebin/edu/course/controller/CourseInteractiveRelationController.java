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

import com.hebin.edu.course.entity.CourseInteractiveRelationEntity;
import com.hebin.edu.course.service.CourseInteractiveRelationService;




/**
 * 课程与互动关系
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "课程与互动关系 管理")
@RestController
@RequestMapping("course/courseinteractiverelation")
public class CourseInteractiveRelationController {
    @Autowired
    private CourseInteractiveRelationService courseInteractiveRelationService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseInteractiveRelationService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:info')")
    public Resp<CourseInteractiveRelationEntity> info(@PathVariable("id") Long id){
		CourseInteractiveRelationEntity courseInteractiveRelation = courseInteractiveRelationService.getById(id);

        return Resp.ok(courseInteractiveRelation);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:save')")
    public Resp<Object> save(@RequestBody CourseInteractiveRelationEntity courseInteractiveRelation){
		courseInteractiveRelationService.save(courseInteractiveRelation);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:update')")
    public Resp<Object> update(@RequestBody CourseInteractiveRelationEntity courseInteractiveRelation){
		courseInteractiveRelationService.updateById(courseInteractiveRelation);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseInteractiveRelationService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
