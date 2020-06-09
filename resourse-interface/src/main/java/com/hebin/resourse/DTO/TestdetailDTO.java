/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TestdetailDTO {
    String testId;
    String testTitle;
    String introduction;
    List<QADTO> qadtos;
    List<ChoiceDTO> choiceDTOS;
}
