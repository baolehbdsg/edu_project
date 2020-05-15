package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.AttendanceDetailEntity;
import com.hebin.core.bean.*;


/**
 * 考勤详情
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface AttendanceDetailService extends IService<AttendanceDetailEntity> {

    PageVo queryPage(QueryCondition params);
}

