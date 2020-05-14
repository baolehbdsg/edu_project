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

import com.hebin.edu.resourse.entity.InteractiveEntity;
import com.hebin.edu.resourse.service.InteractiveService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/interactive")
public class InteractiveController {
    @Autowired
    private InteractiveService interactiveService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:interactive:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = interactiveService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('resourse:interactive:info')")
    public Resp<InteractiveEntity> info(@PathVariable("id") Long id){
		InteractiveEntity interactive = interactiveService.getById(id);

        return Resp.ok(interactive);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:interactive:save')")
    public Resp<Object> save(@RequestBody InteractiveEntity interactive){
		interactiveService.save(interactive);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:interactive:update')")
    public Resp<Object> update(@RequestBody InteractiveEntity interactive){
		interactiveService.updateById(interactive);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:interactive:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		interactiveService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
