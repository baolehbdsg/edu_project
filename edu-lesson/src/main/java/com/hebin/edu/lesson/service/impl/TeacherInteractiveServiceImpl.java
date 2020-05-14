package com.hebin.edu.lesson.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.lesson.dao.TeacherInteractiveDao;
import com.hebin.edu.lesson.entity.TeacherInteractiveEntity;
import com.hebin.edu.lesson.service.TeacherInteractiveService;


@Service("teacherInteractiveService")
public class TeacherInteractiveServiceImpl extends ServiceImpl<TeacherInteractiveDao, TeacherInteractiveEntity> implements TeacherInteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TeacherInteractiveEntity> page = this.page(
                new Query<TeacherInteractiveEntity>().getPage(params),
                new QueryWrapper<TeacherInteractiveEntity>()
        );

        return new PageVo(page);
    }

}