package com.hebin.edu.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.course.entity.AttendanceEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 考勤
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
public interface AttendanceService extends IService<AttendanceEntity> {

    PageVo queryPage(QueryCondition params);
}

