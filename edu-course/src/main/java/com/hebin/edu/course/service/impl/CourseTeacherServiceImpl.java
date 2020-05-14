package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.CourseTeacherDao;
import com.hebin.edu.course.entity.CourseTeacherEntity;
import com.hebin.edu.course.service.CourseTeacherService;


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