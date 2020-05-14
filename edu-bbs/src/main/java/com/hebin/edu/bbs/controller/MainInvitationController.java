package com.hebin.edu.bbs.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.bbs.entity.MainInvitationEntity;
import com.hebin.edu.bbs.service.MainInvitationService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("bbs/maininvitation")
public class MainInvitationController {
    @Autowired
    private MainInvitationService mainInvitationService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('bbs:maininvitation:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = mainInvitationService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{invitationId}")
    @PreAuthorize("hasAuthority('bbs:maininvitation:info')")
    public Resp<MainInvitationEntity> info(@PathVariable("invitationId") Long invitationId){
		MainInvitationEntity mainInvitation = mainInvitationService.getById(invitationId);

        return Resp.ok(mainInvitation);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('bbs:maininvitation:save')")
    public Resp<Object> save(@RequestBody MainInvitationEntity mainInvitation){
		mainInvitationService.save(mainInvitation);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('bbs:maininvitation:update')")
    public Resp<Object> update(@RequestBody MainInvitationEntity mainInvitation){
		mainInvitationService.updateById(mainInvitation);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('bbs:maininvitation:delete')")
    public Resp<Object> delete(@RequestBody Long[] invitationIds){
		mainInvitationService.removeByIds(Arrays.asList(invitationIds));

        return Resp.ok(null);
    }

}
