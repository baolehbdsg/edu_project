/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.entity;

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
 * @date 2020-05-13 19:53:54
 */
@ApiModel
@Data
@TableName("edu_teacher_interactive")
public class TeacherInteractiveEntity implements Serializable {
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
	@ApiModelProperty(name = "userId",value = "")
	private String userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "interactiveId",value = "")
	private String interactiveId;

	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	private String fatherId;

	@TableLogic
	private Integer isDelete;

}
