/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.course.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hebin.course.entity.GroupEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupDao extends BaseMapper<GroupEntity> {
}
