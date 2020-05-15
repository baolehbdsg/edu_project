/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.ResourceDao;
import com.hebin.resourse.entity.ResourceEntity;
import com.hebin.resourse.service.ResourceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceEntity> implements ResourceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ResourceEntity> page = this.page(
                new Query<ResourceEntity>().getPage(params),
                new QueryWrapper<ResourceEntity>()
        );

        return new PageVo(page);
    }

}