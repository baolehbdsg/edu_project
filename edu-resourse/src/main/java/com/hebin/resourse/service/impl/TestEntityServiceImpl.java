package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.resourse.dao.TestEntityDao;
import com.hebin.resourse.entity.TestEntityEntity;
import com.hebin.resourse.service.TestEntityService;


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