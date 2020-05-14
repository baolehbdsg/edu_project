package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.JudgeDao;
import com.hebin.edu.resourse.entity.JudgeEntity;
import com.hebin.edu.resourse.service.JudgeService;


@Service("judgeService")
public class JudgeServiceImpl extends ServiceImpl<JudgeDao, JudgeEntity> implements JudgeService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<JudgeEntity> page = this.page(
                new Query<JudgeEntity>().getPage(params),
                new QueryWrapper<JudgeEntity>()
        );

        return new PageVo(page);
    }

}