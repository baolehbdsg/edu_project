package com.hebin.course.dao;

import com.hebin.course.entity.CourseTestRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
