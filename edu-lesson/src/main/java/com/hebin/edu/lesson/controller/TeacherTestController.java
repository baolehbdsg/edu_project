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

import com.hebin.edu.lesson.entity.TeacherTestEntity;
import com.hebin.edu.lesson.service.TeacherTestService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("lesson/teachertest")
public class TeacherTestController {
    @Autowired
    private TeacherTestService teacherTestService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('lesson:teachertest:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = teacherTestService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('lesson:teachertest:info')")
    public Resp<TeacherTestEntity> info(@PathVariable("id") Long id){
		TeacherTestEntity teacherTest = teacherTestService.getById(id);

        return Resp.ok(teacherTest);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('lesson:teachertest:save')")
    public Resp<Object> save(@RequestBody TeacherTestEntity teacherTest){
		teacherTestService.save(teacherTest);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('lesson:teachertest:update')")
    public Resp<Object> update(@RequestBody TeacherTestEntity teacherTest){
		teacherTestService.updateById(teacherTest);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('lesson:teachertest:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		teacherTestService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
