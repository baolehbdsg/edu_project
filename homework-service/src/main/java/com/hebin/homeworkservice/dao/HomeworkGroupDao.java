/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hebin.homeworkservice.entity.HomeworkGroupEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生与作业
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@Mapper
public interface HomeworkGroupDao extends BaseMapper<HomeworkGroupEntity> {
	
}
