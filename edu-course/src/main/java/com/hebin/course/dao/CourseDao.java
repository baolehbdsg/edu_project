package com.hebin.course.dao;

import com.hebin.course.entity.CourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Mapper
public interface CourseDao extends BaseMapper<CourseEntity> {
	
}
