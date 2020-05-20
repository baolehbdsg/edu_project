package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.core.bean.*;


/**
 * 教师与课程
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseTeacherService extends IService<CourseTeacherEntity> {

    PageVo queryPage(QueryCondition params);
    PageVo getCourseList(QueryCondition params,String userId);
}

