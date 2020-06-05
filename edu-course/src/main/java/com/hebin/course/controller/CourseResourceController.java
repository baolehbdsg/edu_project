package com.hebin.course.controller;

import java.util.Arrays;
import java.util.Map;


import com.hebin.core.bean.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.CourseResourceEntity;
import com.hebin.course.service.CourseResourceService;




/**
 * 课程与资源
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
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
     * 上传资源
     */
    @ApiOperation("上传课程资源")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:courseresource:save')")
    public Resp<Object> save(@RequestBody CourseResourceEntity courseResource){
		courseResourceService.save(courseResource);
		//远程调用保存课程资源后，返回resourse_id
        //然后保存course_resourse
        return Resp.ok(null);
    }

    /**
     * 修改课程资源
     */
    @ApiOperation("修改课程资源（权限之类）")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:courseresource:update')")
    public Resp<Object> update(@RequestBody CourseResourceEntity courseResource){
        //还是需要远程调用
		courseResourceService.updateById(courseResource);

        return Resp.ok(null);
    }

    /**
     * 删除资源
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:courseresource:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseResourceService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
