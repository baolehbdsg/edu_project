package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.AttendanceEntity;
import com.hebin.core.bean.*;


/**
 * 考勤
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface AttendanceService extends IService<AttendanceEntity> {

    PageVo queryPage(QueryCondition params);
}

