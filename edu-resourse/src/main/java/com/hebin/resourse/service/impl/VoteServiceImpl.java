/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.VoteDao;
import com.hebin.resourse.entity.VoteEntity;
import com.hebin.resourse.service.VoteService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("voteService")
public class VoteServiceImpl extends ServiceImpl<VoteDao, VoteEntity> implements VoteService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<VoteEntity> page = this.page(
                new Query<VoteEntity>().getPage(params),
                new QueryWrapper<VoteEntity>()
        );

        return new PageVo(page);
    }

}