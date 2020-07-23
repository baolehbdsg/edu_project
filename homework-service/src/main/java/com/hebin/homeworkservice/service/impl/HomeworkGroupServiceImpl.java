/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.homeworkservice.dao.HomeworkGroupDao;
import com.hebin.homeworkservice.dao.StuHomeworkGroupDao;
import com.hebin.homeworkservice.entity.HomeworkGroupEntity;
import com.hebin.homeworkservice.entity.StuHomeworkGroupEntity;
import com.hebin.homeworkservice.service.HomeworkGroupService;
import com.hebin.homeworkservice.service.StuHomeworkGroupService;
import org.springframework.stereotype.Service;

@Service("homeworkGroupService")
public class HomeworkGroupServiceImpl extends ServiceImpl<HomeworkGroupDao, HomeworkGroupEntity> implements HomeworkGroupService {

}
