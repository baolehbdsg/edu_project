/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.entity;

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
 * @date 2020-05-13 19:48:49
 */
@ApiModel
@Data
@TableName("edu_admin")
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "adminId",value = "")
	private Integer adminId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "adminName",value = "")
	private String adminName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "adminPassword",value = "")
	private String adminPassword;
	/**
	 * 
	 */
	@ApiModelProperty(name = "adminAvatar",value = "")
	private String adminAvatar;

}
