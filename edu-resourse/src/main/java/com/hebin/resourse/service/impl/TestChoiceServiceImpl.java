/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.TestChoiceDao;
import com.hebin.resourse.entity.TestChoiceEntity;
import com.hebin.resourse.service.TestChoiceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("testChoiceService")
public class TestChoiceServiceImpl extends ServiceImpl<TestChoiceDao, TestChoiceEntity> implements TestChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TestChoiceEntity> page = this.page(
                new Query<TestChoiceEntity>().getPage(params),
                new QueryWrapper<TestChoiceEntity>()
        );

        return new PageVo(page);
    }

}