package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.CourseTestDao;
import com.hebin.edu.course.entity.CourseTestEntity;
import com.hebin.edu.course.service.CourseTestService;


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