package com.hebin.course.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseTeacherDao;
import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.course.service.CourseTeacherService;


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

    @Override
    public PageVo getCourseList(QueryCondition params, String userId) {
        IPage<CourseTeacherEntity> page =new Query<CourseTeacherEntity>().getPage(params) ;
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",Long.parseLong(userId));
        baseMapper.selectPage(page,qw);
        return new PageVo(page);
    }

}