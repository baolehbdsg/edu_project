package com.hebin.edu.lesson.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.lesson.dao.TeacherTestDao;
import com.hebin.edu.lesson.entity.TeacherTestEntity;
import com.hebin.edu.lesson.service.TeacherTestService;


@Service("teacherTestService")
public class TeacherTestServiceImpl extends ServiceImpl<TeacherTestDao, TeacherTestEntity> implements TeacherTestService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherTestEntity> page = this.page(
                new Query<TeacherTestEntity>().getPage(params),
                new QueryWrapper<TeacherTestEntity>()
        );

        return new PageVo(page);
    }

}