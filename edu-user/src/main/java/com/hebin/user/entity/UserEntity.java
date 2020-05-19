/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-19
 * 一个公共类，方便接收参数
 */
@Data
public class UserEntity  {
    private String userId;

    private String userName;

    private Integer userGender;

    private String userTel;

    private String userWechatId;

    private String userNickname;

    private String userMail;

    private String userPassword;

    private String userAvatar;

    private Integer isBindwechat;

    private Date registerTime;

    private Integer isDelete;

    private Integer isBanned;

}
