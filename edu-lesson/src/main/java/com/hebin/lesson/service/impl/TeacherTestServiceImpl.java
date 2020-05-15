/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service.impl;

import com.hebin.lesson.dao.TeacherTestDao;
import com.hebin.lesson.entity.TeacherTestEntity;
import com.hebin.lesson.service.TeacherTestService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("teacherTestService")
public class TeacherTestServiceImpl extends ServiceImpl<TeacherTestDao, TeacherTestEntity> implements TeacherTestService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherTestEntity> page = this.page(
                new Query<TeacherTestEntity>().getPage(params),
                new QueryWrapper<TeacherTestEntity>()
        );

        return new PageVo(page);
    }

}