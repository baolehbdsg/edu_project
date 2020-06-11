/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.interacticeservice.entity.InteractiveEntityEntity;
import com.hebin.interacticeservice.service.InteractiveEntityService;
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
@Api(tags = "互动实体 管理")
@RestController
@RequestMapping("interactive/interactiveentity")
public class InteractiveEntityController {
//    @Autowired
//    private InteractiveEntityService interactiveEntityService;
//
//    /**
//     * 查看互动内的题目列表
//     */
//    @ApiOperation("分页查询(排序)")
//    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('resourse:interactiveentity:list')")
//    public Resp<PageVo> list(QueryCondition queryCondition) {
//        PageVo page = interactiveEntityService.queryPage(queryCondition);
//
//        return Resp.ok(page);
//    }
//    /**
//     * 互动详情查看
//     */
//    @ApiOperation("详情查询")
//    @GetMapping("/info/{interactiveId}")
//    @PreAuthorize("hasAuthority('resourse:interactiveentity:info')")
//    public Resp<InteractiveEntityEntity> info(@PathVariable("interactiveId") Long interactiveId){
//		InteractiveEntityEntity interactiveEntity = interactiveEntityService.getById(interactiveId);
//
//        return Resp.ok(interactiveEntity);
//    }
//    /**
//     * 创建互动
//     * 测试状态：ok
//     */
//    @ApiOperation("创建互动")
//    @PostMapping("/createInteractive")
//    @PreAuthorize("hasAuthority('resourse:interactiveentity:save')")
//    public Resp<Object> createInteractive(@RequestBody InteractiveEntityEntity interactiveEntity){
//		if(interactiveEntityService.save(interactiveEntity))return Resp.ok("创建成功");
//        return Resp.ok("创建失败");
//    }
////    /**
////     * 发布互动
////     */
////    @ApiOperation("发布互动")
////    @PostMapping("/publishinteractive")
////    @PreAuthorize("hasAuthority('resourse:interactiveentity:update')")
////    public Resp<Object> publishInteractive(@RequestParam("interactiveId") String interactiveId){
////        QueryWrapper<InteractiveEntityEntity> queryWrapper = new QueryWrapper<>();
////        queryWrapper.eq("interactive_id",interactiveId);
////        InteractiveEntityEntity interactiveEntityEntity = new InteractiveEntityEntity();
////        interactiveEntityEntity.setIsPublish(1);
////        if(interactiveEntityService.update(interactiveEntityEntity,queryWrapper))return Resp.ok("发布成功");
////        return Resp.ok("发布互动失败");
////    }
//    /**
//     * 删除互动
//     * 直接删除互动的实体即可，其实也是没有办法获取互动内的所有内容的
//     */
//    @ApiOperation("删除互动")
//    @PostMapping("/delete")
//    @PreAuthorize("hasAuthority('resourse:interactiveentity:delete')")
//    public Resp<Object> delete(@RequestBody Long[] interactiveIds){
//		interactiveEntityService.removeByIds(Arrays.asList(interactiveIds));
//        return Resp.ok(null);
//    }

}
