package com.hebin.interacticeservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("edu_interactive_choice")
public class InteractiveChoiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(name = "id",value = "")
	private Long id;
	/**
	 * 
	 */
	@ApiModelProperty(name = "interactiveId",value = "")
	private String interactiveId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "choiceId",value = "")
	private String choiceId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "number",value = "")
	private Integer number;
	@TableLogic
	@ApiModelProperty(name = "逻辑删除",value = "")
	private Integer isDelete;
}
