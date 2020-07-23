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
public class CreateTestVO implements Serializable {
    private String testTitle;
    private String introduction;
    //父文件夹Id如果没有默认为0
    private String fatherId;
}
