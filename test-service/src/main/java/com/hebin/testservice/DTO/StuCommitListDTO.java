/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.testservice.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StuCommitListDTO {

    @ApiModelProperty(name = "testId",value = "")
    private String testId;

    @ApiModelProperty(name = "testTitle",value = "")
    private String testTitle;

    @ApiModelProperty(name = "testTitle",value = "")
    private String introduction;
    //学生简略信息
    List<StuInfo> stuInfos = new ArrayList<StuInfo>();

}
