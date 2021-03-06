/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hebin.testservice.entity.StuTestQaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 简答题作答情况
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:00
 */
@Mapper
public interface StuTestQaDao extends BaseMapper<StuTestQaEntity> {
	
}
