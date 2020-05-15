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
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("teacherHomeworkService")
public class TeacherHomeworkServiceImpl extends ServiceImpl<TeacherHomeworkDao, TeacherHomeworkEntity> implements TeacherHomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherHomeworkEntity> page = this.page(
                new Query<TeacherHomeworkEntity>().getPage(params),
                new QueryWrapper<TeacherHomeworkEntity>()
        );

        return new PageVo(page);
    }

}