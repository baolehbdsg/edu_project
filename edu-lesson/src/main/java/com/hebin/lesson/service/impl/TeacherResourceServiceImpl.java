/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service.impl;

import com.hebin.lesson.dao.TeacherResourceDao;
import com.hebin.lesson.entity.TeacherResourceEntity;
import com.hebin.lesson.service.TeacherResourceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("teacherResourceService")
public class TeacherResourceServiceImpl extends ServiceImpl<TeacherResourceDao, TeacherResourceEntity> implements TeacherResourceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherResourceEntity> page = this.page(
                new Query<TeacherResourceEntity>().getPage(params),
                new QueryWrapper<TeacherResourceEntity>()
        );

        return new PageVo(page);
    }

}