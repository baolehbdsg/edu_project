package com.hebin.testservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.testservice.dao.TestQaDao;
import com.hebin.testservice.entity.TestQaEntity;
import com.hebin.testservice.service.TestQaService;
import org.springframework.stereotype.Service;


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