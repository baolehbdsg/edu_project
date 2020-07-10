/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.interacticeservice.VO.CreateChoiceVO;
import com.hebin.interacticeservice.VO.CreateQaVO;
import com.hebin.interacticeservice.VO.InteractiveDetailListVO;
import com.hebin.interacticeservice.entity.InteractiveChoiceEntity;
import com.hebin.interacticeservice.entity.InteractiveEntityEntity;
import com.hebin.interacticeservice.entity.InteractiveQaEntity;
import com.hebin.interacticeservice.feign.ResouseFeign;
import com.hebin.interacticeservice.service.InteractiveChoiceService;
import com.hebin.interacticeservice.service.InteractiveEntityService;
import com.hebin.interacticeservice.service.InteractiveQaService;
import com.hebin.resourse.DTO.ChoiceDTO;
import com.hebin.resourse.DTO.QADTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "互动")
@RestController
@RequestMapping("interactive/interactiveentity")
public class InteractiveEntityController {
    @Autowired
    private InteractiveEntityService interactiveEntityService;
    @Autowired
    private InteractiveQaService interactiveQaService;
    @Autowired
    private InteractiveChoiceService interactiveChoiceService;
    @Autowired
    ResouseFeign resouseFeign;
    /**
     * 查看互动内的题目列表
     * 教师与学生都可以查看
     */
    @ApiOperation("查看互动内的题目列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:interactiveentity:list')")
    public Resp<Object> list(@RequestParam("interactiveId") String interactiveId) {

        //最后返回的结果集
        InteractiveDetailListVO interactiveDetailListVO = new InteractiveDetailListVO();
        //先获取互动相关的信息
        InteractiveEntityEntity interactiveEntityEntity= interactiveEntityService.getById(interactiveId);
        //然后进行赋值
        BeanUtils.copyProperties(interactiveEntityEntity,interactiveDetailListVO);
        //先获取选择题list和问答题list
        QueryWrapper<InteractiveChoiceEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interactive_id",interactiveId);
        List<InteractiveChoiceEntity> interactiveChoiceEntities=interactiveChoiceService.list(queryWrapper);
        QueryWrapper<InteractiveQaEntity> interactiveQaEntityQueryWrapper = new QueryWrapper<>();
        interactiveQaEntityQueryWrapper.eq("interactive_id",interactiveId);
        List<InteractiveQaEntity> interactiveQaEntities=interactiveQaService.list(interactiveQaEntityQueryWrapper);
        //创建远程调用要用的类
        List<ChoiceDTO> choiceDTOS = new ArrayList<>();
        List<QADTO> qadtos = new ArrayList<>();
        for(int i = 0 ; i<interactiveChoiceEntities.size();i++)
        {
            ChoiceDTO choiceDTO = new ChoiceDTO();
            BeanUtils.copyProperties(interactiveChoiceEntities.get(i),choiceDTO);
            choiceDTOS.add(choiceDTO);
        }
        for(int i =0;i<interactiveQaEntities.size();i++)
        {
            QADTO qadto = new QADTO();
            BeanUtils.copyProperties(interactiveQaEntities.get(i),qadto);
            qadtos.add(qadto);
        }
        choiceDTOS = resouseFeign.choiceDetailList(choiceDTOS);
        qadtos = resouseFeign.qaDetailList(qadtos);
        //封装子结果集
        List<CreateChoiceVO> createChoiceVOS = new ArrayList<>();
        for(int i = 0 ; i<choiceDTOS.size();i++)
        {
            CreateChoiceVO createChoiceVO = new CreateChoiceVO();
            BeanUtils.copyProperties(choiceDTOS.get(i),createChoiceVO);
            createChoiceVOS.add(createChoiceVO);
        }
        List<CreateQaVO> createQaVOS = new ArrayList<>();
        for(int i =0;i<qadtos.size();i++)
        {
            CreateQaVO createQaVO = new CreateQaVO();
            BeanUtils.copyProperties(qadtos.get(i),createQaVO);
            createQaVOS.add(createQaVO);
        }
        interactiveDetailListVO.setCreateChoiceVOS(createChoiceVOS);
        interactiveDetailListVO.setCreateQaVOS(createQaVOS);
        return Resp.ok(interactiveDetailListVO);
    }


}
