/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.VO;

import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import lombok.Data;

@Data
public class CreateQaVO extends QuestionsAndAnswersEntity {
    String testId;
    Integer number;
    String score;
}
