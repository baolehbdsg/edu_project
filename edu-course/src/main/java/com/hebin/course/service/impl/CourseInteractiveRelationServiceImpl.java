/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.CourseInteractiveRelationDao;
import com.hebin.course.entity.CourseInteractiveRelationEntity;
import com.hebin.course.service.CourseInteractiveRelationService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("courseInteractiveRelationService")
public class CourseInteractiveRelationServiceImpl extends ServiceImpl<CourseInteractiveRelationDao, CourseInteractiveRelationEntity> implements CourseInteractiveRelationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseInteractiveRelationEntity> page = this.page(
                new Query<CourseInteractiveRelationEntity>().getPage(params),
                new QueryWrapper<CourseInteractiveRelationEntity>()
        );

        return new PageVo(page);
    }

}