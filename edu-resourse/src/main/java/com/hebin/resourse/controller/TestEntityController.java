package com.hebin.resourse.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.resourse.entity.TestEntityEntity;
import com.hebin.resourse.service.TestEntityService;




/**
 * 测试
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "测试 管理")
@RestController
@RequestMapping("resourse/testentity")
public class TestEntityController {
    @Autowired
    private TestEntityService testEntityService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:testentity:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = testEntityService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{testId}")
    @PreAuthorize("hasAuthority('resourse:testentity:info')")
    public Resp<TestEntityEntity> info(@PathVariable("testId") Long testId){
		TestEntityEntity testEntity = testEntityService.getById(testId);

        return Resp.ok(testEntity);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:testentity:save')")
    public Resp<Object> save(@RequestBody TestEntityEntity testEntity){
		testEntityService.save(testEntity);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:testentity:update')")
    public Resp<Object> update(@RequestBody TestEntityEntity testEntity){
		testEntityService.updateById(testEntity);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:testentity:delete')")
    public Resp<Object> delete(@RequestBody Long[] testIds){
		testEntityService.removeByIds(Arrays.asList(testIds));

        return Resp.ok(null);
    }

}
