/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.service.impl;

import com.hebin.student.dao.StuChoiceInteractiveDao;
import com.hebin.student.entity.StuChoiceInteractiveEntity;
import com.hebin.student.service.StuChoiceInteractiveService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


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