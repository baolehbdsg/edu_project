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
 * 学生互动选择
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@ApiModel
@Data
@TableName("edu_stu_choice_interactive")
public class StuChoiceInteractiveEntity implements Serializable {
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
	@ApiModelProperty(name = "interactiveId",value = "")
	private String interactiveId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "choiceId",value = "")
	private String choiceId;
	/**
	 * 题号靠前端来控制
	 */
	@ApiModelProperty(name = "number",value = "题号靠前端来控制")
	private Integer number;
	/**
	 * 
	 */
	@ApiModelProperty(name = "学生互动选择题答案",value = "")
	private String stuInteractiveChoiceAnswer;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isRight",value = "")
	private Integer isRight;

}
