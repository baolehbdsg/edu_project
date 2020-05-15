/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;

import java.util.Arrays;


import com.hebin.user.entity.UserRoleEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.user.service.UserRoleService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("user/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('user:userrole:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = userRoleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{userRoleId}")
    @PreAuthorize("hasAuthority('user:userrole:info')")
    public Resp<UserRoleEntity> info(@PathVariable("userRoleId") Long userRoleId){
		UserRoleEntity userRole = userRoleService.getById(userRoleId);

        return Resp.ok(userRole);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('user:userrole:save')")
    public Resp<Object> save(@RequestBody UserRoleEntity userRole){
		userRoleService.save(userRole);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:userrole:update')")
    public Resp<Object> update(@RequestBody UserRoleEntity userRole){
		userRoleService.updateById(userRole);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:userrole:delete')")
    public Resp<Object> delete(@RequestBody Long[] userRoleIds){
		userRoleService.removeByIds(Arrays.asList(userRoleIds));

        return Resp.ok(null);
    }

}
