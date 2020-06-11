/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.controller;


import com.hebin.resourse.DTO.ChoiceDTO;
import com.hebin.resourse.DTO.QADTO;
import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import com.hebin.resourse.service.QuestionsAndAnswersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试微服务远程调用获取简答题")
@RestController
public class QAFeignController {
    @Autowired
    QuestionsAndAnswersService questionsAndAnswersService;
    @ApiOperation("远程调用,获取具体的简答题信息")
    @PostMapping("resourse/qadetaillist")
    @PreAuthorize("hasAuthority('resourse:homework:list')")
    public List<QADTO> qaDetailList(@RequestBody List<QADTO> qadtos)
    {
        for(int i = 0;i<qadtos.size();i++)
        {
            QuestionsAndAnswersEntity questionsAndAnswersEntity = new QuestionsAndAnswersEntity();
            questionsAndAnswersEntity=questionsAndAnswersService.getById(qadtos.get(i).getQaId());
            BeanUtils.copyProperties(questionsAndAnswersEntity,qadtos.get(i));
        }
        return qadtos;
    }
    @ApiOperation("远程调用,新增一个填空题")
    @PostMapping("resourse/createqa")
    @PreAuthorize("hasAuthority('resourse:homework:list')")
    public String createQa(@RequestBody QuestionsAndAnswersEntity questionsAndAnswersEntity)
    {
        questionsAndAnswersService.save(questionsAndAnswersEntity);
        return questionsAndAnswersEntity.getQaId();
    }
}
