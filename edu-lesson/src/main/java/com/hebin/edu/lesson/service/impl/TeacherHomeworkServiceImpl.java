package com.hebin.edu.lesson.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.lesson.dao.TeacherHomeworkDao;
import com.hebin.edu.lesson.entity.TeacherHomeworkEntity;
import com.hebin.edu.lesson.service.TeacherHomeworkService;


@Service("teacherHomeworkService")
public class TeacherHomeworkServiceImpl extends ServiceImpl<TeacherHomeworkDao, TeacherHomeworkEntity> implements TeacherHomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherHomeworkEntity> page = this.page(
                new Query<TeacherHomeworkEntity>().getPage(params),
                new QueryWrapper<TeacherHomeworkEntity>()
        );

        return new PageVo(page);
    }

}