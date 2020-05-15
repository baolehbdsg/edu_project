/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 选择题作答情况
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@ApiModel
@Data
@TableName("edu_stu_test_choice")
public class StuTestChoiceEntity implements Serializable {
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
	@ApiModelProperty(name = "testId",value = "")
	private Long testId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "choiceId",value = "")
	private Long choiceId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userId",value = "")
	private Long userId;
	/**
	 * 题号靠前端来控制
	 */
	@ApiModelProperty(name = "number",value = "题号靠前端来控制")
	private Integer number;
	/**
	 * 
	 */
	@ApiModelProperty(name = "score",value = "")
	private String score;
	/**
	 * 
	 */
	@ApiModelProperty(name = "stuTestChoiceAnswer",value = "")
	private String stuTestChoiceAnswer;

}
