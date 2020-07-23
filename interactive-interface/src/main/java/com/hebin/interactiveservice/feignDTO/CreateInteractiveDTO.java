/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.feignDTO;

import lombok.Data;

@Data
public class CreateInteractiveDTO {
    //互动标题
    String interactiveTitle;
    //互动附件（或者文件）
    String interactiveFile;
}
