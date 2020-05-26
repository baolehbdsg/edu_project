package com.hebin.homeworkservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.homeworkservice.DTO.HomeworkDetailDTO;
import com.hebin.homeworkservice.VO.HomeworkVO;
import com.hebin.homeworkservice.VO.ImportHomeworkVO;
import com.hebin.homeworkservice.entity.CourseHomeworkEntity;


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

    HomeworkDetailDTO getHomeworkDetail(String homeworkId, String courseId);
}

