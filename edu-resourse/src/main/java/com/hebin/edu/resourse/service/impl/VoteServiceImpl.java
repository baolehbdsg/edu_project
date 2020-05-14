package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.VoteDao;
import com.hebin.edu.resourse.entity.VoteEntity;
import com.hebin.edu.resourse.service.VoteService;


@Service("voteService")
public class VoteServiceImpl extends ServiceImpl<VoteDao, VoteEntity> implements VoteService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<VoteEntity> page = this.page(
                new Query<VoteEntity>().getPage(params),
                new QueryWrapper<VoteEntity>()
        );

        return new PageVo(page);
    }

}