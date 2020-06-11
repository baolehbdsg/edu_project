/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.Resp;
import com.hebin.resourse.DTO.CreateChoiceDTO;
import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import com.hebin.testservice.DTO.StuAchievementDetail;
import com.hebin.testservice.DTO.StuCommitListDTO;
import com.hebin.testservice.DTO.StuInfo;
import com.hebin.testservice.VO.CreateChoiceVO;
import com.hebin.testservice.VO.CreateQaVO;
import com.hebin.testservice.entity.*;
import com.hebin.testservice.feign.ResourseFeign;
import com.hebin.testservice.feign.UserFeign;
import com.hebin.testservice.service.*;
import com.hebin.user.entity.StudentEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "教师操作接口")
@RestController
@RequestMapping("test/tea")
public class TeaTestController {
    @Autowired
    StuTestQaService stuTestQaService;
    @Autowired
    StuTestChoiceService stuTestChoiceService;
    @Autowired
    UserFeign userFeign;
    @Autowired
    TestEntityService testEntityService;
    @Autowired
    TestQaService testQaService;
    @Autowired
    TestChoiceService testChoiceService;
    @Autowired
    ResourseFeign resourseFeign;
    /*
     *自动批改
     */
    @ApiOperation("自动批改")
    @PostMapping("/autocorrect")
    public void autoCorrect()
    {
        //获取该测试的所有选择题提交
        //远程调用后到资源库进行查询
        //对的就给该题目对应的分数
        //错的就给0
    }
    /*
     * 教师手动对测试进行批改(只能一个题一个题)
     * 选择题更改分数
     * 给分就行，每次给分都会发送请求到后端，然后进行批改
     *
     */
    @ApiOperation("教师手动对测试进行批改(选择题)")
    @PostMapping("/teacorrectchoice")
    public Resp<Object> teaCorrectChoice(@RequestParam("userId") String userId,@RequestParam("testId") String testId
            ,@RequestParam("choice") String choiceId,@RequestParam("score") String score)
    {
        //修改分数要验证教师权限
        QueryWrapper<StuTestChoiceEntity> stuTestChoiceEntityQueryWrapper = new QueryWrapper<>();
        stuTestChoiceEntityQueryWrapper.and(i->i.eq("test_id",testId).eq("user_id",userId).eq("choice_id",choiceId));
        StuTestChoiceEntity stuTestChoiceEntity = new StuTestChoiceEntity();
        stuTestChoiceEntity.setScore(score);
        if(stuTestChoiceService.update(stuTestChoiceEntity,stuTestChoiceEntityQueryWrapper))return Resp.ok("批改成功");
        else return Resp.ok("失败");
    }
    /*
     * 教师手动对测试进行批改(只能一个题一个题)
     * 选择题更改分数
     * 给分就行，每次给分都会发送请求到后端，然后进行批改
     *
     */
    @ApiOperation("教师手动对测试进行批改(问答题)")
    @PostMapping("/teacorrectqa")
    public Resp<Object> teaCorrectQA(@RequestParam("userId") String userId,@RequestParam("testId") String testId
            ,@RequestParam("qaId") String qaId,@RequestParam("score") String score)
    {
        //修改分数要验证教师权限
        QueryWrapper<StuTestChoiceEntity> stuTestChoiceEntityQueryWrapper = new QueryWrapper<>();
        stuTestChoiceEntityQueryWrapper.and(i->i.eq("test_id",testId).eq("user_id",userId).eq("qa_id",qaId));
        StuTestChoiceEntity stuTestChoiceEntity = new StuTestChoiceEntity();
        stuTestChoiceEntity.setScore(score);
        if(stuTestChoiceService.update(stuTestChoiceEntity,stuTestChoiceEntityQueryWrapper))return Resp.ok("批改成功");
        else return Resp.ok("失败");
    }
    /*
     * 查看学生提交测试列表
     * 点击某个已经发布的测试，获取参与测试的人的列表,显示其姓名等信息
     * 权限：教师
     * */
    @ApiOperation("查看某个测试的提交列表")
    @GetMapping("/stucommitlist")
    public Resp<Object>  stuCommitList(@RequestParam("testId") String testId)
    {
        //代码去重
        //通过检索两个库中的所有学生，每个学生id只保留一次
        QueryWrapper<StuTestChoiceEntity> queryWrapperChoice = new QueryWrapper<>();
        QueryWrapper<StuTestQaEntity> queryWrapperQA = new QueryWrapper<>();
        List<String> userIds = new ArrayList<>();
        queryWrapperChoice.eq("test_id",testId);
        queryWrapperQA.eq("test_id",testId);
        List<StuTestChoiceEntity>stuTestChoiceEntities=stuTestChoiceService.list(queryWrapperChoice);
        List<StuTestQaEntity> stuTestQaEntities = stuTestQaService.list(queryWrapperQA);
        for(int i=0;i<stuTestChoiceEntities.size();i++)
        {
            if(userIds.contains(stuTestChoiceEntities.get(i).getUserId()))continue;
            else userIds.add(stuTestChoiceEntities.get(i).getUserId());
        }
        for(int i=0;i<stuTestQaEntities.size();i++)
        {
            if(userIds.contains(stuTestQaEntities.get(i).getUserId()))continue;
            else userIds.add(stuTestQaEntities.get(i).getUserId());
        }
        //将得到的id列表转换成id数组
        String[] useridss = new String[userIds.size()];
        for(int i=0;i<userIds.size();i++)
        {
            useridss[i] = userIds.get(i);
        }
        //远程调用获取user的信息
        List<StudentEntity> studentEntities =userFeign.userListByIds(useridss);
        StuCommitListDTO stuCommitListDTO = new StuCommitListDTO();
        //重新封装
        for(int i=0;i<studentEntities.size();i++)
        {
            StuInfo stuInfo = new StuInfo();
            stuInfo.setUserId(studentEntities.get(i).getUserId());
            stuInfo.setUserName(studentEntities.get(i).getUserName());
            stuInfo.setUserSid(studentEntities.get(i).getUserSid());
            stuCommitListDTO.getStuInfos().add(stuInfo);
        }
        QueryWrapper<TestEntityEntity> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("test_id",testId);
        TestEntityEntity testEntityEntity=testEntityService.getOne(queryWrapper);
        BeanUtils.copyProperties(testEntityEntity,stuCommitListDTO);
        return Resp.ok(stuCommitListDTO);
    }
    /*
     *  查看某个学生作答情况
     * */
    @ApiOperation("查看某个学生作答情况")
    @GetMapping("/stucommittestinfo")
    public Resp<Object>  stuCommitTestInfo(@RequestParam("userId") String userId,@RequestParam("testId") String testId)
    {
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
    /*
    *   未来提供基于题目的视角的查看
    * */
    /*
    *   测试内新增试题
    *   新增选择题
    *   前端每次保存都会进行一次保存
    *   保存的题目远程调用
    * */
    @ApiOperation("新建一个选择题")
    @PostMapping("/createchoice")
    public Resp<Object>  createChoice(@RequestBody CreateChoiceVO createChoiceVO)
    {
        //先要远程调用，保存到resource服务，并返回choiceId;
        //然后就保存到edu_test_choice中即可
        CreateChoiceDTO createChoiceDTO = new CreateChoiceDTO();
        BeanUtils.copyProperties(createChoiceVO,createChoiceDTO);
        String choiceId=resourseFeign.createChoice(createChoiceDTO);
        TestChoiceEntity testChoiceEntity = new TestChoiceEntity();
        BeanUtils.copyProperties(createChoiceVO,testChoiceEntity);
        testChoiceEntity.setChoiceId(choiceId);
        testChoiceService.save(testChoiceEntity);
        return Resp.fail("创建失败");
    }
    /*
    *
    * 如果是删除一个选择题，那么只用将其在这个关系中的isDelete置为1即可
    * 并且将一个只用删test_choice
    * 被删除的可以在回收站中被查看到
    *
    * */
    @ApiOperation("删除一个选择题")
    @PostMapping("/deletechoice")
    public Resp<Object>  deleteChoice(@RequestParam("testId") String testId,@RequestParam("choiceId") String choiceId)
    {
        //先要远程调用，保存到resource服务，并返回choiceId;
        QueryWrapper<TestChoiceEntity> testChoiceEntityQueryWrapper = new QueryWrapper<>();
        testChoiceEntityQueryWrapper.and(i->i.eq("test_id",testId).eq("choice_id",choiceId));
        TestChoiceEntity testChoiceEntity = new TestChoiceEntity();
        if(testChoiceService.remove(testChoiceEntityQueryWrapper))return Resp.ok("删除成功");
        return Resp.fail("删除失败");
    }
    /*
     *   测试内新增试题
     *   新增选择题
     *   前端每次保存都会进行一次保存
     *   保存的题目远程调用
     * */
    @ApiOperation("新建一个简答")
    @PostMapping("/createqa")
    public Resp<Object>  createQa(@RequestBody CreateQaVO createQaVO)
    {
        //先要远程调用，保存到resource服务，并返回choiceId;
        //然后就保存到edu_test_choice中即可
        QuestionsAndAnswersEntity questionsAndAnswersEntity  = new QuestionsAndAnswersEntity();
        BeanUtils.copyProperties(createQaVO,questionsAndAnswersEntity);
        String qaId=resourseFeign.createQa(questionsAndAnswersEntity);
        TestQaEntity testQaEntity = new TestQaEntity();
        BeanUtils.copyProperties(createQaVO,testQaEntity);
        testQaEntity.setQaId(qaId);
        testQaEntity.setIsDelete(0);
        testQaService.save(testQaEntity);
        return Resp.fail("创建失败");
    }
    /*
     *
     * 如果是删除一个简答，那么只用将其在这个关系中的isDelete置为1即可
     * 并且将一个只用删test_choice
     * 被删除的可以在回收站中被查看到
     *
     * */
    @ApiOperation("删除一个简答")
    @PostMapping("/deleteQa")
    public Resp<Object>  deleteQa(@RequestParam("testId") String testId,@RequestParam("qaId") String qaId)
    {
        //先要远程调用，保存到resource服务，并返回choiceId;
        QueryWrapper<TestQaEntity> testQaEntityQueryWrapper = new QueryWrapper<>();
        testQaEntityQueryWrapper.and(i->i.eq("test_id",testId).eq("qa_id",qaId));
        if(testQaService.remove(testQaEntityQueryWrapper))return Resp.ok("删除成功");
        return Resp.fail("删除失败");
    }

}
