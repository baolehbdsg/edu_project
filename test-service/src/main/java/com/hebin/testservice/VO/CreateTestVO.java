/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.VO;

import com.hebin.testservice.entity.TestEntityEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CreateTestVO extends TestEntityEntity {
    String courseId;
    Date createTime;
    Date deadline;
    Integer publish;
    String totalScore;
}
