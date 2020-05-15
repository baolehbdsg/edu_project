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
 * 课程与作业
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@ApiModel
@Data
@TableName("edu_course_homework")
public class CourseHomeworkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private Long id;
	/**
	 * 
	 */
	@ApiModelProperty(name = "courseId",value = "")
	private Long courseId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "homeworkId",value = "")
	private Long homeworkId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "createTime",value = "")
	private Date createTime;
	/**
	 * 截止日期必须指定
	 */
	@ApiModelProperty(name = "deadline",value = "截止日期必须指定")
	private Date deadline;
	/**
	 * 
	 */
	@ApiModelProperty(name = "canDelay",value = "")
	private Integer canDelay;

}
