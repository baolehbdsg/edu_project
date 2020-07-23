/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.DTO;

import com.hebin.interactiveservice.VO.StuCommmitedInteractiveDetailVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StuCommitedInteractiveDTO extends StuCommmitedInteractiveDetailVO {
    @ApiModelProperty(name = "stuTestQaAnswer",value = "")
    private String answer;
}
