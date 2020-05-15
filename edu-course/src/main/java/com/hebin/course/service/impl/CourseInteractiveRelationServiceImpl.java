package com.hebin.course.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseInteractiveRelationDao;
import com.hebin.course.entity.CourseInteractiveRelationEntity;
import com.hebin.course.service.CourseInteractiveRelationService;


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