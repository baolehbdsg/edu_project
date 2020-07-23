/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ListDirDTO {
    String dirId;
    String dirName;
    Date createTime;
}
