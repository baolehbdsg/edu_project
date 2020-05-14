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
@TableName("edu_bbs")
public class BbsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "bbsId",value = "")
	private Long bbsId;
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
