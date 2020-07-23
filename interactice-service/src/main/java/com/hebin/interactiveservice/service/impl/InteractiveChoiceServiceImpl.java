package com.hebin.interactiveservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.interactiveservice.dao.InteractiveChoiceDao;
import com.hebin.interactiveservice.entity.InteractiveChoiceEntity;
import com.hebin.interactiveservice.service.InteractiveChoiceService;
import org.springframework.stereotype.Service;


@Service("interactiveChoiceService")
public class InteractiveChoiceServiceImpl extends ServiceImpl<InteractiveChoiceDao, InteractiveChoiceEntity> implements InteractiveChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveChoiceEntity> page = this.page(
                new Query<InteractiveChoiceEntity>().getPage(params),
                new QueryWrapper<InteractiveChoiceEntity>()
        );

        return new PageVo(page);
    }

}