/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.controller;

import java.util.Arrays;


import com.hebin.resourse.entity.MultipleChoiceEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.resourse.service.MultipleChoiceService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/multiplechoice")
public class MultipleChoiceController {
    @Autowired
    private MultipleChoiceService multipleChoiceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:multiplechoice:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = multipleChoiceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{choiceId}")
    @PreAuthorize("hasAuthority('resourse:multiplechoice:info')")
    public Resp<MultipleChoiceEntity> info(@PathVariable("choiceId") Long choiceId){
		MultipleChoiceEntity multipleChoice = multipleChoiceService.getById(choiceId);

        return Resp.ok(multipleChoice);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:multiplechoice:save')")
    public Resp<Object> save(@RequestBody MultipleChoiceEntity multipleChoice){
		multipleChoiceService.save(multipleChoice);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:multiplechoice:update')")
    public Resp<Object> update(@RequestBody MultipleChoiceEntity multipleChoice){
		multipleChoiceService.updateById(multipleChoice);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:multiplechoice:delete')")
    public Resp<Object> delete(@RequestBody Long[] choiceIds){
		multipleChoiceService.removeByIds(Arrays.asList(choiceIds));

        return Resp.ok(null);
    }

}
