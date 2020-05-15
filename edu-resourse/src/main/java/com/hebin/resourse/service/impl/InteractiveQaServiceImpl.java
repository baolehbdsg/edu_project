/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.InteractiveQaDao;
import com.hebin.resourse.entity.InteractiveQaEntity;
import com.hebin.resourse.service.InteractiveQaService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


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