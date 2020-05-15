/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.controller;

import java.util.Arrays;


import com.hebin.student.entity.StuTestQaEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.student.service.StuTestQaService;




/**
 * 简答题作答情况
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:00
 */
@Api(tags = "简答题作答情况 管理")
@RestController
@RequestMapping("student/stutestqa")
public class StuTestQaController {
    @Autowired
    private StuTestQaService stuTestQaService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('student:stutestqa:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = stuTestQaService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('student:stutestqa:info')")
    public Resp<StuTestQaEntity> info(@PathVariable("id") Long id){
		StuTestQaEntity stuTestQa = stuTestQaService.getById(id);

        return Resp.ok(stuTestQa);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('student:stutestqa:save')")
    public Resp<Object> save(@RequestBody StuTestQaEntity stuTestQa){
		stuTestQaService.save(stuTestQa);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('student:stutestqa:update')")
    public Resp<Object> update(@RequestBody StuTestQaEntity stuTestQa){
		stuTestQaService.updateById(stuTestQa);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('student:stutestqa:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		stuTestQaService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
