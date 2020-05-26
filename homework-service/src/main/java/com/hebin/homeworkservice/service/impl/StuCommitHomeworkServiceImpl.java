/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.homeworkservice.dao.StuCommitHomeworkDao;
import com.hebin.homeworkservice.entity.StuCommitHomeworkEntity;
import com.hebin.homeworkservice.service.StuCommitHomeworkService;
import org.springframework.stereotype.Service;


@Service("stuCommitHomeworkService")
public class StuCommitHomeworkServiceImpl extends ServiceImpl<StuCommitHomeworkDao, StuCommitHomeworkEntity> implements StuCommitHomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuCommitHomeworkEntity> page = this.page(
                new Query<StuCommitHomeworkEntity>().getPage(params),
                new QueryWrapper<StuCommitHomeworkEntity>()
        );

        return new PageVo(page);
    }

}