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
import com.hebin.testservice.VO.CreateChoiceVO;
import com.hebin.testservice.entity.TestChoiceEntity;
import com.hebin.testservice.entity.TestEntityEntity;
import com.hebin.testservice.feign.ResourseFeign;
import com.hebin.testservice.feignDTO.CreateTestDTO;
import com.hebin.testservice.service.TestChoiceService;
import com.hebin.testservice.service.TestEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "测试区统一远程接口管理")
@RestController
@RequestMapping("test/feigninterface")
public class TestFeignController {
    @Autowired
    TestEntityService testEntityService;
    @Autowired
    ResourseFeign resourseFeign;
    @Autowired
    TestChoiceService testChoiceService;
    @ApiOperation("创建一个测试")
    @PostMapping("/createtest")
    @PreAuthorize("hasAuthority('resourse:testentity:update')")
    public String createTest(@RequestBody CreateTestDTO createTestDTO)
    {
        TestEntityEntity testEntityEntity = new TestEntityEntity();
        BeanUtils.copyProperties(createTestDTO,testEntityEntity);
        testEntityEntity.setIsDelete(0);
        testEntityService.save(testEntityEntity);
        return testEntityEntity.getTestId();
    }
    @ApiOperation("测试列表")
    @GetMapping("/listtest")
    @PreAuthorize("hasAuthority('resourse:testentity:update')")
    public List<TestEntityEntity> listTest(@RequestParam("ids") String[] ids)
    {
        if(ids==null)return null;
        QueryWrapper<TestEntityEntity>  queryWrapper= new QueryWrapper<>();
        queryWrapper.in("test_id",ids);
        return testEntityService.list(queryWrapper);
    }
    @ApiOperation("新建/修改一个选择题")
    @PostMapping("/createchoice")
    public Resp<Object>  createChoice(@RequestBody CreateChoiceVO createChoiceVO)
    {
        //先要远程调用，保存到resource服务，并返回choiceId;
        //然后就保存到edu_test_choice中即可
        CreateChoiceDTO createChoiceDTO = new CreateChoiceDTO();
        BeanUtils.copyProperties(createChoiceVO,createChoiceDTO);
        if(createChoiceDTO.getChoiceId()==null||createChoiceDTO.getChoiceId()=="")
        {
            String choiceId=resourseFeign.createChoice(createChoiceDTO);
            TestChoiceEntity testChoiceEntity = new TestChoiceEntity();
            BeanUtils.copyProperties(createChoiceVO,testChoiceEntity);
            testChoiceEntity.setChoiceId(choiceId);
            testChoiceService.save(testChoiceEntity);
            return Resp.ok("成功");
        }
        else
        {
            resourseFeign.createChoice(createChoiceDTO);
            TestChoiceEntity testChoiceEntity = new TestChoiceEntity();
            BeanUtils.copyProperties(createChoiceVO,testChoiceEntity);
            testChoiceEntity.setChoiceId(createChoiceDTO.getChoiceId());
            QueryWrapper<TestChoiceEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.and(i->i.eq("test_id",createChoiceVO.getTestId()).eq("choice_id",createChoiceDTO.getChoiceId()));
            testChoiceService.update(testChoiceEntity,queryWrapper);
            return Resp.ok("成功");
        }

    }

}
