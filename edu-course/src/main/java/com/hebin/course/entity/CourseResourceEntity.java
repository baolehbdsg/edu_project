package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程与资源
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_course_resource")
public class CourseResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	@ApiModelProperty(name = "resourceId",value = "")
	private String resourceId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "canDownload",value = "")
	private Integer canDownload;

}
