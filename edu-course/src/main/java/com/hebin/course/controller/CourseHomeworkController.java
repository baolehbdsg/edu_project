package com.hebin.course.controller;

import java.util.Arrays;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.*;

import com.hebin.course.DTO.HomeworkDetailDTO;
import com.hebin.course.VO.HomeworkVO;
import com.hebin.course.VO.ImportHomeworkVO;
import com.hebin.course.entity.CourseHomeworkEntity;
import com.hebin.course.feign.Resoursefeign;
import com.hebin.resourse.entity.HomeworkEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.service.CourseHomeworkService;




/**
 * 课程与作业
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程与作业 管理")
@RestController
@RequestMapping("course/coursehomework")
public class CourseHomeworkController {
    @Autowired
    private CourseHomeworkService courseHomeworkService;
    @Autowired
    Resoursefeign resoursefeign;
    /**
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
    public Resp<HomeworkDetailDTO> detailHomework(@RequestParam("homeworkid") String homeworkId,@RequestParam("courseid") String courseId){
        //在课程端的作业详情查看应该是可以看到开始时间，截止时间，是否可以延迟提交等信息
        //所以要进行封装
        HomeworkEntity homeworkEntity=resoursefeign.getHomeworkDetail(homeworkId).getData();
        HomeworkDetailDTO homeworkDetailDTO  = new HomeworkDetailDTO();
        BeanUtils.copyProperties(homeworkEntity,homeworkDetailDTO);
        QueryWrapper<CourseHomeworkEntity> qw=new QueryWrapper<CourseHomeworkEntity>();
        qw.and(i -> i.eq("homework_id", homeworkId).eq("course_id", courseId));
        CourseHomeworkEntity courseHomeworkEntity=courseHomeworkService.getOne(qw);
        BeanUtils.copyProperties(courseHomeworkEntity,homeworkDetailDTO);
        return Resp.ok(homeworkDetailDTO);
    }

    /**
     * 发布作业
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
