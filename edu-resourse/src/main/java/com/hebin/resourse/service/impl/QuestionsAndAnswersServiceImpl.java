/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.service.impl;

import com.hebin.resourse.dao.QuestionsAndAnswersDao;
import com.hebin.resourse.entity.QuestionsAndAnswersEntity;
import com.hebin.resourse.service.QuestionsAndAnswersService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


@Service("questionsAndAnswersService")
public class QuestionsAndAnswersServiceImpl extends ServiceImpl<QuestionsAndAnswersDao, QuestionsAndAnswersEntity> implements QuestionsAndAnswersService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<QuestionsAndAnswersEntity> page = this.page(
                new Query<QuestionsAndAnswersEntity>().getPage(params),
                new QueryWrapper<QuestionsAndAnswersEntity>()
        );

        return new PageVo(page);
    }

}