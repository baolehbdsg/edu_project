/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.VO;

import lombok.Data;

import java.util.Date;

@Data
public class CreateInteractive {

    private String courseId;
    private Date createTime;
    private Integer publish;
    private Integer type;
    private String interactiveTitle;
    private String interactiveFile;
}
