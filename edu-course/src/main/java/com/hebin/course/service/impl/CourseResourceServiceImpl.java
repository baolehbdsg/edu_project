package com.hebin.course.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseResourceDao;
import com.hebin.course.entity.CourseResourceEntity;
import com.hebin.course.service.CourseResourceService;


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