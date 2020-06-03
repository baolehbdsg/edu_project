package com.hebin.course.service.impl;

import com.hebin.course.entity.AttendanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.AttendanceDetailDao;
import com.hebin.course.entity.AttendanceDetailEntity;
import com.hebin.course.service.AttendanceDetailService;


@Service("attendanceDetailService")
public class AttendanceDetailServiceImpl extends ServiceImpl<AttendanceDetailDao, AttendanceDetailEntity> implements AttendanceDetailService {
    @Autowired
    AttendanceDetailService attendanceDetailService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttendanceDetailEntity> page = this.page(
                new Query<AttendanceDetailEntity>().getPage(params),
                new QueryWrapper<AttendanceDetailEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo getAttendenceDetailList(QueryCondition queryCondition, String attendenceId) {
        IPage<AttendanceDetailEntity> page = new Query<AttendanceDetailEntity>().getPage(queryCondition);
        QueryWrapper<AttendanceDetailEntity> qw = new QueryWrapper<AttendanceDetailEntity>();
        qw.eq("attendanceId",attendenceId);
        attendanceDetailService.page(page,qw);
        return new PageVo(page);
    }


}