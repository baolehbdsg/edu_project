package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.TestChoiceDao;
import com.hebin.edu.resourse.entity.TestChoiceEntity;
import com.hebin.edu.resourse.service.TestChoiceService;


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