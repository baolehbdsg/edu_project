package com.hebin.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.AttendanceDao;
import com.hebin.course.entity.AttendanceEntity;
import com.hebin.course.service.AttendanceService;


@Service("attendanceService")
public class AttendanceServiceImpl extends ServiceImpl<AttendanceDao, AttendanceEntity> implements AttendanceService {
    @Autowired
    AttendanceService attendanceService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttendanceEntity> page = this.page(
                new Query<AttendanceEntity>().getPage(params),
                new QueryWrapper<AttendanceEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo getlistpage(QueryCondition queryCondition, String courseId) {
        IPage<AttendanceEntity> page = new Query<AttendanceEntity>().getPage(queryCondition);
        QueryWrapper<AttendanceEntity> qw = new QueryWrapper<>();
        qw.eq("course_id",courseId);
        attendanceService.page(page,qw);
        return new PageVo(page);
    }


}