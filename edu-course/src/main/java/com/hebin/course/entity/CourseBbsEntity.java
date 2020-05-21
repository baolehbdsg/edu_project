package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程与论坛
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_course_bbs")
public class CourseBbsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(name = "cbId",value = "")
	private Long cbId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "cbCourse",value = "")
	private String cbCourse;
	/**
	 * 
	 */
	@ApiModelProperty(name = "cbBbs",value = "")
	private String cbBbs;

}
