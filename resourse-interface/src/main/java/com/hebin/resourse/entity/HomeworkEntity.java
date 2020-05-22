/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@ApiModel
@Data
@TableName("edu_homework")
public class HomeworkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "homeworkId",value = "")
	private String homeworkId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "qaTitle",value = "")
	private String qaTitle;
	/**
	 * 
	 */
	@ApiModelProperty(name = "homeworkContent",value = "")
	private String homeworkContent;
	/**
	 * 
	 */
	@ApiModelProperty(name = "addFile",value = "")
	private String addFile;

}
