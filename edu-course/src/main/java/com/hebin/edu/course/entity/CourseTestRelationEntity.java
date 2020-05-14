package com.hebin.edu.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 加入到课程区的，或课程区测试
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:55:25
 */
@ApiModel
@Data
@TableName("edu_course_test_relation")
public class CourseTestRelationEntity implements Serializable {
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
	private Long courseId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "testId",value = "")
	private Long testId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "createTime",value = "")
	private Date createTime;
	/**
	 * 截止日期必须指定
	 */
	@ApiModelProperty(name = "deadline",value = "截止日期必须指定")
	private Date deadline;

}
