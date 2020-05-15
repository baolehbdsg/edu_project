/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.controller;

import java.util.Arrays;


import com.hebin.user.entity.AdminEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.user.service.AdminService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("user/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('user:admin:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = adminService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{adminId}")
    @PreAuthorize("hasAuthority('user:admin:info')")
    public Resp<AdminEntity> info(@PathVariable("adminId") Integer adminId){
		AdminEntity admin = adminService.getById(adminId);

        return Resp.ok(admin);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('user:admin:save')")
    public Resp<Object> save(@RequestBody AdminEntity admin){
		adminService.save(admin);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:admin:update')")
    public Resp<Object> update(@RequestBody AdminEntity admin){
		adminService.updateById(admin);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:admin:delete')")
    public Resp<Object> delete(@RequestBody Integer[] adminIds){
		adminService.removeByIds(Arrays.asList(adminIds));

        return Resp.ok(null);
    }

}
