/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.CourseTeacherDao;
import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.course.service.CourseTeacherService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("courseTeacherService")
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherDao, CourseTeacherEntity> implements CourseTeacherService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseTeacherEntity> page = this.page(
                new Query<CourseTeacherEntity>().getPage(params),
                new QueryWrapper<CourseTeacherEntity>()
        );

        return new PageVo(page);
    }

}