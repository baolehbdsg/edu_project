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

import com.hebin.edu.resourse.entity.ResourceEntity;
import com.hebin.edu.resourse.service.ResourceService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:resource:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = resourceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{resourceId}")
    @PreAuthorize("hasAuthority('resourse:resource:info')")
    public Resp<ResourceEntity> info(@PathVariable("resourceId") Long resourceId){
		ResourceEntity resource = resourceService.getById(resourceId);

        return Resp.ok(resource);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:resource:save')")
    public Resp<Object> save(@RequestBody ResourceEntity resource){
		resourceService.save(resource);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:resource:update')")
    public Resp<Object> update(@RequestBody ResourceEntity resource){
		resourceService.updateById(resource);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:resource:delete')")
    public Resp<Object> delete(@RequestBody Long[] resourceIds){
		resourceService.removeByIds(Arrays.asList(resourceIds));

        return Resp.ok(null);
    }

}
