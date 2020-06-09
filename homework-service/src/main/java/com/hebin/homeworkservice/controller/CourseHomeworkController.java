package com.hebin.homeworkservice.controller;

import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.homeworkservice.DTO.HomeworkDetailDTO;
import com.hebin.homeworkservice.VO.HomeworkVO;
import com.hebin.homeworkservice.VO.ImportHomeworkVO;
import com.hebin.homeworkservice.entity.CourseHomeworkEntity;
import com.hebin.homeworkservice.service.CourseHomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 课程与作业
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "作业微服务")
@RestController
@RequestMapping("homework/coursehomework")
public class CourseHomeworkController {
    @Autowired
    private CourseHomeworkService courseHomeworkService;
    /**
     * 权限：教师，学生
     * 获取课程作业列表
     */
    @ApiOperation("获取课程作业列表")
    @GetMapping("/list/homework/{courseId}")
    @PreAuthorize("hasAuthority('course:coursehomework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition,@PathVariable("courseId") String courseId)
    {
        //学生和教师都可以获取
        PageVo page = courseHomeworkService.getCourseHomeworkList(queryCondition,courseId);
        return Resp.ok(page);
    }
    /**
     * 作业详情查看
     */
    @ApiOperation("作业详情查看")
    @GetMapping("/detail/homework")
    @PreAuthorize("hasAuthority('course:coursehomework:info')")
    public Resp<HomeworkDetailDTO> detailHomework(@RequestParam("homeworkid") String homeworkId, @RequestParam("courseid") String courseId){
        //在课程端的作业详情查看应该是可以看到开始时间，截止时间，是否可以延迟提交等信息
        //所以要进行封装
        HomeworkDetailDTO homeworkDetailDTO = courseHomeworkService.getHomeworkDetail(homeworkId,courseId);
        return Resp.ok(homeworkDetailDTO);
    }
    /**
     * 权限：教师
     * 发布作业
     * 直接发布
     */
    @ApiOperation("发布作业")
    @PostMapping("/create/coursehomework")
    @PreAuthorize("hasAuthority('course:coursehomework:save')")
    public Resp<Object> createCourseHomework(@RequestBody HomeworkVO homeworkVO){

		courseHomeworkService.createCourseHomework(homeworkVO);

        return Resp.ok(null);
    }
    /**
     * 从备课区引入作业
     */
    @ApiOperation("引入作业")
    @PostMapping("/import/coursehomework")
    @PreAuthorize("hasAuthority('course:coursehomework:save')")
    public Resp<Object> importCourseHomework(@RequestBody ImportHomeworkVO importHomeworkVO){

        courseHomeworkService.importCourseHomework(importHomeworkVO);

        return Resp.ok(null);
    }
    /**
     * 权限：教师
     * 修改作业信息
     */
    @ApiOperation("修改作业信息")
    @PostMapping("/updat/homework")
    @PreAuthorize("hasAuthority('course:coursehomework:update')")
    public Resp<Object> update(@RequestBody CourseHomeworkEntity courseHomework){
		courseHomeworkService.updateById(courseHomework);
        return Resp.ok("sucsess");
    }
    /**
     * 权限：教师
     * 删除作业
     */
    @ApiOperation("删除作业")
    @PostMapping("/delete/homework")
    @PreAuthorize("hasAuthority('course:coursehomework:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		courseHomeworkService.removeByIds(Arrays.asList(ids));
        return Resp.ok(null);
    }
}
