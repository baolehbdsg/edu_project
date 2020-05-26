package com.hebin.testservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.testservice.dao.TestEntityDao;
import com.hebin.testservice.entity.TestEntityEntity;
import com.hebin.testservice.service.TestEntityService;
import org.springframework.stereotype.Service;


@Service("testEntityService")
public class TestEntityServiceImpl extends ServiceImpl<TestEntityDao, TestEntityEntity> implements TestEntityService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TestEntityEntity> page = this.page(
                new Query<TestEntityEntity>().getPage(params),
                new QueryWrapper<TestEntityEntity>()
        );

        return new PageVo(page);
    }

}