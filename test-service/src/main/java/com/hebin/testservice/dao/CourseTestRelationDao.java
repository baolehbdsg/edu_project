/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hebin.testservice.entity.CourseTestRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 加入到课程区的，或课程区测试
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Mapper
public interface CourseTestRelationDao extends BaseMapper<CourseTestRelationEntity> {
	
}
