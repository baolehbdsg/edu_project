/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.service;

import com.hebin.user.entity.RoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
public interface RoleService extends IService<RoleEntity> {

    PageVo queryPage(QueryCondition params);
}

