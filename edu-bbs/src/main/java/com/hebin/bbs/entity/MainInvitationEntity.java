/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.entity;

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
 * @date 2020-05-13 14:24:50
 */
@ApiModel
@Data
@TableName("edu_main_invitation")
public class MainInvitationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "invitationId",value = "")
	private Long invitationId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "bbsId",value = "")
	private Long bbsId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userId",value = "")
	private Long userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "invitationTitle",value = "")
	private String invitationTitle;
	/**
	 * 
	 */
	@ApiModelProperty(name = "invitationContent",value = "")
	private String invitationContent;
	/**
	 * 
	 */
	@ApiModelProperty(name = "createTime",value = "")
	private Date createTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "updateTime",value = "")
	private Date updateTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;

}
