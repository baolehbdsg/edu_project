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
@TableName("edu_teacher")
public class TeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "userId",value = "")
	private Long userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userName",value = "")
	private String userName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userGender",value = "")
	private Integer userGender;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userTel",value = "")
	private String userTel;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userWechatId",value = "")
	private String userWechatId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userNickname",value = "")
	private String userNickname;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userMail",value = "")
	private String userMail;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userPassword",value = "")
	private String userPassword;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userAvatar",value = "")
	private String userAvatar;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isBindwechat",value = "")
	private Integer isBindwechat;
	/**
	 * 
	 */
	@ApiModelProperty(name = "registerTime",value = "")
	private Date registerTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isBanned",value = "")
	private Integer isBanned;

}
