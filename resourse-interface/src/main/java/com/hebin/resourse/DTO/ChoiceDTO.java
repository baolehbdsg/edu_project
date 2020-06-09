/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.DTO;

import com.hebin.resourse.entity.SingleChoiceEntity;
import lombok.Data;

@Data
public class ChoiceDTO extends SingleChoiceEntity{
    String score;
    Integer number;
    Integer choiceType;
}
