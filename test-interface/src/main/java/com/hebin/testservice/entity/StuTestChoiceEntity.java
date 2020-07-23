/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
	private String testId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "choiceId",value = "")
	private String choiceId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userId",value = "")
	private String userId;
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

	@ApiModelProperty(name="完成时间")
	private Date finishTime;

	@TableLogic
	@ApiModelProperty(name="逻辑删除")
	private Integer isDelete;
}
