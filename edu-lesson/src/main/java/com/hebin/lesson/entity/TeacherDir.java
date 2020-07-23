/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

@ApiModel
@Data
@TableName("edu_teacher_dir")
public class TeacherDir implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    String dirId;

    String userId;
    String fatherDirId;
    String dirName;
    //通过type指定是哪个区的文件夹
    //type = 0 互动区
    //type = 1 测试区
    //type = 2 作业区
    //type = 3 资源区
    Integer type;
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
    @TableLogic
    Integer isDelete;

}
