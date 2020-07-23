/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
@TableName("edu_group")
public class GroupEntity {
    @TableId(type = IdType.ID_WORKER_STR)
    String groupId;

    String courseId;

    String groupName;

    String studentId;

    Integer is_captain;

    Integer groupType;

    Date entryTime;
}
