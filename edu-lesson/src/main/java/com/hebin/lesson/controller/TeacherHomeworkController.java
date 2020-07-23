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
import com.hebin.lesson.DTO.ListHomeworkDTO;
import com.hebin.lesson.VO.CreateHomeWorkVO;
import com.hebin.lesson.entity.TeacherDir;
import com.hebin.lesson.entity.TeacherHomeworkEntity;
import com.hebin.lesson.feign.ResourseFeign;
import com.hebin.lesson.service.TeacherDirService;
import com.hebin.lesson.service.TeacherHomeworkService;
import com.hebin.resourse.entity.HomeworkEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = "教师与作业 管理")
@RestController
@RequestMapping("lesson/teacherhomework")
public class TeacherHomeworkController {
    @Autowired
    private TeacherHomeworkService teacherHomeworkService;
    @Autowired
    ResourseFeign resourseFeign;
    @Autowired
    TeacherDirService teacherDirService;
    /**
     * 在课程区创建作业
     */
    @ApiOperation("创建作业")
    @PostMapping("/createhomework")
    public Resp<Object> createHomeWork(@RequestBody CreateHomeWorkVO createHomeWorkVO) {
        String userId = "245";
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        TeacherHomeworkEntity teacherHomeworkEntity = new TeacherHomeworkEntity();
        BeanUtils.copyProperties(createHomeWorkVO,homeworkEntity);
        BeanUtils.copyProperties(createHomeWorkVO,teacherHomeworkEntity);
        String homeworkId = resourseFeign.publishHomework(homeworkEntity);
        System.out.println(homeworkId);
        teacherHomeworkEntity.setUserId(userId);
        teacherHomeworkEntity.setHomeworkId(homeworkId);
        teacherHomeworkEntity.setIsDelete(0);
        teacherHomeworkEntity.setCreateTime(new Date());
       teacherHomeworkService.save(teacherHomeworkEntity);
        return Resp.ok(homeworkId);
    }
    @ApiOperation("查看作业区")
    @GetMapping("/listhomework")
    public Resp<Object> listHomeWork(@RequestParam("fatherId")String fatherId) {
        String userId = "245";
        //步骤：1查询所有互动且父文件夹id为0的
        //2.远程调用获取这些id的实体
        //3.查询dir下的type=0的且父文件夹id为0的
        //4.返回一个统一对象
        ListHomeworkDTO listHomeworkDTO = new ListHomeworkDTO();
        QueryWrapper<TeacherHomeworkEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("user_id",userId).eq("father_id",fatherId).ne("is_delete",1));
        List<TeacherHomeworkEntity> teacherHomeworkEntities=teacherHomeworkService.list(queryWrapper);
        String ids[] = new String[teacherHomeworkEntities.size()];
        for(int i = 0;i<teacherHomeworkEntities.size();i++)
        {
            ids[i] = teacherHomeworkEntities.get(i).getHomeworkId();
        }
        //返回结果1
        listHomeworkDTO.setHomeworkEntities(resourseFeign.listHomework(ids));
       //返回结果2
        QueryWrapper<TeacherDir> teacherDirQueryWrapper = new QueryWrapper<>();
        teacherDirQueryWrapper.and(i->i.eq("user_id",userId).eq("father_dir_id",fatherId).eq("type",2));
        listHomeworkDTO.setTeacherDirs(teacherDirService.list(teacherDirQueryWrapper));
        return Resp.ok(listHomeworkDTO);
    }
    //
    @ApiOperation("查看作业详情")
    @GetMapping("/detailhomework")
    public Resp<HomeworkEntity> detailHomeWork(@PathVariable("homeworkId") String homeworkId)
    {
        return resourseFeign.getHomeworkDetail(homeworkId);
    }
    @ApiOperation("修改作业")
    @PostMapping("/update")
    public Resp<Object> updateHomeWork(@RequestBody HomeworkEntity homework)
    {
        return resourseFeign.update(homework);
    }
    @ApiOperation("删除作业")
    @GetMapping("/update")
    public Resp<Object> deleteHomeWork(@RequestParam("homeworkId") String homeworkId)
    {
        //直接删除这层关系即可
        String userId = "245";
        QueryWrapper<TeacherHomeworkEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("user_id",userId).eq("homework_id",homeworkId));
        teacherHomeworkService.remove(queryWrapper);
        return Resp.ok("删除成功");
    }


}


