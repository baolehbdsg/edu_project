package com.hebin.edu.resourse.controller;

import java.util.Arrays;


import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.edu.resourse.entity.QuestionsAndAnswersEntity;
import com.hebin.edu.resourse.service.QuestionsAndAnswersService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("resourse/questionsandanswers")
public class QuestionsAndAnswersController {
    @Autowired
    private QuestionsAndAnswersService questionsAndAnswersService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('resourse:questionsandanswers:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = questionsAndAnswersService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{qaId}")
    @PreAuthorize("hasAuthority('resourse:questionsandanswers:info')")
    public Resp<QuestionsAndAnswersEntity> info(@PathVariable("qaId") Long qaId){
		QuestionsAndAnswersEntity questionsAndAnswers = questionsAndAnswersService.getById(qaId);

        return Resp.ok(questionsAndAnswers);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('resourse:questionsandanswers:save')")
    public Resp<Object> save(@RequestBody QuestionsAndAnswersEntity questionsAndAnswers){
		questionsAndAnswersService.save(questionsAndAnswers);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resourse:questionsandanswers:update')")
    public Resp<Object> update(@RequestBody QuestionsAndAnswersEntity questionsAndAnswers){
		questionsAndAnswersService.updateById(questionsAndAnswers);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('resourse:questionsandanswers:delete')")
    public Resp<Object> delete(@RequestBody Long[] qaIds){
		questionsAndAnswersService.removeByIds(Arrays.asList(qaIds));

        return Resp.ok(null);
    }

}
