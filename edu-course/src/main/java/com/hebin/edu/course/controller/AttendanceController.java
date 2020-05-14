package com.hebin.edu.course.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.course.entity.AttendanceEntity;
import com.hebin.edu.course.service.AttendanceService;




/**
 * 考勤
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "考勤 管理")
@RestController
@RequestMapping("course/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:attendance:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = attendanceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{attendanceid}")
    @PreAuthorize("hasAuthority('course:attendance:info')")
    public Resp<AttendanceEntity> info(@PathVariable("attendanceid") Long attendanceid){
		AttendanceEntity attendance = attendanceService.getById(attendanceid);

        return Resp.ok(attendance);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:attendance:save')")
    public Resp<Object> save(@RequestBody AttendanceEntity attendance){
		attendanceService.save(attendance);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:attendance:update')")
    public Resp<Object> update(@RequestBody AttendanceEntity attendance){
		attendanceService.updateById(attendance);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:attendance:delete')")
    public Resp<Object> delete(@RequestBody Long[] attendanceids){
		attendanceService.removeByIds(Arrays.asList(attendanceids));

        return Resp.ok(null);
    }

}
