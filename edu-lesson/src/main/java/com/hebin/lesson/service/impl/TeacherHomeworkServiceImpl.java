/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service.impl;

import com.hebin.lesson.dao.TeacherHomeworkDao;
import com.hebin.lesson.entity.TeacherHomeworkEntity;
import com.hebin.lesson.service.TeacherHomeworkService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("teacherHomeworkService")
public class TeacherHomeworkServiceImpl extends ServiceImpl<TeacherHomeworkDao, TeacherHomeworkEntity> implements TeacherHomeworkService {
//    @Autowired
//    ResourseFeign resourseFeign;
//    @Autowired
//    TeacherHomeworkService teacherHomeworkService;
//    @Override
//    public PageVo queryPage(QueryCondition params) {
//        IPage<TeacherHomeworkEntity> page = this.page(
//                new Query<TeacherHomeworkEntity>().getPage(params),
//                new QueryWrapper<TeacherHomeworkEntity>()
//        );
//
//        return new PageVo(page);
//    }
//
//    @Override
//    public String createHomework(LessonHomeworkVO lessonHomeworkVO) {
//        String userId="225";
//        //先保存homework实体
//        HomeworkEntity homeworkEntity = new HomeworkEntity();
//        BeanUtils.copyProperties(lessonHomeworkVO,homeworkEntity);
//        String homeworkId=resourseFeign.publishHomework(homeworkEntity).getData();
//        TeacherHomeworkEntity teacherHomeworkEntity =new TeacherHomeworkEntity();
//        teacherHomeworkEntity.setUserId(userId);
//        teacherHomeworkEntity.setHomeworkId(homeworkId);
//        teacherHomeworkService.save(teacherHomeworkEntity);
//        return "OK";
//    }
//
//    @Override
//    public PageVo queryPageById(QueryCondition queryCondition, String teacherId) {
//        IPage<TeacherHomeworkEntity> page = this.page(
//                new Query<TeacherHomeworkEntity>().getPage(queryCondition),
//                new QueryWrapper<TeacherHomeworkEntity>().eq("user_id",teacherId)
//        );
//        return new PageVo(page);
//    }
//
//    @Override
//    public HomeworkEntity getLessonHomeWorkDetail(String homeworkId) {
//        HomeworkEntity homeworkEntity = new HomeworkEntity();
//        homeworkEntity=resourseFeign.getHomeworkDetail(homeworkId).getData();
//        return homeworkEntity;
//    }

}