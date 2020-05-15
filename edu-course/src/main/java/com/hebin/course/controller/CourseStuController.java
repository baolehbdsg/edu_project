package com.hebin.course.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.CourseStuEntity;
import com.hebin.course.service.CourseStuService;




/**
 * 学生参与课程
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "学生参与课程 管理")
@RestController
@RequestMapping("course/coursestu")
public class CourseStuController {
    @Autowired
    private CourseStuService courseStuService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:coursestu:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseStuService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:coursestu:info')")
    public Resp<CourseStuEntity> info(@PathVariable("id") Long id){
		CourseStuEntity courseStu = courseStuService.getById(id);

        return Resp.ok(courseStu);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:coursestu:save')")
    public Resp<Object> save(@RequestBody CourseStuEntity courseStu){
		courseStuService.save(courseStu);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:coursestu:update')")
    public Resp<Object> update(@RequestBody CourseStuEntity courseStu){
		courseStuService.updateById(courseStu);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursestu:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseStuService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
