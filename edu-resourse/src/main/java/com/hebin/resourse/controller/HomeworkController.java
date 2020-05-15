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

import com.hebin.resourse.entity.HomeworkEntity;
import com.hebin.resourse.service.HomeworkService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/homework")
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:homework:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = homeworkService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{homeworkId}")
    @PreAuthorize("hasAuthority('resourse:homework:info')")
    public Resp<HomeworkEntity> info(@PathVariable("homeworkId") Long homeworkId){
		HomeworkEntity homework = homeworkService.getById(homeworkId);

        return Resp.ok(homework);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:homework:save')")
    public Resp<Object> save(@RequestBody HomeworkEntity homework){
		homeworkService.save(homework);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:homework:update')")
    public Resp<Object> update(@RequestBody HomeworkEntity homework){
		homeworkService.updateById(homework);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:homework:delete')")
    public Resp<Object> delete(@RequestBody Long[] homeworkIds){
		homeworkService.removeByIds(Arrays.asList(homeworkIds));

        return Resp.ok(null);
    }

}
