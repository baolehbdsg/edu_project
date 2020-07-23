/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TeacherViewInteractiveList {
    @ApiModelProperty(name = "userId",value = "")
    @TableId(value = "user_id",type = IdType.ID_WORKER_STR )
    private String userId;

    @ApiModelProperty(name = "userName",value = "")
    private String userName;

    @ApiModelProperty(name = "answer",value = "")
    private String answer;

    @ApiModelProperty(name = "userAvatar",value = "")
    private String userAvatar;
}
