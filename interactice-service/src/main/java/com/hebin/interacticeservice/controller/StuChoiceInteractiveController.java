/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.controller;

import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.interacticeservice.entity.StuChoiceInteractiveEntity;
import com.hebin.interacticeservice.service.StuChoiceInteractiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 学生互动选择
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@Api(tags = "学生互动选择题作答情况")
@RestController
@RequestMapping("interactive/stuchoiceinteractive")
public class StuChoiceInteractiveController {
    @Autowired
    private StuChoiceInteractiveService stuChoiceInteractiveService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('student:stuchoiceinteractive:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = stuChoiceInteractiveService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('student:stuchoiceinteractive:info')")
    public Resp<StuChoiceInteractiveEntity> info(@PathVariable("id") Long id){
		StuChoiceInteractiveEntity stuChoiceInteractive = stuChoiceInteractiveService.getById(id);

        return Resp.ok(stuChoiceInteractive);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('student:stuchoiceinteractive:save')")
    public Resp<Object> save(@RequestBody StuChoiceInteractiveEntity stuChoiceInteractive){
		stuChoiceInteractiveService.save(stuChoiceInteractive);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('student:stuchoiceinteractive:update')")
    public Resp<Object> update(@RequestBody StuChoiceInteractiveEntity stuChoiceInteractive){
		stuChoiceInteractiveService.updateById(stuChoiceInteractive);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('student:stuchoiceinteractive:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		stuChoiceInteractiveService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
