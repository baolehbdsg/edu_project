/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.MultipleChoiceDao;
import com.hebin.resourse.entity.MultipleChoiceEntity;
import com.hebin.resourse.service.MultipleChoiceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("multipleChoiceService")
public class MultipleChoiceServiceImpl extends ServiceImpl<MultipleChoiceDao, MultipleChoiceEntity> implements MultipleChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<MultipleChoiceEntity> page = this.page(
                new Query<MultipleChoiceEntity>().getPage(params),
                new QueryWrapper<MultipleChoiceEntity>()
        );

        return new PageVo(page);
    }

}