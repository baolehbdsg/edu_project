package com.hebin.bbs.controller;

import com.hebin.bbs.entity.CourseBbsEntity;
import com.hebin.bbs.service.CourseBbsService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 课程与论坛
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程与论坛 管理")
@RestController
@RequestMapping("bbs/coursebbs")
public class CourseBbsController {
    @Autowired
    private CourseBbsService courseBbsService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('course:coursebbs:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = courseBbsService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{cbId}")
    @PreAuthorize("hasAuthority('course:coursebbs:info')")
    public Resp<CourseBbsEntity> info(@PathVariable("cbId") Long cbId){
		CourseBbsEntity courseBbs = courseBbsService.getById(cbId);

        return Resp.ok(courseBbs);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('course:coursebbs:save')")
    public Resp<Object> save(@RequestBody CourseBbsEntity courseBbs){
		courseBbsService.save(courseBbs);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('course:coursebbs:update')")
    public Resp<Object> update(@RequestBody CourseBbsEntity courseBbs){
		courseBbsService.updateById(courseBbs);

        return Resp.ok(null);
    }
    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursebbs:delete')")
    public Resp<Object> delete(@RequestBody Long[] cbIds){
		courseBbsService.removeByIds(Arrays.asList(cbIds));

        return Resp.ok(null);
    }

}
