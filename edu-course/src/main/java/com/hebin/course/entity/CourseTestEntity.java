/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程测试
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@ApiModel
@Data
@TableName("edu_course_test")
public class CourseTestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "testId",value = "")
	private Long testId;
	/**
	 * 是否删除（逻辑删除）
	 */
	@ApiModelProperty(name = "isDelete",value = "是否删除（逻辑删除）")
	private Integer isDelete;
	/**
	 * 
	 */
	@ApiModelProperty(name = "testTitle",value = "")
	private String testTitle;

}
