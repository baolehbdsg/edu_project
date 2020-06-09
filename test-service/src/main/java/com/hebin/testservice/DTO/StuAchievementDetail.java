/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.DTO;

import com.hebin.testservice.entity.StuTestChoiceEntity;
import com.hebin.testservice.entity.StuTestQaEntity;
import lombok.Data;

import java.util.List;

@Data
public class StuAchievementDetail {
    List<StuTestChoiceEntity> stuTestChoiceEntities;
    List<StuTestQaEntity> stuTestQaEntities;
}
