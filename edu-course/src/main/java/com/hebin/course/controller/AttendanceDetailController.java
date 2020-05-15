/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.controller;

import java.util.Arrays;


import com.hebin.course.entity.AttendanceDetailEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.service.AttendanceDetailService;




/**
 * 考勤详情
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "考勤详情 管理")
@RestController
@RequestMapping("course/attendancedetail")
public class AttendanceDetailController {
    @Autowired
    private AttendanceDetailService attendanceDetailService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:attendancedetail:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = attendanceDetailService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:attendancedetail:info')")
    public Resp<AttendanceDetailEntity> info(@PathVariable("id") Long id){
		AttendanceDetailEntity attendanceDetail = attendanceDetailService.getById(id);

        return Resp.ok(attendanceDetail);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:attendancedetail:save')")
    public Resp<Object> save(@RequestBody AttendanceDetailEntity attendanceDetail){
		attendanceDetailService.save(attendanceDetail);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:attendancedetail:update')")
    public Resp<Object> update(@RequestBody AttendanceDetailEntity attendanceDetail){
		attendanceDetailService.updateById(attendanceDetail);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:attendancedetail:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		attendanceDetailService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
