/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateHomeWorkVO {

    String fatherId;
    @ApiModelProperty(name = "qaTitle",value = "")
    private String qaTitle;
    /**
     *
     */
    @ApiModelProperty(name = "homeworkContent",value = "")
    private String homeworkContent;
    /**
     *
     */
    @ApiModelProperty(name = "addFile",value = "")
    private String addFile;
}
