package com.hebin.resourse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ͶƱ
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@ApiModel
@Data
@TableName("edu_vote")
public class VoteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "choiceId",value = "")
	private Long choiceId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "qaTitle",value = "")
	private String qaTitle;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optiona",value = "")
	private String optiona;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optionb",value = "")
	private String optionb;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optionc",value = "")
	private String optionc;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optiond",value = "")
	private String optiond;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optione",value = "")
	private String optione;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optionf",value = "")
	private String optionf;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optiong",value = "")
	private String optiong;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optionh",value = "")
	private String optionh;
	/**
	 * 
	 */
	@ApiModelProperty(name = "optioni",value = "")
	private String optioni;
	/**
	 * 
	 */
	@ApiModelProperty(name = "choiceRightAnswer",value = "")
	private String choiceRightAnswer;
	/**
	 * 
	 */
	@ApiModelProperty(name = "answerExplain",value = "")
	private String answerExplain;
	/**
	 * 
	 */
	@ApiModelProperty(name = "choiceType",value = "")
	private Integer choiceType;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;

}
