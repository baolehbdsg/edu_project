/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.service.impl;

import com.hebin.user.dao.UserRoleDao;
import com.hebin.user.entity.UserRoleEntity;
import com.hebin.user.service.UserRoleService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<UserRoleEntity> page = this.page(
                new Query<UserRoleEntity>().getPage(params),
                new QueryWrapper<UserRoleEntity>()
        );

        return new PageVo(page);
    }

}