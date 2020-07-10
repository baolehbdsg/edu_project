/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.VO;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class StuCommitVO {
    /**
     *
     */
    @ApiModelProperty(name = "题目的Id",value = "")
    private String subjectId;
    /**
     *
     */
    @ApiModelProperty(name = "testId",value = "")
    private String testId;
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

    @ApiModelProperty(name = "finishTime",value = "")
    private Date finishTime;

//    @ApiModelProperty(name="subjectType")
//    private Integer subject;

    @ApiModelProperty(name="choiceType")
    private Integer choiceType;
}
