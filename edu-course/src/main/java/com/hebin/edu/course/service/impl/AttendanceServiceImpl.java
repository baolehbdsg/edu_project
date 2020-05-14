package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.AttendanceDao;
import com.hebin.edu.course.entity.AttendanceEntity;
import com.hebin.edu.course.service.AttendanceService;


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