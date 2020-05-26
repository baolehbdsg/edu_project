package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.VO.CourseVO;
import com.hebin.course.entity.CourseEntity;
import com.hebin.core.bean.*;


/**
 * 课程
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseService extends IService<CourseEntity> {

//    PageVo createCourse(CourseVO courseVO);

    PageVo queryPage(QueryCondition params);
}

