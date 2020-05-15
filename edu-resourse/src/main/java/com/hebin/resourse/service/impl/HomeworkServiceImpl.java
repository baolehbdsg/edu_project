/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.HomeworkDao;
import com.hebin.resourse.entity.HomeworkEntity;
import com.hebin.resourse.service.HomeworkService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("homeworkService")
public class HomeworkServiceImpl extends ServiceImpl<HomeworkDao, HomeworkEntity> implements HomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<HomeworkEntity> page = this.page(
                new Query<HomeworkEntity>().getPage(params),
                new QueryWrapper<HomeworkEntity>()
        );

        return new PageVo(page);
    }

}