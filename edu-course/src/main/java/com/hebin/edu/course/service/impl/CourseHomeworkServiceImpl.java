package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.CourseHomeworkDao;
import com.hebin.edu.course.entity.CourseHomeworkEntity;
import com.hebin.edu.course.service.CourseHomeworkService;


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

}