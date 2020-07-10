/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class StuCommitInteractiveVO {
    /**
     *
     */
    @ApiModelProperty(name = "题目的Id",value = "")
    private String subjectId;
    /**
     *
     */
    @ApiModelProperty(name = "testId",value = "")
    private String interactiveId;
    /**
     * 题号靠前端来控制
     */
    @ApiModelProperty(name = "number",value = "题号靠前端来控制")
    private Integer number;
    /**
     *
     */
    @ApiModelProperty(name = "stuTestQaAnswer",value = "")
    private String answer;


    //前端要给的，不给的话就代表是问答题
    @ApiModelProperty(name="choiceType")
    private Integer choiceType;
}
