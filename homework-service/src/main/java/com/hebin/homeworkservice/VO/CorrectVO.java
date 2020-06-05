/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.VO;

import lombok.Data;

import java.util.List;
@Data
public class CorrectVO {
    //学生id
    List<String> userIds;
    //作业Id
    String homeworkId;
    //分数
    String score;
}
