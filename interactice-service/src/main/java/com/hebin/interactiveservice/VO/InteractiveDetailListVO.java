/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.VO;

import lombok.Data;

import java.util.List;

@Data
public class InteractiveDetailListVO {
    String interactiveId;
    String interactiveTitle;
    String interactiveFile;
    List<CreateQaVO> createQaVOS;
    List<CreateChoiceVO> createChoiceVOS;
}
