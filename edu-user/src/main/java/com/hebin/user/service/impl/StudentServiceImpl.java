/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.service.impl;

import com.hebin.user.VO.CourseStuVO;
import com.hebin.user.dao.StudentDao;
import com.hebin.user.entity.StudentEntity;
import com.hebin.user.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<StudentEntity>()
        );

        return new PageVo(page);
    }

//    @Override
//    public PageVo getCourseStu(CourseStuVO courseStuVO) {
//        QueryCondition queryCondition =new QueryCondition();
//        BeanUtils.copyProperties(courseStuVO,queryCondition);
//        IPage<StudentEntity> page;
//        QueryWrapper<StudentEntity> qw = new QueryWrapper();
//        qw.eq("user_id",courseStuVO.get);
//        return null;
//    }

}