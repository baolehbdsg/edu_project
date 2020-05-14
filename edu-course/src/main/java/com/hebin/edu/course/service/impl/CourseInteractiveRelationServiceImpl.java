package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.CourseInteractiveRelationDao;
import com.hebin.edu.course.entity.CourseInteractiveRelationEntity;
import com.hebin.edu.course.service.CourseInteractiveRelationService;


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