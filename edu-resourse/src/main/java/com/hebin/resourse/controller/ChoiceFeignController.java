/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.resourse.DTO.ChoiceDTO;
import com.hebin.resourse.DTO.CreateChoiceDTO;
import com.hebin.resourse.entity.JudgeEntity;
import com.hebin.resourse.entity.MultipleChoiceEntity;
import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import com.hebin.resourse.entity.SingleChoiceEntity;
import com.hebin.resourse.service.JudgeService;
import com.hebin.resourse.service.MultipleChoiceService;
import com.hebin.resourse.service.SingleChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "测试微服务远程调用获取选择题")
@RestController
public class ChoiceFeignController {
    @Autowired
    SingleChoiceService singleChoiceService;
    @Autowired
    MultipleChoiceService multipleChoiceService;
    @Autowired
    JudgeService judgeService;
    /**
     * 传入的只有几个属性
     * choiceId
     * choiceType
     * score(题目分数)
     * number(题号)
     */
    @ApiOperation("远程调用,获取具体的选择题")
    @PostMapping("resourse/choicedetaillist")
    @PreAuthorize("hasAuthority('resourse:homework:list')")
    public List<ChoiceDTO> choiceDetailList(@RequestBody List<ChoiceDTO> choiceDTOS) {
        //通过choiceId和type类型，查找不同的数据库
        //然后封装到List<ChoiceDTO>中
        for(int i = 0;i<choiceDTOS.size();i++)
        {
            //单选
            if(choiceDTOS.get(i).getChoiceType()==0)
            {
                SingleChoiceEntity singleChoiceEntity = new SingleChoiceEntity();
                singleChoiceEntity=singleChoiceService.getById(choiceDTOS.get(i).getChoiceId());
                BeanUtils.copyProperties(singleChoiceEntity,choiceDTOS.get(i));
            }
            //多选
            else if(choiceDTOS.get(i).getChoiceType()==1)
            {
                MultipleChoiceEntity multipleChoiceEntity = new MultipleChoiceEntity();
                multipleChoiceEntity=multipleChoiceService.getById(choiceDTOS.get(i).getChoiceId());
                BeanUtils.copyProperties(multipleChoiceEntity,choiceDTOS.get(i));
            }
            //判断
            else if(choiceDTOS.get(i).getChoiceType()==2)
            {
                JudgeEntity judgeEntity = new JudgeEntity();
                judgeEntity=  judgeService.getById(choiceDTOS.get(i).getChoiceId());
                BeanUtils.copyProperties(judgeEntity,choiceDTOS.get(i));

            }
        }
        return choiceDTOS;
    }
    /**
     * 传入的只有几个属性
     * choiceId
     * choiceType
     * score(题目分数)
     * number(题号)
     */
    @ApiOperation("远程调用,新增一个选择题")
    @PostMapping("resourse/createchoice")
    @PreAuthorize("hasAuthority('resourse:homework:list')")
    public String createChoice(@RequestBody CreateChoiceDTO createChoiceDTO)
    {
        if(createChoiceDTO.getChoiceType()==0)
        {
            SingleChoiceEntity singleChoiceEntity = new SingleChoiceEntity();
            BeanUtils.copyProperties(createChoiceDTO,singleChoiceEntity);
            if(singleChoiceEntity.getChoiceId()==null||singleChoiceEntity.getChoiceId()=="") singleChoiceService.save(singleChoiceEntity);
            else
            {
                QueryWrapper<SingleChoiceEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("choice_id",singleChoiceEntity.getChoiceId());
                singleChoiceService.update(singleChoiceEntity,queryWrapper);
            }
            return singleChoiceEntity.getChoiceId();
        }
        //多选
        else if(createChoiceDTO.getChoiceType()==1)
        {
            MultipleChoiceEntity multipleChoiceEntity = new MultipleChoiceEntity();
            BeanUtils.copyProperties(createChoiceDTO,multipleChoiceEntity);
            multipleChoiceService.save(multipleChoiceEntity);
            return multipleChoiceEntity.getChoiceId();
        }
        //判断
        else if(createChoiceDTO.getChoiceType()==2)
        {
            JudgeEntity judgeEntity = new JudgeEntity();
            BeanUtils.copyProperties(createChoiceDTO,judgeEntity);
            judgeService.save(judgeEntity);
            return judgeEntity.getChoiceId();
        }
        return null;
    }


}
