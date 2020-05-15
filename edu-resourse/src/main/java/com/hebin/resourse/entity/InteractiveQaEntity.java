/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@ApiModel
@Data
@TableName("edu_interactive_qa")
public class InteractiveQaEntity implements Serializable {
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
	@ApiModelProperty(name = "interactiveId",value = "")
	private Long interactiveId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "qaId",value = "")
	private Long qaId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "number",value = "")
	private Integer number;

}
