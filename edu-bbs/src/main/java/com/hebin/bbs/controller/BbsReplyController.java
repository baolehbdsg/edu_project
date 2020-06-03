/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.controller;

import java.util.Arrays;


import com.hebin.bbs.entity.BbsReplyEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.bbs.service.BbsReplyService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 */
@Api(tags = "回复 管理")
@RestController
@EnableSwagger2
@RequestMapping("bbs/bbsreply")
public class BbsReplyController {
    @Autowired
    private BbsReplyService bbsReplyService;



    /**
     * 查看该贴下的次级回复
     */
    @ApiOperation("次级回复查询")
    @GetMapping("/info/{replyId}")
    @PreAuthorize("hasAuthority('bbs:bbsreply:info')")
    public Resp<BbsReplyEntity> info(@PathVariable("replyId") Long replyId){
		BbsReplyEntity bbsReply = bbsReplyService.getById(replyId);

        return Resp.ok(bbsReply);
    }

    /**
     * 发表评论
     */
    @ApiOperation("发表评论")
    @PostMapping("/pushreply")
    @PreAuthorize("hasAuthority('bbs:bbsreply:save')")
    public Resp<Object> pushReply(@RequestBody BbsReplyEntity bbsReply){
		bbsReplyService.save(bbsReply);
        return Resp.ok(null);
    }


    /**
     * 删除回复
     * 要加权限
     * 先这样写
     */
    @ApiOperation("删除回复，次级回复也要删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('bbs:bbsreply:delete')")
    public Resp<Object> delete(@RequestBody String[] replyIds){
		bbsReplyService.removeByIds(Arrays.asList(replyIds));
        return Resp.ok(null);
    }

}
