package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.AttendanceDetailDao;
import com.hebin.edu.course.entity.AttendanceDetailEntity;
import com.hebin.edu.course.service.AttendanceDetailService;


@Service("attendanceDetailService")
public class AttendanceDetailServiceImpl extends ServiceImpl<AttendanceDetailDao, AttendanceDetailEntity> implements AttendanceDetailService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttendanceDetailEntity> page = this.page(
                new Query<AttendanceDetailEntity>().getPage(params),
                new QueryWrapper<AttendanceDetailEntity>()
        );

        return new PageVo(page);
    }

}