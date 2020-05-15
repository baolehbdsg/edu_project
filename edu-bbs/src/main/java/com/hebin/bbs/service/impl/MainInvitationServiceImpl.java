/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.service.impl;

import com.hebin.bbs.dao.MainInvitationDao;
import com.hebin.bbs.entity.MainInvitationEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.bbs.service.MainInvitationService;


@Service("mainInvitationService")
public class MainInvitationServiceImpl extends ServiceImpl<MainInvitationDao, MainInvitationEntity> implements MainInvitationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<MainInvitationEntity> page = this.page(
                new Query<MainInvitationEntity>().getPage(params),
                new QueryWrapper<MainInvitationEntity>()
        );

        return new PageVo(page);
    }

}