/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.Resp;
import com.hebin.interactiveservice.feignDTO.CreateInteractiveDTO;
import com.hebin.lesson.DTO.ListDirDTO;
import com.hebin.lesson.VO.CreateDirVO;
import com.hebin.lesson.VO.CreateInteractiveVO;
import com.hebin.lesson.entity.TeacherDir;
import com.hebin.lesson.entity.TeacherHomeworkEntity;
import com.hebin.lesson.entity.TeacherInteractiveEntity;
import com.hebin.lesson.entity.TeacherTestEntity;
import com.hebin.lesson.service.TeacherDirService;
import com.hebin.lesson.service.TeacherHomeworkService;
import com.hebin.lesson.service.TeacherInteractiveService;
import com.hebin.lesson.service.TeacherTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "文件夹相关接口")
@RestController
@RequestMapping("lesson/dir")
public class TeacherDirController {
    @Autowired
    private TeacherDirService teacherDirService;
    @Autowired
    private TeacherHomeworkService teacherHomeworkService;
    @Autowired
    private TeacherInteractiveService teacherInteractiveService;
    @Autowired
    private TeacherTestService teacherTestService;
    @ApiOperation("创建文件夹")
    @PostMapping("/createdir")
    public Resp<Object> createDir(@RequestBody CreateDirVO createDirVO) {
        String userId = "245";
        TeacherDir teacherDir = new TeacherDir();
        BeanUtils.copyProperties(createDirVO,teacherDir);
        teacherDir.setIsDelete(0);
        teacherDir.setCreateTime(new Date());
        teacherDir.setUserId(userId);
        if(teacherDir.getFatherDirId()==null||teacherDir.getFatherDirId()=="")teacherDir.setFatherDirId("0");
        teacherDirService.save(teacherDir);
        return Resp.ok("创建成功");
    }
    //移动资源
    //首先要获取该区下的所有顶级文件夹
    //当点进去以后，获取该文件夹下的所有文件夹
    //最后选择的文件夹，发送其Id作为该文件的父文件夹
    @ApiOperation("获取该区下的所有顶级文件夹")
    @GetMapping("/gettopdir")
    public Resp<Object> getTopDir(@RequestParam("fatherId") String fatherId,@RequestParam("type") Integer type)
    {
        String userId="245";
        QueryWrapper<TeacherDir> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("father_dir_id",fatherId).eq("user_id",userId).eq("type",type));
        List<TeacherDir> teacherDirList = teacherDirService.list(queryWrapper);
        List<ListDirDTO> listDirDTOS = new ArrayList<>();
        for(int i =0;i<teacherDirList.size();i++)
        {
            ListDirDTO listDirDTO = new ListDirDTO();
            BeanUtils.copyProperties(teacherDirList.get(i),listDirDTO);
            listDirDTOS.add(listDirDTO);
        }
        return Resp.ok(listDirDTOS);
    }
    @ApiOperation("选择文件到指定文件夹下")
    @PostMapping("/moveDir")
    public Resp<Object> moveDir(@RequestParam("dirId")String dirId,@RequestParam("subjectId")String subjectId,@RequestParam("type")Integer type)
    {
        String userId = "245";
        if(type==0)//互动
        {
            QueryWrapper<TeacherInteractiveEntity> teacherInteractiveEntityQueryWrapper = new QueryWrapper<>();
            teacherInteractiveEntityQueryWrapper.and(i->i.eq("user_id",userId).eq("interactive_id",subjectId));
            TeacherInteractiveEntity teacherInteractiveEntity = new TeacherInteractiveEntity();
            teacherInteractiveEntity.setFatherId(dirId);
            teacherInteractiveService.update(teacherInteractiveEntity,teacherInteractiveEntityQueryWrapper);
        }
        else if (type==1)//测试
        {
            QueryWrapper<TeacherTestEntity> teacherTestEntityQueryWrapper = new QueryWrapper<>();
            teacherTestEntityQueryWrapper.and(i->i.eq("user_id",userId).eq("test_id",subjectId));
            TeacherTestEntity teacherTestEntity = new TeacherTestEntity();
            teacherTestEntity.setTestId(subjectId);
            teacherTestService.update(teacherTestEntity,teacherTestEntityQueryWrapper);
        }else//作业
        {
            QueryWrapper<TeacherHomeworkEntity> teacherHomeworkEntityQueryWrapper = new QueryWrapper<>();
            teacherHomeworkEntityQueryWrapper .and(i->i.eq("user_id",userId).eq("homework_id",subjectId));
//            TeacherTestEntity teacherTestEntity = new TeacherTestEntity();
//            teacherTestEntity.setTestId(subjectId);
            TeacherHomeworkEntity teacherHomeworkEntity = new TeacherHomeworkEntity();
            teacherHomeworkService.update(teacherHomeworkEntity,teacherHomeworkEntityQueryWrapper);
        }
        return Resp.ok("成功");
    }
}
