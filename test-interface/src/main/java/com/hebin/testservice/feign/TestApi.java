/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.feign;

import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.resourse.DTO.TestdetailDTO;
import com.hebin.testservice.VO.CreateChoiceVO;
import com.hebin.testservice.VO.CreateQaVO;
import com.hebin.testservice.entity.TestEntityEntity;
import com.hebin.testservice.feignDTO.CreateTestDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TestApi {

    @ApiOperation("创建一个测试")
    @PostMapping("test/feigninterface/createtest")
    public String createTest(@RequestBody CreateTestDTO createTestDTO);

    @ApiOperation("测试列表")
    @GetMapping("test/feigninterface/listtest")
    public List<TestEntityEntity> listTest(@RequestParam("ids") String[] ids);

    @ApiOperation("新建/修改一个选择题")
    @PostMapping("test/feigninterface/createchoice")
    public Resp<Object> createChoice(@RequestBody CreateChoiceVO createChoiceVO);
    @ApiOperation("修改测试标题,或内容")
    @PostMapping("test/testentity/updatetest")
    public Resp<Object> updateTest(@RequestBody TestEntityEntity testEntity);
    @ApiOperation("新建一个简答")
    @PostMapping("test/tea/createqa")
    public Resp<Object>  createQa(@RequestBody CreateQaVO createQaVO);
    @ApiOperation("查看测试详细信息")
    @GetMapping("test/coursetestrelation/info/{testId}")
    public Resp<TestdetailDTO> info(QueryCondition queryCondition, @PathVariable("testId") String testId);
    @ApiOperation("删除一个简答")
    @PostMapping("/deleteQa")
    public Resp<Object>  deleteQa(@RequestParam("testId") String testId,@RequestParam("qaId") String qaId);
    @ApiOperation("删除一个选择题")
    @PostMapping("/deletechoice")
    public Resp<Object>  deleteChoice(@RequestParam("testId") String testId,@RequestParam("choiceId") String choiceId);
}
