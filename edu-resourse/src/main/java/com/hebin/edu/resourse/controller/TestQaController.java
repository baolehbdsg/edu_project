package com.hebin.edu.resourse.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.resourse.entity.TestQaEntity;
import com.hebin.edu.resourse.service.TestQaService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/testqa")
public class TestQaController {
    @Autowired
    private TestQaService testQaService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:testqa:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = testQaService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('resourse:testqa:info')")
    public Resp<TestQaEntity> info(@PathVariable("id") Long id){
		TestQaEntity testQa = testQaService.getById(id);

        return Resp.ok(testQa);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:testqa:save')")
    public Resp<Object> save(@RequestBody TestQaEntity testQa){
		testQaService.save(testQa);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:testqa:update')")
    public Resp<Object> update(@RequestBody TestQaEntity testQa){
		testQaService.updateById(testQa);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:testqa:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		testQaService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
