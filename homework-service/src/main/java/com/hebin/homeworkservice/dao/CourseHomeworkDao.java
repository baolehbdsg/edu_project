package com.hebin.homeworkservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hebin.homeworkservice.entity.CourseHomeworkEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程与作业
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Mapper
public interface CourseHomeworkDao extends BaseMapper<CourseHomeworkEntity> {
	
}
