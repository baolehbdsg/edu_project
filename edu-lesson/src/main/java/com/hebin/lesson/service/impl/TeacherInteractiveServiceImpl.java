/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.service.impl;

import com.hebin.lesson.dao.TeacherInteractiveDao;
import com.hebin.lesson.entity.TeacherInteractiveEntity;
import com.hebin.lesson.service.TeacherInteractiveService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("teacherInteractiveService")
public class TeacherInteractiveServiceImpl extends ServiceImpl<TeacherInteractiveDao, TeacherInteractiveEntity> implements TeacherInteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherInteractiveEntity> page = this.page(
                new Query<TeacherInteractiveEntity>().getPage(params),
                new QueryWrapper<TeacherInteractiveEntity>()
        );

        return new PageVo(page);
    }

}