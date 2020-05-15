package com.hebin.course.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseTestRelationDao;
import com.hebin.course.entity.CourseTestRelationEntity;
import com.hebin.course.service.CourseTestRelationService;


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