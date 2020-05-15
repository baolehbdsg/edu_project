/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.AttendanceDao;
import com.hebin.course.entity.AttendanceEntity;
import com.hebin.course.service.AttendanceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("attendanceService")
public class AttendanceServiceImpl extends ServiceImpl<AttendanceDao, AttendanceEntity> implements AttendanceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttendanceEntity> page = this.page(
                new Query<AttendanceEntity>().getPage(params),
                new QueryWrapper<AttendanceEntity>()
        );

        return new PageVo(page);
    }

}