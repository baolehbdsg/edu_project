package com.hebin.interacticeservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;

import com.hebin.interacticeservice.VO.CreateChoiceVO;
import com.hebin.interacticeservice.entity.InteractiveChoiceEntity;
import com.hebin.interacticeservice.feign.ResouseFeign;
import com.hebin.interacticeservice.service.InteractiveChoiceService;
import com.hebin.resourse.DTO.CreateChoiceDTO;
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
@Api(tags = "互动中的选择题")
@RestController
@RequestMapping("interactive/interactivechoice")
public class InteractiveChoiceController {
    @Autowired
    private InteractiveChoiceService interactiveChoiceService;
    @Autowired
    private ResouseFeign resouseFeign;
    /**
     * 新增一个选择题
     * 前端每次保存，都发送一次请求
     *
     */
    @ApiOperation("新增一个选择题")
    @PostMapping("/create/createInteractiveChoice")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:save')")
    public Resp<Object> createInteractiveChoice(@RequestBody CreateChoiceVO createChoiceVO){
        //传互动id
        //传选择题相关的实体进来
        //然后远程调用保存选择题
        //返回选择题的id保存在edu_interactive_choice中
        CreateChoiceDTO createChoiceDTO = new CreateChoiceDTO();
        BeanUtils.copyProperties(createChoiceVO,createChoiceDTO);
        String choiceId = resouseFeign.createChoice(createChoiceDTO);
        InteractiveChoiceEntity interactiveChoiceEntity = new InteractiveChoiceEntity();
        BeanUtils.copyProperties(createChoiceVO,interactiveChoiceEntity);
        interactiveChoiceEntity.setChoiceId(choiceId);
        interactiveChoiceEntity.setIsDelete(0);
        interactiveChoiceService.save(interactiveChoiceEntity);
        return Resp.ok(null);
    }
    /**
     * 新增一个选择题
     * 前端每次保存，都发送一次请求
     *
     */
    @ApiOperation("删除一个选择题")
    @PostMapping("/create/deleteInteractiveChoice")
    @PreAuthorize("hasAuthority('resourse:interactivechoice:save')")
    public Resp<Object> deleteInteractiveChoice(@RequestParam("interactiveId") String interactiveId,@RequestParam("choiceId")String choiceId){
        //直接删除这层关系即可
        QueryWrapper<InteractiveChoiceEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("interactive_id",interactiveId).eq("choice_id",choiceId));
        if(interactiveChoiceService.remove(queryWrapper))return Resp.ok("删除成功");
        else return Resp.fail("删除失败");
    }

}
