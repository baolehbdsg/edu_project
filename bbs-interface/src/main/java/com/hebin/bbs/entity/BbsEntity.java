/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 * 拷贝过来的包名务必与原来的包名一致
 */
@ApiModel
@Data
@TableName("edu_bbs")
public class BbsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ID_WORKER_STR)
	@ApiModelProperty(name = "bbsId",value = "")
	private String bbsId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "forumName",value = "")
	private String forumName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "numberOfInvitation",value = "")
	private Integer numberOfInvitation;

}
