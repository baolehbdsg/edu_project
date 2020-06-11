package com.hebin.interacticeservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@ApiModel
@Data
@TableName("edu_interactive_entity")
public class InteractiveEntityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "interactiveId",value = "")
	private String interactiveId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "interactiveTitle",value = "")
	private String interactiveTitle;
	/**
	 * 
	 */
	@ApiModelProperty(name = "interactiveFile",value = "")
	private String interactiveFile;
	/**
	 * 
	 */
	@TableLogic
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;

}
