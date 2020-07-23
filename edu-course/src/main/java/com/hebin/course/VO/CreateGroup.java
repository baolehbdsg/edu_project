/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.course.VO;

import lombok.Data;

@Data
public class CreateGroup {

    String courseId;

    String groupName;

    String studentId;

    Integer groupType;
}
