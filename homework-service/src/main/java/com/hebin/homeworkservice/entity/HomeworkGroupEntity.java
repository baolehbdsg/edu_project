/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
@TableName("edu_homework_group")
public class HomeworkGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;
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


}
