package com.hebin.course.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.AttendanceDetailEntity;
import com.hebin.course.service.AttendanceDetailService;




/**
 * 考勤详情
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "考勤详情 管理")
@RestController
@RequestMapping("course/attendancedetail")
public class AttendanceDetailController {
    @Autowired
    private AttendanceDetailService attendanceDetailService;

    /**
     * 权限：教师
     * 查看该考勤下打卡学生表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list/{attendenceId}")
    @PreAuthorize("hasAuthority('course:attendancedetail:list')")
    public Resp<PageVo> list(QueryCondition queryCondition,@PathVariable("attendenceId") String attendenceId) {
        PageVo page = attendanceDetailService.getAttendenceDetailList(queryCondition,attendenceId);

        return Resp.ok(page);
    }


//    /**
//     * 信息
//     */
//    @ApiOperation("详情查询")
//    @GetMapping("/info/{id}")
//    @PreAuthorize("hasAuthority('course:attendancedetail:info')")
//    public Resp<AttendanceDetailEntity> info(@PathVariable("id") Long id){
//		AttendanceDetailEntity attendanceDetail = attendanceDetailService.getById(id);
//
//        return Resp.ok(attendanceDetail);
//    }

    /**
     * 权限：学生
     * 学生执行考勤
     */
    @ApiOperation("学生执行考勤")
    @PostMapping("/exeattendence")
    @PreAuthorize("hasAuthority('course:attendancedetail:save')")
    public Resp<Object> exeAttendence(@RequestBody AttendanceDetailEntity attendanceDetail){
        //通过token获取学生Id
        String userID = "888";
        attendanceDetail.setUserId(userID);
		if(attendanceDetailService.save(attendanceDetail))return Resp.ok("打卡成功");
        else return Resp.fail("打卡失败");
    }

    /**
     * 权限：教师
     * 修改学生签到信息
     */
    @ApiOperation("修改学生签到信息")
    @PostMapping("/updateattendancedetail")
    @PreAuthorize("hasAuthority('course:attendancedetail:update')")
    public Resp<Object> update(@RequestBody AttendanceDetailEntity attendanceDetail){
		attendanceDetailService.updateById(attendanceDetail);
        return Resp.ok(null);
    }

    /**
     * 权限：教师
     * 删除学生打卡信息
     */
    @ApiOperation("删除学生签到信息")
    @PostMapping("/deleteattendancedetail")
    @PreAuthorize("hasAuthority('course:attendancedetail:delete')")
    public Resp<Object> delete(@RequestBody String[] attendancedetailIds){
		attendanceDetailService.removeByIds(Arrays.asList(attendancedetailIds));
        return Resp.ok(null);
    }

}
