/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.TestQaDao;
import com.hebin.resourse.entity.TestQaEntity;
import com.hebin.resourse.service.TestQaService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("testQaService")
public class TestQaServiceImpl extends ServiceImpl<TestQaDao, TestQaEntity> implements TestQaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TestQaEntity> page = this.page(
                new Query<TestQaEntity>().getPage(params),
                new QueryWrapper<TestQaEntity>()
        );

        return new PageVo(page);
    }

}