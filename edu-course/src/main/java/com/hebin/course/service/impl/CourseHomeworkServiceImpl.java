package com.hebin.course.service.impl;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseHomeworkDao;
import com.hebin.course.entity.CourseHomeworkEntity;
import com.hebin.course.service.CourseHomeworkService;


@Service("courseHomeworkService")
public class CourseHomeworkServiceImpl extends ServiceImpl<CourseHomeworkDao, CourseHomeworkEntity> implements CourseHomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseHomeworkEntity> page = this.page(
                new Query<CourseHomeworkEntity>().getPage(params),
                new QueryWrapper<CourseHomeworkEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo getCourseHomeworkList(QueryCondition params,String courseId) {
        IPage<CourseHomeworkEntity> page=new Query<CourseHomeworkEntity>().getPage(params);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("course_id",Long.parseLong(courseId));
        baseMapper.selectPage(page,qw);
        return new PageVo(page);
    }

}