package com.hebin.testservice.controller;

import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.testservice.entity.TestEntityEntity;
import com.hebin.testservice.service.TestEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 测试
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "测试实体")
@RestController
@RequestMapping("test/testentity")
public class TestEntityController {
    @Autowired
    private TestEntityService testEntityService;
//    /**
//     * 列表
//     */
//    @ApiOperation("分页查询(排序)")
//    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('resourse:testentity:list')")
//    public Resp<PageVo> list(QueryCondition queryCondition) {
//        PageVo page = testEntityService.queryPage(queryCondition);
//
//        return Resp.ok(page);
//    }
//    /**
//     * 获取每个测试的基本信息
//     * 在获取到分页列表的时候返回测试的基本信息（二次请求）
//     */
//    @ApiOperation("获取每个测试的基本信息")
//    @GetMapping("/info/{testId}")
//    @PreAuthorize("hasAuthority('resourse:testentity:info')")
//    public Resp<TestEntityEntity> info(@PathVariable("testId") Long testId){
//		TestEntityEntity testEntity = testEntityService.getById(testId);
//
//        return Resp.ok(testEntity);
//    }
    /**
     * 修改测试标题
     * 测试状态：未测试
     */
    @ApiOperation("修改测试标题,或内容")
    @PostMapping("/updatetesttitle")
    @PreAuthorize("hasAuthority('resourse:testentity:update')")
    public Resp<Object> updatetesttitle(@RequestBody TestEntityEntity testEntity){
		if(testEntityService.updateById(testEntity))
            return Resp.ok("修改成功");
		else return Resp.ok("修改失败");
    }

}
