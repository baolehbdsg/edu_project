package com.hebin.course.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.bbs.DTO.CoursebbsDTO;
import com.hebin.core.bean.*;

import com.hebin.course.VO.CourseStuVO;
import com.hebin.course.VO.DeleteCourseStuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.CourseStuEntity;
import com.hebin.course.service.CourseStuService;




/**
 * 课程与学生
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程与学生")
@RestController
@RequestMapping("course/coursestu")
public class CourseStuController {
    @Autowired
    private CourseStuService courseStuService;

    /**
     * 学生查看已选课程信息
     */
    @ApiOperation("学生查看已选课程列表")
    @GetMapping("/liststucourseinfo/{userId}")
    @PreAuthorize("hasAuthority('course:coursestu:info')")
    public Resp<Object> info(QueryCondition queryCondition,@PathVariable("userId") String userId){

        PageVo pageVo = courseStuService.getListStuCourse(queryCondition,userId);
        return Resp.ok(pageVo);
    }

    /**
     * 学生选课
     */
    @ApiOperation("学生选课")
    @PostMapping("/elective")
    @PreAuthorize("hasAuthority('course:coursestu:save')")
    public Resp<Object> elective(@RequestBody CourseStuVO courseStuVO){
        CourseStuEntity courseStuEntity = new CourseStuEntity();
        courseStuEntity.setCourseId(courseStuVO.getCourseId());
        courseStuEntity.setUserId(courseStuVO.getStuId());
		courseStuService.save(courseStuEntity);
        return Resp.ok("选课成功");
    }

//    /**
//     * 修改学生信息--
//     */
//    @ApiOperation("修改学生信息")
//    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('course:coursestu:update')")
//    public Resp<Object> update(@RequestBody CourseStuEntity courseStu){
//		courseStuService.updateById(courseStu);
//
//        return Resp.ok(null);
//    }
    /**
     * 删除学生
     */
    @ApiOperation("删除当前已选课学生")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursestu:delete')")
    public Resp<Object> delete(@RequestBody DeleteCourseStuVO deleteCourseStuVO){
        if(courseStuService.deleteCourseStu(deleteCourseStuVO)) return Resp.ok("删除成功");
        else return Resp.fail("删除失败");


    }
    /**
     * 查询选课学生情况
     */
    @ApiOperation("查询选课学生列表")
    @GetMapping("/electivestudent/{courseId}")
    @PreAuthorize("hasAuthority('course:course:delete')")
    public Resp<Object> electiveStudent(QueryCondition queryCondition,@PathVariable("courseId") String courseId){
        //应该是返回查出来的学生的基本信息加上小组名称，小组序号
        PageVo pageVo=courseStuService.getListCourseStu(queryCondition,courseId);

        return Resp.ok(pageVo);
    }

}
