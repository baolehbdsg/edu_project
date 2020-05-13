package com.hebin.edu.student.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.student.entity.StuQaInteractiveEntity;
import com.hebin.edu.student.service.StuQaInteractiveService;




/**
 * 学生互动简答
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@Api(tags = "学生互动简答 管理")
@RestController
@RequestMapping("student/stuqainteractive")
public class StuQaInteractiveController {
    @Autowired
    private StuQaInteractiveService stuQaInteractiveService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('student:stuqainteractive:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = stuQaInteractiveService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('student:stuqainteractive:info')")
    public Resp<StuQaInteractiveEntity> info(@PathVariable("id") Long id){
		StuQaInteractiveEntity stuQaInteractive = stuQaInteractiveService.getById(id);

        return Resp.ok(stuQaInteractive);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('student:stuqainteractive:save')")
    public Resp<Object> save(@RequestBody StuQaInteractiveEntity stuQaInteractive){
		stuQaInteractiveService.save(stuQaInteractive);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('student:stuqainteractive:update')")
    public Resp<Object> update(@RequestBody StuQaInteractiveEntity stuQaInteractive){
		stuQaInteractiveService.updateById(stuQaInteractive);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('student:stuqainteractive:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		stuQaInteractiveService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
