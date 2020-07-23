/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.VO;

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
    //作业类型
    private Integer type;
    //最大小组人数
    private Integer maxGroupSize;
    //组队限制截止日期
    private Date gruopLimitTime;

}
