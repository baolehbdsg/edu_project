/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.DTO;


import com.hebin.resourse.entity.HomeworkEntity;
import lombok.Data;

import java.util.Date;

@Data
public class HomeworkDetailDTO extends HomeworkEntity {
   private Date deadline;
   private Date createTime;
   private Integer canDelay;
}
