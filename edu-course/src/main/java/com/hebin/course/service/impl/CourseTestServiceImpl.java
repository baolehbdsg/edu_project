/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.CourseTestDao;
import com.hebin.course.entity.CourseTestEntity;
import com.hebin.course.service.CourseTestService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("courseTestService")
public class CourseTestServiceImpl extends ServiceImpl<CourseTestDao, CourseTestEntity> implements CourseTestService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseTestEntity> page = this.page(
                new Query<CourseTestEntity>().getPage(params),
                new QueryWrapper<CourseTestEntity>()
        );

        return new PageVo(page);
    }

}