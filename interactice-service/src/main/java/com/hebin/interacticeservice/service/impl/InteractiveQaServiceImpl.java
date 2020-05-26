package com.hebin.interacticeservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.interacticeservice.dao.InteractiveQaDao;
import com.hebin.interacticeservice.entity.InteractiveQaEntity;
import com.hebin.interacticeservice.service.InteractiveQaService;
import org.springframework.stereotype.Service;


@Service("interactiveQaService")
public class InteractiveQaServiceImpl extends ServiceImpl<InteractiveQaDao, InteractiveQaEntity> implements InteractiveQaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveQaEntity> page = this.page(
                new Query<InteractiveQaEntity>().getPage(params),
                new QueryWrapper<InteractiveQaEntity>()
        );

        return new PageVo(page);
    }

}