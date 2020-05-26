/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ImportHomeworkVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String courseId;

    private Date deadline;

    private Integer canDelay;

    private List<String> homeworkIds;
}
