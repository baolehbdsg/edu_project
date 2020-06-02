package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;

/**
 * 学生参与课程
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_course_stu")
public class CourseStuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value ="id", type = IdType.AUTO)
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
	@ApiModelProperty(name = "userId",value = "")
	private String userId;

	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(name = "加入时间")
	private Date createTime;
}
