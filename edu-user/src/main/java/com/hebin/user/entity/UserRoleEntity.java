/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("edu_user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@ApiModelProperty(name = "userRoleId",value = "用户角色关联主键")
	@TableId(value = "user_role_id",type = IdType.AUTO)
	private Long userRoleId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userRoleUserid",value = "用户id")
	private String userRoleUserid;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userRoleRole",value = "角色id")
	private Long userRoleRole;

}
