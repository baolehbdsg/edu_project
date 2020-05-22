/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.course.VO;

import com.hebin.resourse.entity.HomeworkEntity;
import lombok.Data;

import java.util.Date;

@Data
public class HomeworkVO extends HomeworkEntity {
    //课程id
    private String courseId;
    //教师id
    private String teacherId;
    //截止日期
    private Date deadline;
    //超时后是否还能提交
    private Integer canDelay;
}
