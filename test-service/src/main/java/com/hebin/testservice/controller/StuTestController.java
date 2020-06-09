/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.testservice.DTO.StuAchievementDetail;
import com.hebin.testservice.VO.StuCommitVO;
import com.hebin.testservice.entity.StuTestChoiceEntity;
import com.hebin.testservice.entity.StuTestQaEntity;
import com.hebin.testservice.feign.UserFeign;
import com.hebin.testservice.service.StuTestChoiceService;
import com.hebin.testservice.service.StuTestQaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学生接口")
@RestController
@RequestMapping("test/stu")
public class StuTestController {
    @Autowired
    StuTestQaService stuTestQaService;
    @Autowired
    StuTestChoiceService stuTestChoiceService;
    @Autowired
    UserFeign userFeign;
    /**
     * 学生提交测试
     * 测试状态：通过
     */
    @ApiOperation("学生提交测试")
    @PostMapping("/committest")
    public Resp<Object> commitTest(@RequestBody List<StuCommitVO> stuCommitVO){
        //判断有不有choiceType这个字段
        //如果有则存在stuTestChoice里头
        //如果没有就放到问答题那个里头
        //通过验证，获取学生id
        String stuId = "11";
        for(int i =0;i<stuCommitVO.size();i++)
        {
            if(stuCommitVO.get(i).getChoiceType()!=null)
            {
                StuTestChoiceEntity stuTestChoiceEntity = new StuTestChoiceEntity();
                stuTestChoiceEntity.setUserId(stuId);
                BeanUtils.copyProperties(stuCommitVO.get(i),stuTestChoiceEntity);
                stuTestChoiceEntity.setChoiceId(stuCommitVO.get(i).getSubjectId());
                if(stuTestChoiceService.save(stuTestChoiceEntity));
                else return Resp.ok("提交失败");
            }
            else
            {
                StuTestQaEntity stuTestQaEntity = new StuTestQaEntity();
                stuTestQaEntity.setUserId(stuId);
                BeanUtils.copyProperties(stuCommitVO.get(i),stuTestQaEntity);
                stuTestQaEntity.setQaId(stuCommitVO.get(i).getSubjectId());
                if(stuTestQaService.save(stuTestQaEntity));
                else return Resp.ok("提交失败");
            }
        }
        return Resp.fail("提交成功");
    }
    /*
    * 学生查看具体成绩
    * 测试状态：通过
    * */
    @ApiOperation("学生查看具体成绩")
    @GetMapping("/achievement")
    public Resp<Object> achievement(@RequestParam("testId") String testId)
    {
        String userId = "11";
        QueryWrapper<StuTestChoiceEntity> queryWrapperChoice = new QueryWrapper<>();
        QueryWrapper<StuTestQaEntity> queryWrapperQA  = new QueryWrapper<>();
        queryWrapperChoice.and(i->i.eq("test_id",testId).eq("user_id",userId));
        List<StuTestChoiceEntity> stuTestChoiceEntities = stuTestChoiceService.list(queryWrapperChoice);

        queryWrapperQA.and(i->i.eq("test_id",testId).eq("user_id",userId));
        List<StuTestQaEntity> stuTestQaEntities =stuTestQaService.list(queryWrapperQA);

        StuAchievementDetail stuAchievementDetail = new StuAchievementDetail();
        stuAchievementDetail.setStuTestChoiceEntities(stuTestChoiceEntities);
        stuAchievementDetail.setStuTestQaEntities(stuTestQaEntities);
        return Resp.ok(stuAchievementDetail);
    }
}
