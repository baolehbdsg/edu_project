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

import com.hebin.resourse.entity.InteractiveEntityEntity;
import com.hebin.resourse.service.InteractiveEntityService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "互动实体 管理")
@RestController
@RequestMapping("resourse/interactiveentity")
public class InteractiveEntityController {
    @Autowired
    private InteractiveEntityService interactiveEntityService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:interactiveentity:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = interactiveEntityService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{interactiveId}")
    @PreAuthorize("hasAuthority('resourse:interactiveentity:info')")
    public Resp<InteractiveEntityEntity> info(@PathVariable("interactiveId") Long interactiveId){
		InteractiveEntityEntity interactiveEntity = interactiveEntityService.getById(interactiveId);

        return Resp.ok(interactiveEntity);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:interactiveentity:save')")
    public Resp<Object> save(@RequestBody InteractiveEntityEntity interactiveEntity){
		interactiveEntityService.save(interactiveEntity);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:interactiveentity:update')")
    public Resp<Object> update(@RequestBody InteractiveEntityEntity interactiveEntity){
		interactiveEntityService.updateById(interactiveEntity);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:interactiveentity:delete')")
    public Resp<Object> delete(@RequestBody Long[] interactiveIds){
		interactiveEntityService.removeByIds(Arrays.asList(interactiveIds));

        return Resp.ok(null);
    }

}
