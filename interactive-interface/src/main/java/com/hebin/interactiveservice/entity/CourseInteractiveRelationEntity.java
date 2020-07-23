package com.hebin.interactiveservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程与互动关系
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_course_interactive_relation")
public class CourseInteractiveRelationEntity implements Serializable {
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
	@ApiModelProperty(name = "courseId",value = "")
	private String courseId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "interactiveId",value = "")
	private String interactiveId;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT )
	@ApiModelProperty(name = "createTime",value = "")
	private Date createTime;

	@TableField(value = "is_publish")
	private Integer publish;

	@TableLogic
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;
}
