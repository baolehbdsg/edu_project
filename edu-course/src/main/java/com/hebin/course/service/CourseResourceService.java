/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service;

import com.hebin.course.entity.CourseResourceEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 课程与资源
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
public interface CourseResourceService extends IService<CourseResourceEntity> {

    PageVo queryPage(QueryCondition params);
}

