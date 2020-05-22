/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.VO;

import com.hebin.resourse.entity.HomeworkEntity;
import lombok.Data;

@Data
public class LessonHomeworkVO extends HomeworkEntity {
    private String userId;
}
