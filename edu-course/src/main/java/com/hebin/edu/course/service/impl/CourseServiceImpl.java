package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.CourseDao;
import com.hebin.edu.course.entity.CourseEntity;
import com.hebin.edu.course.service.CourseService;


@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseEntity> page = this.page(
                new Query<CourseEntity>().getPage(params),
                new QueryWrapper<CourseEntity>()
        );

        return new PageVo(page);
    }

}