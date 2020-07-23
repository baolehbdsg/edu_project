/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.Resp;
import com.hebin.interactiveservice.entity.InteractiveEntityEntity;
import com.hebin.interactiveservice.feignDTO.CreateInteractiveDTO;
import com.hebin.interactiveservice.service.InteractiveEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "远程调用接口统一管理")
@RestController
@RequestMapping("interactive/feigninterface")
public class FeignController {
    @Autowired
    InteractiveEntityService interactiveEntityService;
    /**
     * 新建互动
     * 测试状态：ok
     * 远程调用
     */
    @ApiOperation("新建互动")
    @PostMapping("/createinteractive")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:save')")
    public String createInteractive(@RequestBody CreateInteractiveDTO createInteractiveDTO){
        InteractiveEntityEntity interactiveEntityEntity = new InteractiveEntityEntity();
        BeanUtils.copyProperties(createInteractiveDTO,interactiveEntityEntity);
        interactiveEntityEntity.setIsDelete(0);
        interactiveEntityService.save(interactiveEntityEntity);
        //返回创建的互动id
        return interactiveEntityEntity.getInteractiveId();
    }

    @ApiOperation("返回一个互动列表")
    @GetMapping("/listinteractive")
    public List<InteractiveEntityEntity> listInteractive(@RequestParam("ids") String[]ids){
        QueryWrapper<InteractiveEntityEntity> queryWrapper = new QueryWrapper<>();
        if(ids==null)return null;
        queryWrapper.in("interactive_id",ids);
        List<InteractiveEntityEntity> interactiveEntityEntities=interactiveEntityService.list(queryWrapper);
        return interactiveEntityEntities;
    }

    @ApiOperation("修改互动")
    @PostMapping("/modifyinteractive")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:update')")
    public Resp<Object> modifyInteractive(@RequestBody InteractiveEntityEntity interactiveEntityEntity){
        QueryWrapper<InteractiveEntityEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interactive_id",interactiveEntityEntity.getInteractiveId());
        if(interactiveEntityService.update(interactiveEntityEntity,queryWrapper))return Resp.ok("修改成功");
        return Resp.ok("修改失败");
    }

}
