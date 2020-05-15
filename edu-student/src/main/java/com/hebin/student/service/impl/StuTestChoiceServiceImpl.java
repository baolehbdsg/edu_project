/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.service.impl;

import com.hebin.student.dao.StuTestChoiceDao;
import com.hebin.student.entity.StuTestChoiceEntity;
import com.hebin.student.service.StuTestChoiceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("stuTestChoiceService")
public class StuTestChoiceServiceImpl extends ServiceImpl<StuTestChoiceDao, StuTestChoiceEntity> implements StuTestChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuTestChoiceEntity> page = this.page(
                new Query<StuTestChoiceEntity>().getPage(params),
                new QueryWrapper<StuTestChoiceEntity>()
        );

        return new PageVo(page);
    }

}