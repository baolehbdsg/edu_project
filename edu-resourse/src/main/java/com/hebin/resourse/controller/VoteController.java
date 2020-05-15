/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.controller;

import java.util.Arrays;


import com.hebin.resourse.entity.VoteEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.resourse.service.VoteService;




/**
 * ͶƱ
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = "ͶƱ 管理")
@RestController
@RequestMapping("resourse/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:vote:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = voteService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{choiceId}")
    @PreAuthorize("hasAuthority('resourse:vote:info')")
    public Resp<VoteEntity> info(@PathVariable("choiceId") Long choiceId){
		VoteEntity vote = voteService.getById(choiceId);

        return Resp.ok(vote);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:vote:save')")
    public Resp<Object> save(@RequestBody VoteEntity vote){
		voteService.save(vote);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:vote:update')")
    public Resp<Object> update(@RequestBody VoteEntity vote){
		voteService.updateById(vote);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:vote:delete')")
    public Resp<Object> delete(@RequestBody Long[] choiceIds){
		voteService.removeByIds(Arrays.asList(choiceIds));

        return Resp.ok(null);
    }

}
