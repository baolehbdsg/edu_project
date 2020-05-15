/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.service.impl;

import com.hebin.user.dao.TeacherDao;
import com.hebin.user.entity.TeacherEntity;
import com.hebin.user.service.TeacherService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherEntity> page = this.page(
                new Query<TeacherEntity>().getPage(params),
                new QueryWrapper<TeacherEntity>()
        );

        return new PageVo(page);
    }

}