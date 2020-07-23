/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StuCommmitedInteractiveDetailVO{
    @ApiModelProperty(name = "interactiveId",value = "")
    private String interactiveId;
    @ApiModelProperty(name = "题目的Id",value = "")
    private String subjectId;
    //前端要给的，不给的话就代表是问答题
    @ApiModelProperty(name="choiceType")
    private Integer choiceType;
}
