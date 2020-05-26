/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.hebin.core.bean.*;
import com.hebin.testservice.entity.CourseTestRelationEntity;


/**
 * 加入到课程区的，或课程区测试
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseTestRelationService extends IService<CourseTestRelationEntity> {

    PageVo queryPage(QueryCondition params);
}

