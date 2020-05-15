package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 考勤
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_attendance")
public class AttendanceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "attendanceid",value = "")
	private Long attendanceid;
	/**
	 * 
	 */
	@ApiModelProperty(name = "courseId",value = "")
	private Long courseId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "creatTime",value = "")
	private Date creatTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "finishTime",value = "")
	private Date finishTime;

}
