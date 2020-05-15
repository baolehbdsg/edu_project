/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.student.service.impl;

import com.hebin.student.dao.StuCommitHomeworkDao;
import com.hebin.student.entity.StuCommitHomeworkEntity;
import com.hebin.student.service.StuCommitHomeworkService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


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