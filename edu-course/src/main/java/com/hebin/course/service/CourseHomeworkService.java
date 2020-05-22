package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.*;
import com.hebin.course.VO.HomeworkVO;
import com.hebin.course.VO.ImportHomeworkVO;
import com.hebin.course.entity.CourseHomeworkEntity;


/**
 * 课程与作业
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseHomeworkService extends IService<CourseHomeworkEntity> {

    PageVo queryPage(QueryCondition params);
    PageVo getCourseHomeworkList(QueryCondition params,String courseId);

    String createCourseHomework(HomeworkVO homeworkVO);

    String importCourseHomework(ImportHomeworkVO importHomeworkVO);
}

