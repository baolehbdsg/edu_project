/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.CourseResourceDao;
import com.hebin.course.entity.CourseResourceEntity;
import com.hebin.course.service.CourseResourceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("courseResourceService")
public class CourseResourceServiceImpl extends ServiceImpl<CourseResourceDao, CourseResourceEntity> implements CourseResourceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseResourceEntity> page = this.page(
                new Query<CourseResourceEntity>().getPage(params),
                new QueryWrapper<CourseResourceEntity>()
        );

        return new PageVo(page);
    }

}