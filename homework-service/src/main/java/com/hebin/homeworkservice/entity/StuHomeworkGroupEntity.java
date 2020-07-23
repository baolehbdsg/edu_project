/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
@TableName("edu_stu_homework_group")
public class StuHomeworkGroupEntity implements Serializable {
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
    private String groupId;
    /**
     *
     */
    @ApiModelProperty(name = "homeworkId",value = "")
    private String homeworkId;
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
    @TableField(fill = FieldFill.INSERT_UPDATE)
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
