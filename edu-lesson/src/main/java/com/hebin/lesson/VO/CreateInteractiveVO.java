/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateInteractiveVO implements Serializable {
    //父文件夹Id如果没有默认为0
    String fatherId;
    //互动标题
    String interactiveTitle;
    //互动附件（或者文件）
    String interactiveFile;

}
