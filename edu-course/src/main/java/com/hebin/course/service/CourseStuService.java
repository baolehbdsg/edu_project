package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.CourseStuEntity;
import com.hebin.core.bean.*;


/**
 * 学生参与课程
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseStuService extends IService<CourseStuEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo getListCourseStu(QueryCondition params,String courseId);
    PageVo getListStuCourseInfo(QueryCondition params,String courseId);
}

