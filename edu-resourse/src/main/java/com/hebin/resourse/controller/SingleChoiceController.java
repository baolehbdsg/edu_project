package com.hebin.resourse.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.resourse.entity.SingleChoiceEntity;
import com.hebin.resourse.service.SingleChoiceService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "单选题 管理")
@RestController
@RequestMapping("resourse/singlechoice")
public class SingleChoiceController {
    @Autowired
    private SingleChoiceService singleChoiceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:singlechoice:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = singleChoiceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{choiceId}")
    @PreAuthorize("hasAuthority('resourse:singlechoice:info')")
    public Resp<SingleChoiceEntity> info(@PathVariable("choiceId") Long choiceId){
		SingleChoiceEntity singleChoice = singleChoiceService.getById(choiceId);

        return Resp.ok(singleChoice);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:singlechoice:save')")
    public Resp<Object> save(@RequestBody SingleChoiceEntity singleChoice){
		singleChoiceService.save(singleChoice);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:singlechoice:update')")
    public Resp<Object> update(@RequestBody SingleChoiceEntity singleChoice){
		singleChoiceService.updateById(singleChoice);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:singlechoice:delete')")
    public Resp<Object> delete(@RequestBody Long[] choiceIds){
		singleChoiceService.removeByIds(Arrays.asList(choiceIds));

        return Resp.ok(null);
    }

}
