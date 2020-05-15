/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.service.impl;

import com.hebin.user.dao.AdminDao;
import com.hebin.user.entity.AdminEntity;
import com.hebin.user.service.AdminService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AdminEntity> page = this.page(
                new Query<AdminEntity>().getPage(params),
                new QueryWrapper<AdminEntity>()
        );

        return new PageVo(page);
    }

}