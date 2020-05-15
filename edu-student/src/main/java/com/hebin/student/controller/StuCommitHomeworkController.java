/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.controller;

import java.util.Arrays;


import com.hebin.student.entity.StuCommitHomeworkEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.student.service.StuCommitHomeworkService;




/**
 * 学生与作业
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@Api(tags = "学生作业情况")
@RestController
@RequestMapping("student/stucommithomework")
public class StuCommitHomeworkController {
    @Autowired
    private StuCommitHomeworkService stuCommitHomeworkService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('student:stucommithomework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = stuCommitHomeworkService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('student:stucommithomework:info')")
    public Resp<StuCommitHomeworkEntity> info(@PathVariable("id") Long id){
		StuCommitHomeworkEntity stuCommitHomework = stuCommitHomeworkService.getById(id);

        return Resp.ok(stuCommitHomework);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('student:stucommithomework:save')")
    public Resp<Object> save(@RequestBody StuCommitHomeworkEntity stuCommitHomework){
		stuCommitHomeworkService.save(stuCommitHomework);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('student:stucommithomework:update')")
    public Resp<Object> update(@RequestBody StuCommitHomeworkEntity stuCommitHomework){
		stuCommitHomeworkService.updateById(stuCommitHomework);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('student:stucommithomework:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		stuCommitHomeworkService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
