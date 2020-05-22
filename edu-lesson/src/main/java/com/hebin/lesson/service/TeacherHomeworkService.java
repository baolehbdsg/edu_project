/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.lesson.VO.LessonHomeworkVO;
import com.hebin.lesson.entiry.TeacherHomeworkEntity;
import com.hebin.resourse.entity.HomeworkEntity;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
public interface TeacherHomeworkService extends IService<TeacherHomeworkEntity> {

    PageVo queryPage(QueryCondition params);

    String createHomework(LessonHomeworkVO lessonHomeworkVO);

    PageVo queryPageById(QueryCondition queryCondition, String teacherId);

    HomeworkEntity getLessonHomeWorkDetail(String homeworkId);
}

