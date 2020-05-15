/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.service.impl;

import com.hebin.bbs.dao.BbsDao;
import com.hebin.bbs.entity.BbsEntity;
import com.hebin.bbs.service.BbsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("bbsService")
public class BbsServiceImpl extends ServiceImpl<BbsDao, BbsEntity> implements BbsService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<BbsEntity> page = this.page(
                new Query<BbsEntity>().getPage(params),
                new QueryWrapper<BbsEntity>()
        );

        return new PageVo(page);
    }

}