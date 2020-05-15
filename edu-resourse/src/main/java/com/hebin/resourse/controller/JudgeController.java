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

import com.hebin.resourse.entity.JudgeEntity;
import com.hebin.resourse.service.JudgeService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:judge:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = judgeService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{choiceId}")
    @PreAuthorize("hasAuthority('resourse:judge:info')")
    public Resp<JudgeEntity> info(@PathVariable("choiceId") Long choiceId){
		JudgeEntity judge = judgeService.getById(choiceId);

        return Resp.ok(judge);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:judge:save')")
    public Resp<Object> save(@RequestBody JudgeEntity judge){
		judgeService.save(judge);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:judge:update')")
    public Resp<Object> update(@RequestBody JudgeEntity judge){
		judgeService.updateById(judge);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:judge:delete')")
    public Resp<Object> delete(@RequestBody Long[] choiceIds){
		judgeService.removeByIds(Arrays.asList(choiceIds));

        return Resp.ok(null);
    }

}
