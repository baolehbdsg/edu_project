package com.hebin.homeworkservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程与作业
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_course_homework")
public class CourseHomeworkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ID_WORKER_STR)
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 
	 */
	@ApiModelProperty(name = "courseId",value = "")
	private String courseId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "homeworkId",value = "")
	private String homeworkId;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(name = "createTime",value = "")
	private Date createTime;
	/**
	 * 截止日期必须指定
	 */
	@ApiModelProperty(name = "deadline",value = "截止日期必须指定")
	private Date deadline;
	/**
	 * 
	 */
	@ApiModelProperty(name = "canDelay",value = "")
	private Integer canDelay;

}
