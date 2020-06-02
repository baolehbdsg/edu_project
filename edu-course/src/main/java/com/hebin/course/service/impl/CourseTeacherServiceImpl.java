package com.hebin.course.service.impl;

import com.hebin.course.entity.CourseEntity;
import com.hebin.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
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
    @Autowired
    CourseTeacherService courseTeacherService;
    @Autowired
    CourseService courseService;
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
        IPage<CourseEntity> page =new Query<CourseEntity>().getPage(params) ;
        QueryWrapper<CourseTeacherEntity> qw = new QueryWrapper<CourseTeacherEntity>();
        qw.eq("user_id",Long.parseLong(userId));
        //先获取CourseTeacherEntity的列表
        List<CourseTeacherEntity> courseTeacherEntities=courseTeacherService.list(qw);
        String courseIds [] = new String[courseTeacherEntities.size()];
        //通过course_id获取课程并分页
        for(int i=0;i<courseTeacherEntities.size();i++)
        {
            courseIds[i] = courseTeacherEntities.get(i).getCourseId();
        }
        System.out.println(courseIds.length);
        QueryWrapper<CourseEntity> qw2 = new QueryWrapper<CourseEntity>();
        qw2.in("course_id",courseIds);
        courseService.page(page,qw2);
        System.out.println(page.getRecords());
        return new PageVo(page);
    }

}