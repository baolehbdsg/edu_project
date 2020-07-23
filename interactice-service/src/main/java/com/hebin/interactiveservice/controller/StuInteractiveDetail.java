/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.Resp;
import com.hebin.interactiveservice.DTO.StuCommitedInteractiveDTO;
import com.hebin.interactiveservice.DTO.TeacherViewInteractiveList;
import com.hebin.interactiveservice.VO.StuCommmitedInteractiveDetailVO;
import com.hebin.interactiveservice.entity.StuChoiceInteractiveEntity;
import com.hebin.interactiveservice.entity.StuQaInteractiveEntity;
import com.hebin.interactiveservice.feign.UserFeign;
import com.hebin.interactiveservice.service.StuChoiceInteractiveService;
import com.hebin.interactiveservice.service.StuQaInteractiveService;
import com.hebin.user.entity.StudentEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "互动作答情况")
@RestController
@RequestMapping("/interactive")
public class StuInteractiveDetail {
    @Autowired
    StuChoiceInteractiveService stuChoiceInteractiveService;
    @Autowired
    StuQaInteractiveService stuQaInteractiveService;
    @Autowired
    UserFeign userFeign;
    @ApiOperation("查询作答情况")
    @PostMapping("/stucommitted")
    public Resp<Object> commitTest(@RequestBody StuCommmitedInteractiveDetailVO stuCommmitedInteractiveDetailVO)
    {


        //从token中获取用户信息
        String userId = "11";
        //判断用户权限，如果是学生只能看到自己的，是教师就能看到该试题下的所有学生作答情况
        if(userId=="13")
        {
            //返回给前端的传输模型
            StuCommitedInteractiveDTO stuCommitedInteractiveDTO  = new StuCommitedInteractiveDTO();
            if(stuCommmitedInteractiveDetailVO.getChoiceType()!=null)
            {
                QueryWrapper<StuChoiceInteractiveEntity> stuChoiceInteractiveEntityQueryWrapper = new QueryWrapper<>();
                stuChoiceInteractiveEntityQueryWrapper.and(p->p.eq("user_id",userId).eq("interactive_id",stuCommmitedInteractiveDetailVO.getInteractiveId()
                ).eq("choice_id",stuCommmitedInteractiveDetailVO.getSubjectId()));
                StuChoiceInteractiveEntity stuChoiceInteractiveEntity=stuChoiceInteractiveService.getOne(stuChoiceInteractiveEntityQueryWrapper);

                BeanUtils.copyProperties(stuChoiceInteractiveEntity,stuCommitedInteractiveDTO);
                stuCommitedInteractiveDTO.setAnswer(stuChoiceInteractiveEntity.getStuInteractiveChoiceAnswer());
                stuCommitedInteractiveDTO.setSubjectId(stuChoiceInteractiveEntity.getChoiceId());
                return Resp.ok(stuCommitedInteractiveDTO);
            }
            else
            {
                QueryWrapper<StuQaInteractiveEntity> stuQaInteractiveEntityQueryWrapper = new QueryWrapper<>();
                stuQaInteractiveEntityQueryWrapper.and(p->p.eq("user_id",userId).eq("interactive_id",stuCommmitedInteractiveDetailVO.getInteractiveId())
                .eq("qa_id",stuCommmitedInteractiveDetailVO.getSubjectId()));
                StuQaInteractiveEntity stuQaInteractiveEntity = stuQaInteractiveService.getOne(stuQaInteractiveEntityQueryWrapper);
                BeanUtils.copyProperties(stuQaInteractiveEntity,stuCommitedInteractiveDTO);
                stuCommitedInteractiveDTO.setAnswer(stuQaInteractiveEntity.getStuInteractiveQaAnswer());
                stuCommitedInteractiveDTO.setSubjectId(stuQaInteractiveEntity.getQaId());
                return Resp.ok(stuCommitedInteractiveDTO);
            }
        }
        //权限为教师的时候，查看的是某个试题所有学生的提交情况
        else{
            if(stuCommmitedInteractiveDetailVO.getChoiceType()!=null)
            {
                //填写条件
                QueryWrapper<StuChoiceInteractiveEntity> stuChoiceInteractiveEntityQueryWrapper = new QueryWrapper<>();
                stuChoiceInteractiveEntityQueryWrapper.and(p->p.eq("interactive_id",stuCommmitedInteractiveDetailVO.getInteractiveId()).eq("choice_id",
                        stuCommmitedInteractiveDetailVO.getSubjectId()));
                //根据互动id和选择题id查出回答记录的list
                List<StuChoiceInteractiveEntity> stuChoiceInteractiveEntities=stuChoiceInteractiveService.list(stuChoiceInteractiveEntityQueryWrapper);
                //提取这个list中的所有学生用户的id
                String [] ids = new String[stuChoiceInteractiveEntities.size()];
                for(int i = 0;i<stuChoiceInteractiveEntities.size();i++)
                {
                    ids[i] = stuChoiceInteractiveEntities.get(i).getUserId();
                }
                //然后远程调用返回学生的信息
                List<StudentEntity> studentEntities=userFeign.userListByIds(ids);
                //重新封装，然后返回给教师用户
                //封装内容
                //学生头像，学生姓名，学生id
                //回答的答案
                List<TeacherViewInteractiveList> teacherViewInteractiveLists = new ArrayList<>();
                for(int i = 0;i<stuChoiceInteractiveEntities.size();i++)
                {
                    TeacherViewInteractiveList teacherViewInteractiveList = new TeacherViewInteractiveList();
                    BeanUtils.copyProperties(stuChoiceInteractiveEntities.get(i),teacherViewInteractiveList);
                    teacherViewInteractiveList.setAnswer(stuChoiceInteractiveEntities.get(i).getStuInteractiveChoiceAnswer());
                    teacherViewInteractiveLists.add(teacherViewInteractiveList);
                }
                for(int i=0;i<teacherViewInteractiveLists.size();i++)
                {
                    for(int j=0;j<studentEntities.size();j++)
                    {
                        if(teacherViewInteractiveLists.get(i).getUserId().equals(studentEntities.get(j).getUserId()))
                        {
                            System.out.println(1);
                            BeanUtils.copyProperties(studentEntities.get(j),teacherViewInteractiveLists.get(i));
                        }
                    }
                }
                return Resp.ok(teacherViewInteractiveLists);

            }
            else{
                //填写条件
                QueryWrapper<StuQaInteractiveEntity> stuQaInteractiveEntityQueryWrapper = new QueryWrapper<>();
                stuQaInteractiveEntityQueryWrapper.and(p->p.eq("interactive_id",stuCommmitedInteractiveDetailVO.getInteractiveId()).eq("qa_id",
                        stuCommmitedInteractiveDetailVO.getSubjectId()));
                //根据互动id和选择题id查出回答记录的list
                List<StuQaInteractiveEntity> stuQaInteractiveEntities=stuQaInteractiveService.list(stuQaInteractiveEntityQueryWrapper);
                //提取这个list中的所有学生用户的id
                String [] ids = new String[stuQaInteractiveEntities.size()];
                for(int i = 0;i<stuQaInteractiveEntities.size();i++)
                {
                    ids[i] = stuQaInteractiveEntities.get(i).getUserId();
                }
                //然后远程调用返回学生的信息
                List<StudentEntity> studentEntities=userFeign.userListByIds(ids);
                //重新封装，然后返回给教师用户
                //封装内容
                //学生头像，学生姓名，学生id
                //回答的答案
                List<TeacherViewInteractiveList> teacherViewInteractiveLists = new ArrayList<>();
                for(int i = 0;i<stuQaInteractiveEntities.size();i++)
                {
                    TeacherViewInteractiveList teacherViewInteractiveList = new TeacherViewInteractiveList();
                    BeanUtils.copyProperties(stuQaInteractiveEntities.get(i),teacherViewInteractiveList);
                    teacherViewInteractiveList.setAnswer(stuQaInteractiveEntities.get(i).getStuInteractiveQaAnswer());
                    teacherViewInteractiveLists.add(teacherViewInteractiveList);
                }
                for(int i=0;i<teacherViewInteractiveLists.size();i++)
                {
                    for(int j=0;j<studentEntities.size();j++)
                    {
                        if(teacherViewInteractiveLists.get(i).getUserId().equals(studentEntities.get(j).getUserId()))
                        {
                            BeanUtils.copyProperties(studentEntities.get(j),teacherViewInteractiveLists.get(i));
                            break;
                        }
                    }
                }
                return Resp.ok(teacherViewInteractiveLists);
            }
        }
    }
}
