/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.controller;

import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.testservice.entity.StuTestChoiceEntity;
import com.hebin.testservice.service.StuTestChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 选择题作答情况
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@Api(tags = "学生测试选择题答题情况 管理")
@RestController
@RequestMapping("test/stutestchoice")
public class StuTestChoiceController {
    @Autowired
    private StuTestChoiceService stuTestChoiceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('student:stutestchoice:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = stuTestChoiceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('student:stutestchoice:info')")
    public Resp<StuTestChoiceEntity> info(@PathVariable("id") Long id){
		StuTestChoiceEntity stuTestChoice = stuTestChoiceService.getById(id);

        return Resp.ok(stuTestChoice);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('student:stutestchoice:save')")
    public Resp<Object> save(@RequestBody StuTestChoiceEntity stuTestChoice){
		stuTestChoiceService.save(stuTestChoice);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('student:stutestchoice:update')")
    public Resp<Object> update(@RequestBody StuTestChoiceEntity stuTestChoice){
		stuTestChoiceService.updateById(stuTestChoice);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('student:stutestchoice:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		stuTestChoiceService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
