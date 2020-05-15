package com.hebin.resourse.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.resourse.entity.InteractiveChoiceEntity;
import com.hebin.resourse.service.InteractiveChoiceService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/interactivechoice")
public class InteractiveChoiceController {
    @Autowired
    private InteractiveChoiceService interactiveChoiceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = interactiveChoiceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:info')")
    public Resp<InteractiveChoiceEntity> info(@PathVariable("id") Long id){
		InteractiveChoiceEntity interactiveChoice = interactiveChoiceService.getById(id);

        return Resp.ok(interactiveChoice);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:save')")
    public Resp<Object> save(@RequestBody InteractiveChoiceEntity interactiveChoice){
		interactiveChoiceService.save(interactiveChoice);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:update')")
    public Resp<Object> update(@RequestBody InteractiveChoiceEntity interactiveChoice){
		interactiveChoiceService.updateById(interactiveChoice);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		interactiveChoiceService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
