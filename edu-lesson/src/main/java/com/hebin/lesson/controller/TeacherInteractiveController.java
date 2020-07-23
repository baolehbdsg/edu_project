/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.controller;

import java.util.Date;
import java.util.List;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.interactiveservice.VO.CreateChoiceVO;
import com.hebin.interactiveservice.VO.CreateQaVO;
import com.hebin.interactiveservice.entity.InteractiveChoiceEntity;
import com.hebin.interactiveservice.entity.InteractiveEntityEntity;
import com.hebin.interactiveservice.feignDTO.CreateInteractiveDTO;
import com.hebin.lesson.DTO.ListInteractiveDTO;
import com.hebin.lesson.VO.CreateInteractiveVO;
import com.hebin.lesson.entity.TeacherDir;
import com.hebin.lesson.entity.TeacherInteractiveEntity;
import com.hebin.core.bean.Resp;
import com.hebin.lesson.feign.InteractiveFeign;
import com.hebin.lesson.feign.ResourseFeign;
import com.hebin.lesson.service.TeacherDirService;
import com.hebin.resourse.DTO.CreateChoiceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.lesson.service.TeacherInteractiveService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = "备课-互动区")
@RestController
@RequestMapping("lesson/teacherinteractive")
public class TeacherInteractiveController {
    @Autowired
    private TeacherInteractiveService teacherInteractiveService;
    @Autowired
    private InteractiveFeign interactiveFeign;
    @Autowired
    private TeacherDirService teacherDirService;
    @Autowired
    private ResourseFeign resourseFeign;
    /**
     *
     */
    @ApiOperation("新建互动")
    @PostMapping("/createinteractive")
    public Resp<Object> createInteractive(@RequestBody CreateInteractiveVO createInteractiveVO) {
        //远程调用保存
        CreateInteractiveDTO createInteractiveFeignDTO = new CreateInteractiveDTO();
        BeanUtils.copyProperties(createInteractiveVO,createInteractiveFeignDTO);
        String interactiveId=interactiveFeign.createInteractive(createInteractiveFeignDTO);
        String userId="225";

        TeacherInteractiveEntity teacherInteractiveEntity = new TeacherInteractiveEntity();
        teacherInteractiveEntity.setUserId(userId);
        if(createInteractiveVO.getFatherId()==null||createInteractiveVO.getFatherId()=="")teacherInteractiveEntity.setFatherId("0");
        else teacherInteractiveEntity.setFatherId(createInteractiveVO.getFatherId());
        teacherInteractiveEntity.setInteractiveId(interactiveId);
        teacherInteractiveEntity.setCreateTime(new Date());
        teacherInteractiveEntity.setIsDelete(0);
        teacherInteractiveService.save(teacherInteractiveEntity);

        return Resp.ok("保存成功");
    }
    @ApiOperation("查看互动区资源")
    @GetMapping("/listinteractive")
    public Resp<Object> listInteractive(@RequestParam("fatherId")String fatherId) {
        //这个fatherId前端默认传0
        //步骤：1查询所有互动且父文件夹id为0的
        //2.远程调用获取这些id的实体
        //3.查询dir下的type=0的且父文件夹id为0的
        //4.返回一个统一对象
        String userId = "245";
        ListInteractiveDTO listInteractiveDTO = new ListInteractiveDTO();
        QueryWrapper<TeacherInteractiveEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("user_id",userId).eq("father_id",fatherId).ne("is_delete",1));
        List<TeacherInteractiveEntity> teacherInteractiveEntityList=teacherInteractiveService.list(queryWrapper);
        String ids[] = new String[teacherInteractiveEntityList.size()];
        for(int i = 0;i<teacherInteractiveEntityList.size();i++)
        {
            ids[i] = teacherInteractiveEntityList.get(i).getInteractiveId();
        }
        //返回结果1
        listInteractiveDTO.setInteractiveEntityEntities(interactiveFeign.listInteractive(ids));
        //返回结果2
        QueryWrapper<TeacherDir> teacherDirQueryWrapper = new QueryWrapper<>();
        teacherDirQueryWrapper.and(i->i.eq("user_id",userId).eq("father_dir_id",fatherId).eq("type",0));
        listInteractiveDTO.setTeacherDirs(teacherDirService.list(teacherDirQueryWrapper));
        return Resp.ok(listInteractiveDTO);
    }
    @ApiOperation("在互动区下新增/修改选择题")
    @PostMapping("/createchoice")
    public Resp<Object> createChoice(@RequestBody CreateChoiceVO createChoiceVO)
    {
        interactiveFeign.createInteractiveChoice(createChoiceVO);
        return Resp.ok("成功");
    }

    @ApiOperation("修改互动（标题名称等）")
    @PostMapping("/updateinteractive")
    public Resp<Object> updateInteractive(@RequestBody InteractiveEntityEntity interactiveEntityEntity)
    {
        interactiveFeign.modifyInteractive(interactiveEntityEntity);
        return Resp.ok("成功");
    }
    //未测试
    @ApiOperation("在互动区下新增/修改简答题")
    @PostMapping("/createqa")
    public Resp<Object> createqa(@RequestBody CreateQaVO createQaVO)
    {
        String userId = "";
        interactiveFeign.createInteractiveQa(createQaVO);
        return Resp.ok("成功");
    }
    //
    @ApiOperation("删除互动")
    @PostMapping("/deleteinteractive")
    public Resp<Object> deleteinteractive(@RequestBody String interactiveId)
    {
        //选择不伤筋动骨的方式，直接删除备课区的索引即可
        QueryWrapper<TeacherInteractiveEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("interactive_id",interactiveId);
        teacherInteractiveService.remove(queryWrapper);
        return Resp.ok("成功");
    }
    @ApiOperation("查看互动详情")
    @GetMapping("/detailinteractive")
    public Resp<Object> detailinteractive(@RequestParam("interactiveId") String interactiveId)
    {
        return interactiveFeign.list(interactiveId);
    }
    @ApiOperation("删除某个简答题")
    @PostMapping("/deleteqa")
    public Resp<Object> deleteQa(@RequestParam("interactiveId") String interactiveId,@RequestParam("qaId")String qaId)
    {
        //在互动层删除那一层关系即可
        return interactiveFeign.deleteInteractiveQa(interactiveId,qaId);
    }
    @ApiOperation("删除某个选择题")
    @PostMapping("/deletechoice")
    public Resp<Object> deleteChoice(@RequestParam("interactiveId") String interactiveId,@RequestParam("qaId")String choiceId)
    {
        //在互动层删除那一层关系即可
        return interactiveFeign.deleteInteractiveChoice(interactiveId,choiceId);
    }
}
