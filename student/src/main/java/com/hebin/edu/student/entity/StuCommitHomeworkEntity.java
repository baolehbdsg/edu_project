package com.hebin.edu.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生与作业
 * 
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
@ApiModel
@Data
@TableName("edu_stu_commit_homework")
public class StuCommitHomeworkEntity implements Serializable {
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
	@ApiModelProperty(name = "userId",value = "")
	private Long userId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "homeworkId",value = "")
	private Long homeworkId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "score",value = "")
	private String score;
	/**
	 * 
	 */
	@ApiModelProperty(name = "commitTimes",value = "")
	private Integer commitTimes;
	/**
	 * 
	 */
	@ApiModelProperty(name = "homeworkFile",value = "")
	private String homeworkFile;
	/**
	 * 
	 */
	@ApiModelProperty(name = "homeworkContent",value = "")
	private String homeworkContent;
	/**
	 * 
	 */
	@ApiModelProperty(name = "commitTime",value = "")
	private Date commitTime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isCommit",value = "")
	private Integer isCommit;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isDelay",value = "")
	private Integer isDelay;

}
