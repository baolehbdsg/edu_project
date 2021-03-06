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
import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class TeacherEntity extends UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 说明：
	 * 教师用户注册给的id也必修是一个数值形式的字符串，或者空值
	 * 否则会报错、
	 * 报错处理--自定义异常
	 * */

	@ApiModelProperty(name = "userId",value = "")
	@TableId(value = "user_id",type = IdType.ID_WORKER_STR)
	private String userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userName",value = "")
	private String userName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userGender",value = "0")
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
	@TableLogic
	@ApiModelProperty(name = "isDelete",value = "0")
	private Integer isDelete;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isBanned",value = "0")
	private Integer isBanned;

}
