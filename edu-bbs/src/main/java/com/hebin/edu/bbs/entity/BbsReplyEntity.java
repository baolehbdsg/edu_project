package com.hebin.edu.bbs.entity;

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
@TableName("edu_bbs_reply")
public class BbsReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "replyId",value = "")
	private Long replyId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "invitationId",value = "")
	private Long invitationId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userId",value = "")
	private Long userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eduUserId",value = "")
	private Long eduUserId;
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
	@ApiModelProperty(name = "replyTime",value = "")
	private Date replyTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "updateTime",value = "")
	private Date updateTime;
	/**
	 * Ŀ
	 */
	@ApiModelProperty(name = "parentId",value = "Ŀ")
	private Long parentId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isRead",value = "")
	private Integer isRead;

}
