package com.hebin.edu.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.course.entity.CourseStuEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 学生参与课程
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
public interface CourseStuService extends IService<CourseStuEntity> {

    PageVo queryPage(QueryCondition params);
}

