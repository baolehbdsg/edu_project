/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("edu_bbs_reply")
public class BbsReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "replyId",value = "")
	private String replyId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "invitationId",value = "")
	private String invitationId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userId",value = "")
	private String userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eduUserId",value = "")
	private String eduUserId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "replyType",value = "")
	private Integer replyType;
	/**
	 * 
	 */
	@ApiModelProperty(name = "replyContent",value = "")
	private String replyContent;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(name = "replyTime",value = "")
	private Date replyTime;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(name = "updateTime",value = "")
	private Date updateTime;
	/**
	 * Ŀ
	 */
	@ApiModelProperty(name = "parentId",value = "")
	private String parentId;
	/**
	 * 
	 */
	@TableLogic
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isRead",value = "")
	private Integer isRead;

}
