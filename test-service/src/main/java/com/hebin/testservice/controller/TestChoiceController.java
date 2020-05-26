package com.hebin.testservice.controller;

import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.testservice.entity.TestChoiceEntity;
import com.hebin.testservice.service.TestChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "测试中的选择题 管理")
@RestController
@RequestMapping("test/testchoice")
public class TestChoiceController {
    @Autowired
    private TestChoiceService testChoiceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:testchoice:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = testChoiceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('resourse:testchoice:info')")
    public Resp<TestChoiceEntity> info(@PathVariable("id") Long id){
		TestChoiceEntity testChoice = testChoiceService.getById(id);

        return Resp.ok(testChoice);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:testchoice:save')")
    public Resp<Object> save(@RequestBody TestChoiceEntity testChoice){
		testChoiceService.save(testChoice);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:testchoice:update')")
    public Resp<Object> update(@RequestBody TestChoiceEntity testChoice){
		testChoiceService.updateById(testChoice);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:testchoice:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		testChoiceService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
