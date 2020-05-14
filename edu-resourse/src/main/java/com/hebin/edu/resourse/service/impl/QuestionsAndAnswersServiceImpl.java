package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.QuestionsAndAnswersDao;
import com.hebin.edu.resourse.entity.QuestionsAndAnswersEntity;
import com.hebin.edu.resourse.service.QuestionsAndAnswersService;


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