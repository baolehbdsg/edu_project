/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.VO;

import com.hebin.user.entity.UserEntity;
import lombok.Data;

@Data
public class UserRegisterVO extends UserEntity {

    Integer userType;

}
