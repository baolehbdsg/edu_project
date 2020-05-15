/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.course.service.impl;

import com.hebin.course.dao.CourseBbsDao;
import com.hebin.course.entity.CourseBbsEntity;
import com.hebin.course.service.CourseBbsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("courseBbsService")
public class CourseBbsServiceImpl extends ServiceImpl<CourseBbsDao, CourseBbsEntity> implements CourseBbsService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseBbsEntity> page = this.page(
                new Query<CourseBbsEntity>().getPage(params),
                new QueryWrapper<CourseBbsEntity>()
        );

        return new PageVo(page);
    }

}