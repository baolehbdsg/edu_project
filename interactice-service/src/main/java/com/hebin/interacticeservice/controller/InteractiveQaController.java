package com.hebin.interacticeservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.interacticeservice.VO.CreateChoiceVO;
import com.hebin.interacticeservice.VO.CreateQaVO;
import com.hebin.interacticeservice.entity.InteractiveChoiceEntity;
import com.hebin.interacticeservice.entity.InteractiveQaEntity;
import com.hebin.interacticeservice.feign.ResouseFeign;
import com.hebin.interacticeservice.service.InteractiveQaService;
import com.hebin.resourse.DTO.CreateChoiceDTO;
import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@Api(tags = "互动与简答之间关系 管理")
@RestController
@RequestMapping("interactive/interactiveqa")
public class InteractiveQaController {
    @Autowired
    private InteractiveQaService interactiveQaService;
    @Autowired
    private ResouseFeign resouseFeign;
    /**
     * 新增一个简答题
     * 前端每次保存，都发送一次请求
     *
     */
    @ApiOperation("新增一个简答题")
    @PostMapping("/create/createInteractiveChoice")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:save')")
    public Resp<Object> createInteractiveChoice(@RequestBody CreateQaVO createQaVO){
        //传互动id
        //传选择题相关的实体进来
        //然后远程调用保存简答，返回一个id
        QuestionsAndAnswersEntity questionsAndAnswersEntity = new QuestionsAndAnswersEntity();
        BeanUtils.copyProperties(createQaVO,questionsAndAnswersEntity);
        String qaId = resouseFeign.createQa(questionsAndAnswersEntity);
        InteractiveQaEntity interactiveQaEntity = new InteractiveQaEntity();
        BeanUtils.copyProperties(createQaVO,interactiveQaEntity);
        interactiveQaEntity.setQaId(qaId);
        interactiveQaEntity.setIsDelete(0);
        if(interactiveQaService.save(interactiveQaEntity))return Resp.ok("保存成功");
        return Resp.ok("保存失败");
    }
    /**
     * 新增一个简答题
     * 前端每次保存，都发送一次请求
     *
     */
    @ApiOperation("删除一个简答题")
    @PostMapping("/create/deleteInteractiveChoice")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:save')")
    public Resp<Object> deleteInteractiveChoice(@RequestParam("interactiveId") String interactiveId,@RequestParam("qaId")String choiceId){
        //直接删除这层关系即可
        QueryWrapper<InteractiveQaEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("interactive_id",interactiveId).eq("qa_id",choiceId));
        if(interactiveQaService.remove(queryWrapper))return Resp.ok("删除成功");
        else return Resp.fail("删除失败");
    }

}
