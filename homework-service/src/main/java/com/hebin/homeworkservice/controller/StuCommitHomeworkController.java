/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.homeworkservice.VO.CorrectVO;
import com.hebin.homeworkservice.VO.RepulseVO;
import com.hebin.homeworkservice.entity.CourseHomeworkEntity;
import com.hebin.homeworkservice.entity.StuCommitHomeworkEntity;
import com.hebin.homeworkservice.service.CourseHomeworkService;
import com.hebin.homeworkservice.service.StuCommitHomeworkService;
import com.hebin.resourse.entity.HomeworkEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * 学生与作业
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@Api(tags = "学生提交作业情况")
@RestController
@RequestMapping("homework/stucommithomework")
public class StuCommitHomeworkController {
    @Autowired
    private StuCommitHomeworkService stuCommitHomeworkService;
    @Autowired
    private CourseHomeworkService courseHomeworkService;
    /**
     * 教师权限
     * 查看学生已经提交列表
     */
    @ApiOperation("查看学生已经提交列表")
    @GetMapping("/list/{homeworkId}")
    @PreAuthorize("hasAuthority('student:stucommithomework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition,@PathVariable("homeworkId") String homeworkId) {
        //homeworkId
        IPage<StuCommitHomeworkEntity> page = new Query<StuCommitHomeworkEntity>().getPage(queryCondition);
        QueryWrapper<StuCommitHomeworkEntity> qw = new QueryWrapper<>();
        qw.and(i->i.eq("homework_id",homeworkId).eq("is_commit",1));
        stuCommitHomeworkService.page(page,qw);
        return Resp.ok(new PageVo(page));
    }
    /**
     * 学生
     * 学生查看已提交作业
     * 测试状态：通过
     * 后续：需要改进
     */
    @ApiOperation("学生查看已提交作业")
    @GetMapping("/info/{homeworkId}")
    @PreAuthorize("hasAuthority('student:stucommithomework:info')")
    public Resp<StuCommitHomeworkEntity> info(@PathVariable("homeworkId") String homeworkId){
        String userId="111";
        QueryWrapper<StuCommitHomeworkEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("user_id",userId).eq("homework_id",homeworkId));
		StuCommitHomeworkEntity stuCommitHomework = stuCommitHomeworkService.getOne(queryWrapper);
        return Resp.ok(stuCommitHomework);
    }
    /**
     * 提交作业
     * 测试状态：通过
     * 首次提交
     */
    @ApiOperation("提交作业")
    @PostMapping("/commithomework")
    @PreAuthorize("hasAuthority('student:stucommithomework:save')")
    public Resp<Object> commithomework(@RequestBody StuCommitHomeworkEntity stuCommitHomework){
        //先判断该作业是否可以迟交
        QueryWrapper<CourseHomeworkEntity> queryWrapper = new QueryWrapper();
        queryWrapper.eq("homework_id",stuCommitHomework.getHomeworkId());
        CourseHomeworkEntity courseHomeworkEntity= courseHomeworkService.getOne(queryWrapper);
        Integer can_delay= courseHomeworkEntity.getCanDelay();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //当前时间
        Date nowTime =new Date();
        Date deadline = courseHomeworkEntity.getDeadline();
        if(can_delay!=0){
            //判断提交时间是否超时
            if(nowTime.compareTo(deadline)==1)stuCommitHomework.setIsDelay(1);
            String userId = "111";
            stuCommitHomework.setUserId(userId);
            stuCommitHomework.setIsCommit(1);
            stuCommitHomework.setCommitTimes(1);
            stuCommitHomeworkService.save(stuCommitHomework);
            return Resp.ok("提交成功");
        }
        else{

            if(nowTime.compareTo(deadline)==1) return Resp.fail("已经超时不能再提交");
            else
            {
                String userId = "111";
                stuCommitHomework.setUserId(userId);
                stuCommitHomework.setIsCommit(1);
                stuCommitHomework.setCommitTimes(1);
                stuCommitHomeworkService.save(stuCommitHomework);
                return Resp.ok("提交成功");
            }
        }

    }
    /**
     * 权限：学生（个人）
     * 修改作业（重复提交）
     * 测试状态：通过
     *
     */
    @ApiOperation("学生作业修改（重复提交）")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('student:stucommithomework:update')")
    public Resp<Object> update(@RequestBody StuCommitHomeworkEntity stuCommitHomework){
        //先获取这个作业是否可以迟交的状态
        QueryWrapper<CourseHomeworkEntity> queryWrapper = new QueryWrapper();
        queryWrapper.eq("homework_id",stuCommitHomework.getHomeworkId());
        CourseHomeworkEntity courseHomeworkEntity= courseHomeworkService.getOne(queryWrapper);
        Integer can_delay= courseHomeworkEntity.getCanDelay();
        //当前时间
        Date nowTime =new Date();
        Date deadline = courseHomeworkEntity.getDeadline();
        //先判断该作业是否可以迟交
        if(can_delay!=0) {
            //判断提交时间是否超时
            if(nowTime.compareTo(deadline)==1)stuCommitHomework.setIsDelay(1);
            QueryWrapper<StuCommitHomeworkEntity> qw = new QueryWrapper<>();
            qw.and(i -> i.eq("user_id", stuCommitHomework.getUserId()).eq("homework_id", stuCommitHomework.getHomeworkId()));
            //提交次数加一
            stuCommitHomework.setCommitTimes(stuCommitHomework.getCommitTimes() + 1);
            if (stuCommitHomeworkService.update(stuCommitHomework, qw)) return Resp.ok("更新提交成功");
            else return Resp.ok("更新提交失败");
        }else
        {
            if(nowTime.compareTo(deadline)==1) return Resp.fail("已经超时不能再提交");
            QueryWrapper<StuCommitHomeworkEntity> qw = new QueryWrapper<>();
            qw.and(i -> i.eq("user_id", stuCommitHomework.getUserId()).eq("homework_id", stuCommitHomework.getHomeworkId()));
            //提交次数加一
            stuCommitHomework.setCommitTimes(stuCommitHomework.getCommitTimes() + 1);
            if (stuCommitHomeworkService.update(stuCommitHomework, qw)) return Resp.ok("提交成功");
            else return Resp.ok("提交失败");
        }
    }
    /**
     * 权限教师
     * 打回作业
     * 测试状态：通过
     */
    @ApiOperation("打回作业")
    @PostMapping("/repulse")
    @PreAuthorize("hasAuthority('student:stucommithomework:delete')")
    public Resp<Object> repulse(@RequestBody RepulseVO repulseVO){
//		stuCommitHomeworkService.removeByIds(Arrays.asList(ids));
//      UpdateWrapper<StuCommitHomeworkEntity> up = new UpdateWrapper<>();
        QueryWrapper<StuCommitHomeworkEntity> qw = new QueryWrapper<>();
        StuCommitHomeworkEntity stuCommitHomeworkEntity = new StuCommitHomeworkEntity();

            qw.and(i->i.in("user_id",repulseVO.getUserIds().toArray()).eq("homework_id",repulseVO.getHomeworkIds()));
            stuCommitHomeworkEntity.setId(0L);
            stuCommitHomeworkEntity.setIsCommit(0);
            stuCommitHomeworkEntity.setCommitTime(null);
            stuCommitHomeworkService.update(stuCommitHomeworkEntity,qw);
        return Resp.ok(null);
    }
    /**
     * 权限教师
     * 批改作业,可以批量给分
     * 测试状态：通过
     */
    @ApiOperation("批改作业")
    @PostMapping("/homeworkcrrect")
    @PreAuthorize("hasAuthority('student:stucommithomework:delete')")
    public Resp<Object> homeworkcrrect(@RequestBody CorrectVO correctVO)
    {
        //如果List长度大于1，那么就是批量给分
        //否则就是给个人分
        QueryWrapper<StuCommitHomeworkEntity> qw = new QueryWrapper<>();
        StuCommitHomeworkEntity stuCommitHomeworkEntity = new StuCommitHomeworkEntity();
        qw.and(i->i.in("user_id",correctVO.getUserIds()).eq("homework_id",correctVO.getHomeworkId()));
        stuCommitHomeworkEntity.setId(0L);
        stuCommitHomeworkEntity.setScore(correctVO.getScore());
        stuCommitHomeworkService.update(stuCommitHomeworkEntity,qw);
        return Resp.ok("批改成功");
    }
}
