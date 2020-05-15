/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.InteractiveDao;
import com.hebin.resourse.entity.InteractiveEntity;
import com.hebin.resourse.service.InteractiveService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("interactiveService")
public class InteractiveServiceImpl extends ServiceImpl<InteractiveDao, InteractiveEntity> implements InteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveEntity> page = this.page(
                new Query<InteractiveEntity>().getPage(params),
                new QueryWrapper<InteractiveEntity>()
        );

        return new PageVo(page);
    }

}