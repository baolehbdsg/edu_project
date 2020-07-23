/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.feign;

import com.hebin.core.bean.Resp;
import com.hebin.interactiveservice.VO.CreateChoiceVO;
import com.hebin.interactiveservice.VO.CreateQaVO;
import com.hebin.interactiveservice.entity.InteractiveEntityEntity;
import com.hebin.interactiveservice.feignDTO.CreateInteractiveDTO;
import com.hebin.resourse.entity.HomeworkEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InteractiveApi {
    //创建互动
    //在互动下创建相关选择或者问答
    @PostMapping("interactive/feigninterface/createinteractive")
    public String createInteractive(@RequestBody CreateInteractiveDTO createInteractiveDTO);

    @GetMapping("interactive/feigninterface/listinteractive")
    public List<InteractiveEntityEntity> listInteractive(@RequestParam("ids") String []ids);

    @ApiOperation("新增/修改一个选择题")
    @PostMapping("interactive/interactivechoice/create/createInteractiveChoice")
    public Resp<Object> createInteractiveChoice(@RequestBody CreateChoiceVO createChoiceVO);

    @ApiOperation("修改互动")
    @PostMapping("interactive/feigninterface/modifyinteractive")
    public Resp<Object> modifyInteractive(@RequestBody InteractiveEntityEntity interactiveEntityEntity);

    @ApiOperation("新增/修改一个简答题")
    @PostMapping("interactive/interactiveqa/create/createInteractiveqa")
    public Resp<Object> createInteractiveQa(@RequestBody CreateQaVO createQaVO);
    @ApiOperation("查看互动内的题目列表")
    @GetMapping("/list")
    public Resp<Object> list(@RequestParam("interactiveId") String interactiveId);

    @ApiOperation("删除一个简答题")
    @PostMapping("/delete/deleteInteractiveqa")
    public Resp<Object> deleteInteractiveQa(@RequestParam("interactiveId") String interactiveId,@RequestParam("qaId")String qaId);

    @ApiOperation("删除一个选择题")
    @PostMapping("/delete/deleteInteractiveChoice")
    public Resp<Object> deleteInteractiveChoice(@RequestParam("interactiveId") String interactiveId,@RequestParam("choiceId")String choiceId);


}
