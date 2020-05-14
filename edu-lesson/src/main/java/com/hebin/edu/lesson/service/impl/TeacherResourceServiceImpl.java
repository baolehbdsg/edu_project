package com.hebin.edu.lesson.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.lesson.dao.TeacherResourceDao;
import com.hebin.edu.lesson.entity.TeacherResourceEntity;
import com.hebin.edu.lesson.service.TeacherResourceService;


@Service("teacherResourceService")
public class TeacherResourceServiceImpl extends ServiceImpl<TeacherResourceDao, TeacherResourceEntity> implements TeacherResourceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherResourceEntity> page = this.page(
                new Query<TeacherResourceEntity>().getPage(params),
                new QueryWrapper<TeacherResourceEntity>()
        );

        return new PageVo(page);
    }

}