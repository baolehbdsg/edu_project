/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.CourseTestRelationDao;
import com.hebin.course.entity.CourseTestRelationEntity;
import com.hebin.course.service.CourseTestRelationService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("courseTestRelationService")
public class CourseTestRelationServiceImpl extends ServiceImpl<CourseTestRelationDao, CourseTestRelationEntity> implements CourseTestRelationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseTestRelationEntity> page = this.page(
                new Query<CourseTestRelationEntity>().getPage(params),
                new QueryWrapper<CourseTestRelationEntity>()
        );

        return new PageVo(page);
    }

}