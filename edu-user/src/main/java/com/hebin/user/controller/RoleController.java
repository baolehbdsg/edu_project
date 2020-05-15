/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;

import java.util.Arrays;


import com.hebin.user.entity.RoleEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.user.service.RoleService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
@Api(tags = "角色 管理")
@RestController
@RequestMapping("user/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('user:role:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = roleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{roleId}")
    @PreAuthorize("hasAuthority('user:role:info')")
    public Resp<RoleEntity> info(@PathVariable("roleId") Integer roleId){
		RoleEntity role = roleService.getById(roleId);

        return Resp.ok(role);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('user:role:save')")
    public Resp<Object> save(@RequestBody RoleEntity role){
		roleService.save(role);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:role:update')")
    public Resp<Object> update(@RequestBody RoleEntity role){
		roleService.updateById(role);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:role:delete')")
    public Resp<Object> delete(@RequestBody Integer[] roleIds){
		roleService.removeByIds(Arrays.asList(roleIds));

        return Resp.ok(null);
    }

}
