package com.hebin.course.controller;

import java.util.Arrays;


import com.hebin.core.bean.*;

import com.hebin.course.service.AttendanceDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.AttendanceEntity;
import com.hebin.course.service.AttendanceService;




/**
 * 考勤
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "考勤管理")
@RestController
@RequestMapping("course/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private AttendanceDetailService attendanceDetailService;
    /**
     * 教师
     * 查看课程内发布的考勤列表
     *
     */
    @ApiOperation("查看发布的考勤列表")
    @GetMapping("/listattendence/{courseId}")
    @PreAuthorize("hasAuthority('course:attendance:list')")
    public Resp<PageVo> listAttendence(QueryCondition queryCondition,@PathVariable("courseId") String courseId) {
        PageVo page = attendanceService.getlistpage(queryCondition,courseId);
        return Resp.ok(page);
    }


    /**
     * 获取考勤详情
     * 都可以看
     */
    @ApiOperation("详情查询")
    @GetMapping("/detail/{attendanceid}")
    @PreAuthorize("hasAuthority('course:attendance:info')")
    public Resp<AttendanceEntity> detail(@PathVariable("attendanceid")  String attendanceid){
		AttendanceEntity attendance = attendanceService.getById(attendanceid);
        return Resp.ok(attendance);
    }

    /**
     * 发布考勤
     */
    @ApiOperation("发布考勤")
    @PostMapping("/publishattendence")
    @PreAuthorize("hasAuthority('course:attendance:save')")
    public Resp<Object> publishAttendence(@RequestBody AttendanceEntity attendance){
        //校验权限
		attendanceService.save(attendance);
        return Resp.ok(null);
    }
    /**
     * 先获取权限，再修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:attendance:update')")
    public Resp<Object> update(@RequestBody AttendanceEntity attendance){
        //校验权限
		attendanceService.updateById(attendance);
        return Resp.ok(null);
    }

    /**
     * 删除考勤
     *
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:attendance:delete')")
    public Resp<Object> delete(@RequestBody String[] attendanceids){
        //获取token验证权限
        //然后再删除
		if(attendanceService.removeByIds(Arrays.asList(attendanceids)))return Resp.ok("删除成功");
        else return Resp.ok("删除失败");
    }

}
