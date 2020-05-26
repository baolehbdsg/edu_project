/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.interacticeservice.dao.StuChoiceInteractiveDao;
import com.hebin.interacticeservice.entity.StuChoiceInteractiveEntity;
import com.hebin.interacticeservice.service.StuChoiceInteractiveService;
import org.springframework.stereotype.Service;


@Service("stuChoiceInteractiveService")
public class StuChoiceInteractiveServiceImpl extends ServiceImpl<StuChoiceInteractiveDao, StuChoiceInteractiveEntity> implements StuChoiceInteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuChoiceInteractiveEntity> page = this.page(
                new Query<StuChoiceInteractiveEntity>().getPage(params),
                new QueryWrapper<StuChoiceInteractiveEntity>()
        );

        return new PageVo(page);
    }

}