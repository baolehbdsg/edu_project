/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.VO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CreateDirVO implements Serializable {
    String fatherDirId;
    String dirName;
    //通过type指定是哪个区的文件夹
    //type = 0 互动区
    //type = 1 测试区
    //type = 2 作业区
    //type = 3 资源区
    Integer type;
}
