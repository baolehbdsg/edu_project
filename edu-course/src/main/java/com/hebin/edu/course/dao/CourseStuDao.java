package com.hebin.edu.course.dao;

import com.hebin.edu.course.entity.CourseStuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生参与课程
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@Mapper
public interface CourseStuDao extends BaseMapper<CourseStuEntity> {
	
}
