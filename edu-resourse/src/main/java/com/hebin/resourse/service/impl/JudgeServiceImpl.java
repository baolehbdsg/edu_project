/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.JudgeDao;
import com.hebin.resourse.entity.JudgeEntity;
import com.hebin.resourse.service.JudgeService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("judgeService")
public class JudgeServiceImpl extends ServiceImpl<JudgeDao, JudgeEntity> implements JudgeService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<JudgeEntity> page = this.page(
                new Query<JudgeEntity>().getPage(params),
                new QueryWrapper<JudgeEntity>()
        );

        return new PageVo(page);
    }

}