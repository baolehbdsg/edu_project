/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 简答题作答情况
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:00
 */
@ApiModel
@Data
@TableName("edu_stu_test_qa")
public class StuTestQaEntity implements Serializable {
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
	@ApiModelProperty(name = "userId",value = "")
	private String userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "qaId",value = "")
	private String qaId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "testId",value = "")
	private String testId;
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
	@ApiModelProperty(name = "stuInteractiveQaAnswer",value = "")
	private String stuInteractiveQaAnswer;

}
