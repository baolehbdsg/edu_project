/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.controller;

import java.util.Arrays;


import com.hebin.lesson.entity.TeacherResourceEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.lesson.service.TeacherResourceService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = "教师与字资源 管理")
@RestController
@RequestMapping("lesson/teacherresource")
public class TeacherResourceController {
    @Autowired
    private TeacherResourceService teacherResourceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('lesson:teacherresource:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = teacherResourceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('lesson:teacherresource:info')")
    public Resp<TeacherResourceEntity> info(@PathVariable("id") Long id){
		TeacherResourceEntity teacherResource = teacherResourceService.getById(id);

        return Resp.ok(teacherResource);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('lesson:teacherresource:save')")
    public Resp<Object> save(@RequestBody TeacherResourceEntity teacherResource){
		teacherResourceService.save(teacherResource);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('lesson:teacherresource:update')")
    public Resp<Object> update(@RequestBody TeacherResourceEntity teacherResource){
		teacherResourceService.updateById(teacherResource);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('lesson:teacherresource:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		teacherResourceService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
