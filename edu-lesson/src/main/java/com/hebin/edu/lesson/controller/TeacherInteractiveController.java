package com.hebin.edu.lesson.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.lesson.entity.TeacherInteractiveEntity;
import com.hebin.edu.lesson.service.TeacherInteractiveService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("lesson/teacherinteractive")
public class TeacherInteractiveController {
    @Autowired
    private TeacherInteractiveService teacherInteractiveService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('lesson:teacherinteractive:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = teacherInteractiveService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('lesson:teacherinteractive:info')")
    public Resp<TeacherInteractiveEntity> info(@PathVariable("id") Long id){
		TeacherInteractiveEntity teacherInteractive = teacherInteractiveService.getById(id);

        return Resp.ok(teacherInteractive);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('lesson:teacherinteractive:save')")
    public Resp<Object> save(@RequestBody TeacherInteractiveEntity teacherInteractive){
		teacherInteractiveService.save(teacherInteractive);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('lesson:teacherinteractive:update')")
    public Resp<Object> update(@RequestBody TeacherInteractiveEntity teacherInteractive){
		teacherInteractiveService.updateById(teacherInteractive);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('lesson:teacherinteractive:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		teacherInteractiveService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
