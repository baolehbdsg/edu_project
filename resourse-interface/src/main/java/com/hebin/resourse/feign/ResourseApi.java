/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.feign;

import com.hebin.core.bean.Resp;
import com.hebin.resourse.DTO.ChoiceDTO;
import com.hebin.resourse.DTO.CreateChoiceDTO;
import com.hebin.resourse.DTO.QADTO;
import com.hebin.resourse.entity.HomeworkEntity;
import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ResourseApi {
    @ApiOperation("创建作业")
    @PostMapping("resourse/homework/publish/homework")
    public String publishHomework(@RequestBody HomeworkEntity homework);

    @ApiOperation("作业详情查询")
    @GetMapping("resourse/homework/gethomeworkdetail/{homeworkId}")
    public Resp<HomeworkEntity> getHomeworkDetail(@PathVariable("homeworkId") String homeworkId);

    @ApiOperation("远程调用,获取具体的选择题")
    @PostMapping("resourse/choicedetaillist")
    public List<ChoiceDTO> choiceDetailList(@RequestBody List<ChoiceDTO> choiceDTOS);

    @ApiOperation("远程调用,获取具体的简答题信息")
    @PostMapping("resourse/qadetaillist")
    public List<QADTO> qaDetailList(@RequestBody List<QADTO> qadtos);

    @ApiOperation("远程调用,新增/修改一个选择题")
    @PostMapping("resourse/createchoice")
    public String createChoice(@RequestBody CreateChoiceDTO createChoiceDTO);

    @ApiOperation("远程调用,新增一个填空题")
    @PostMapping("resourse/createqa")
    public String createQa(@RequestBody QuestionsAndAnswersEntity questionsAndAnswersEntity);

    @ApiOperation("作业列表")
    @GetMapping("/listhomework")
    public List<HomeworkEntity> listHomework(@RequestParam("ids") String [] ids);

    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody HomeworkEntity homework);


}
