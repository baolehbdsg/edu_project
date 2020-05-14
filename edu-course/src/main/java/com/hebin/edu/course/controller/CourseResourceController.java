package com.hebin.edu.course.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.course.entity.CourseResourceEntity;
import com.hebin.edu.course.service.CourseResourceService;




/**
 * 课程与资源
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Api(tags = "课程与资源 管理")
@RestController
@RequestMapping("course/courseresource")
public class CourseResourceController {
    @Autowired
    private CourseResourceService courseResourceService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:courseresource:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseResourceService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('course:courseresource:info')")
    public Resp<CourseResourceEntity> info(@PathVariable("id") Long id){
		CourseResourceEntity courseResource = courseResourceService.getById(id);

        return Resp.ok(courseResource);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:courseresource:save')")
    public Resp<Object> save(@RequestBody CourseResourceEntity courseResource){
		courseResourceService.save(courseResource);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:courseresource:update')")
    public Resp<Object> update(@RequestBody CourseResourceEntity courseResource){
		courseResourceService.updateById(courseResource);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:courseresource:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseResourceService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}