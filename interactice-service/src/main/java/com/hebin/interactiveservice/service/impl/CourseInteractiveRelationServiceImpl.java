package com.hebin.interactiveservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.interactiveservice.dao.CourseInteractiveRelationDao;
import com.hebin.interactiveservice.entity.CourseInteractiveRelationEntity;
import com.hebin.interactiveservice.service.CourseInteractiveRelationService;
import org.springframework.stereotype.Service;


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