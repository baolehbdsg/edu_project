package com.hebin.edu.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.course.entity.CourseHomeworkEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 课程与作业
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
public interface CourseHomeworkService extends IService<CourseHomeworkEntity> {

    PageVo queryPage(QueryCondition params);
}

