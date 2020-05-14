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

import com.hebin.edu.resourse.entity.InteractiveQaEntity;
import com.hebin.edu.resourse.service.InteractiveQaService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/interactiveqa")
public class InteractiveQaController {
    @Autowired
    private InteractiveQaService interactiveQaService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:interactiveqa:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = interactiveQaService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('resourse:interactiveqa:info')")
    public Resp<InteractiveQaEntity> info(@PathVariable("id") Long id){
		InteractiveQaEntity interactiveQa = interactiveQaService.getById(id);

        return Resp.ok(interactiveQa);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:interactiveqa:save')")
    public Resp<Object> save(@RequestBody InteractiveQaEntity interactiveQa){
		interactiveQaService.save(interactiveQa);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:interactiveqa:update')")
    public Resp<Object> update(@RequestBody InteractiveQaEntity interactiveQa){
		interactiveQaService.updateById(interactiveQa);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:interactiveqa:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		interactiveQaService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
