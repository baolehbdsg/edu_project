package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 考勤详情
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@ApiModel
@Data
@TableName("edu_attendance_detail")
public class AttendanceDetailEntity implements Serializable {
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
	@ApiModelProperty(name = "attendanceid",value = "")
	private String attendanceid;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(name = "recordTime",value = "")
	private Date recordTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isRecord",value = "")
	private Integer isRecord;

}
