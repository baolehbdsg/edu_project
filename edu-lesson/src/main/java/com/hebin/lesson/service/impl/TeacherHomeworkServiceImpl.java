/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service.impl;

import com.hebin.lesson.VO.LessonHomeworkVO;
import com.hebin.lesson.dao.TeacherHomeworkDao;
import com.hebin.lesson.entiry.TeacherHomeworkEntity;
import com.hebin.lesson.feign.ResourseFeign;
import com.hebin.lesson.service.TeacherHomeworkService;
import com.hebin.resourse.entity.HomeworkEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("teacherHomeworkService")
public class TeacherHomeworkServiceImpl extends ServiceImpl<TeacherHomeworkDao, TeacherHomeworkEntity> implements TeacherHomeworkService {
    @Autowired
    ResourseFeign resourseFeign;
    @Autowired
    TeacherHomeworkService teacherHomeworkService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherHomeworkEntity> page = this.page(
                new Query<TeacherHomeworkEntity>().getPage(params),
                new QueryWrapper<TeacherHomeworkEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public String createHomework(LessonHomeworkVO lessonHomeworkVO) {
        //先保存homework实体
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        BeanUtils.copyProperties(lessonHomeworkVO,homeworkEntity);
        String homeworkId=resourseFeign.publishHomework(homeworkEntity).getData();
        TeacherHomeworkEntity teacherHomeworkEntity =new TeacherHomeworkEntity();
        teacherHomeworkEntity.setUserId(lessonHomeworkVO.getUserId());
        teacherHomeworkEntity.setHomeworkId(homeworkId);
        teacherHomeworkService.save(teacherHomeworkEntity);
        return "OK";
    }

}