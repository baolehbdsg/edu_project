/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.DTO;

import com.hebin.interactiveservice.entity.InteractiveEntityEntity;
import com.hebin.lesson.entity.TeacherDir;
import lombok.Data;

import java.util.List;

@Data
public class ListInteractiveDTO {
    List<TeacherDir> teacherDirs;
    List<InteractiveEntityEntity> interactiveEntityEntities;
}
