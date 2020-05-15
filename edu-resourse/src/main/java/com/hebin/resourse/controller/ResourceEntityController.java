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
import com.hebin.resourse.entity.ResourceEntityEntity;
import com.hebin.resourse.service.ResourceEntityService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:30
 */
@Api(tags = "资源实体 管理")
@RestController
@RequestMapping("resourse/resourceentity")
public class ResourceEntityController {
    @Autowired
    private ResourceEntityService resourceEntityService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:resourceentity:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = resourceEntityService.queryPage(queryCondition);
        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{resourceId}")
    @PreAuthorize("hasAuthority('resourse:resourceentity:info')")
    public Resp<ResourceEntityEntity> info(@PathVariable("resourceId") Long resourceId){
		ResourceEntityEntity resourceEntity = resourceEntityService.getById(resourceId);

        return Resp.ok(resourceEntity);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:resourceentity:save')")
    public Resp<Object> save(@RequestBody ResourceEntityEntity resourceEntity){
		resourceEntityService.save(resourceEntity);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:resourceentity:update')")
    public Resp<Object> update(@RequestBody ResourceEntityEntity resourceEntity){
		resourceEntityService.updateById(resourceEntity);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:resourceentity:delete')")
    public Resp<Object> delete(@RequestBody Long[] resourceIds){
		resourceEntityService.removeByIds(Arrays.asList(resourceIds));

        return Resp.ok(null);
    }

}
