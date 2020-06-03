/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.controller;

import java.util.Arrays;


import com.hebin.bbs.entity.MainInvitationEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.bbs.service.MainInvitationService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 */
@Api(tags = "主贴 管理")
@RestController
@RequestMapping("bbs/maininvitation")
public class MainInvitationController {
    @Autowired
    private MainInvitationService mainInvitationService;
    /**
     * 列表
     */
    @ApiOperation("查看论坛内帖子列表")
    @GetMapping("/listInvitation")
    @PreAuthorize("hasAuthority('bbs:maininvitation:list')")
    public Resp<PageVo> listInvitation(QueryCondition queryCondition,String bbsId) {

       PageVo pageVo= mainInvitationService.getInvitationList(queryCondition,bbsId);
        return Resp.ok(pageVo);
    }
    /**
     * 查看帖子详情
     * 返回主回复列表
     * 并将人名等进行显示（其实可以异步加载）
     *
     */
    @ApiOperation("点击帖子查看详情")
    @GetMapping("/info/{invitationId}")
    @PreAuthorize("hasAuthority('bbs:maininvitation:info')")
    public Resp<Object> info(QueryCondition params,@PathVariable("invitationId") String invitationId){
//		MainInvitationEntity mainInvitation = mainInvitationService.getById(invitationId);
        PageVo pageVo = mainInvitationService.getReplyDetailList(params,invitationId);

        return Resp.ok(pageVo);
    }
    /**
     * 保存
     */
    @ApiOperation("发帖")
    @PostMapping("/sendInvitation")
    @PreAuthorize("hasAuthority('bbs:maininvitation:save')")
    public Resp<Object> sendInvitation(@RequestBody MainInvitationEntity mainInvitation){
		mainInvitationService.save(mainInvitation);
        return Resp.ok(null);
    }
    /**
     * 修改，修改之前要权限校验
     */
    @ApiOperation("修改帖子")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('bbs:maininvitation:update')")
    public Resp<Object> update(@RequestBody MainInvitationEntity mainInvitation){
		mainInvitationService.updateById(mainInvitation);
        return Resp.ok(null);
    }

    /**
     * 删除，删除之前也要权限校验
     */
    @ApiOperation("删除帖子")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('bbs:maininvitation:delete')")
    public Resp<Object> delete(@RequestBody String[] invitationIds){
		mainInvitationService.removeByIds(Arrays.asList(invitationIds));
        return Resp.ok(null);
    }

}
