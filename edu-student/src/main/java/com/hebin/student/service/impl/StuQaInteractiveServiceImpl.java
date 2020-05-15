/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.service.impl;

import com.hebin.student.dao.StuQaInteractiveDao;
import com.hebin.student.entity.StuQaInteractiveEntity;
import com.hebin.student.service.StuQaInteractiveService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("stuQaInteractiveService")
public class StuQaInteractiveServiceImpl extends ServiceImpl<StuQaInteractiveDao, StuQaInteractiveEntity> implements StuQaInteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuQaInteractiveEntity> page = this.page(
                new Query<StuQaInteractiveEntity>().getPage(params),
                new QueryWrapper<StuQaInteractiveEntity>()
        );

        return new PageVo(page);
    }

}