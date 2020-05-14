package com.hebin.edu.course.dao;

import com.hebin.edu.course.entity.CourseTestRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 加入到课程区的，或课程区测试
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Mapper
public interface CourseTestRelationDao extends BaseMapper<CourseTestRelationEntity> {
	
}
