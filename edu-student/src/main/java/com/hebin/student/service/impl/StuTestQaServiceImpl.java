/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.service.impl;

import com.hebin.student.dao.StuTestQaDao;
import com.hebin.student.entity.StuTestQaEntity;
import com.hebin.student.service.StuTestQaService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("stuTestQaService")
public class StuTestQaServiceImpl extends ServiceImpl<StuTestQaDao, StuTestQaEntity> implements StuTestQaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuTestQaEntity> page = this.page(
                new Query<StuTestQaEntity>().getPage(params),
                new QueryWrapper<StuTestQaEntity>()
        );

        return new PageVo(page);
    }

}