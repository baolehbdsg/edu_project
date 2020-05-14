package com.hebin.edu.bbs.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.bbs.dao.BbsDao;
import com.hebin.edu.bbs.entity.BbsEntity;
import com.hebin.edu.bbs.service.BbsService;


@Service("bbsService")
public class BbsServiceImpl extends ServiceImpl<BbsDao, BbsEntity> implements BbsService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<BbsEntity> page = this.page(
                new Query<BbsEntity>().getPage(params),
                new QueryWrapper<BbsEntity>()
        );

        return new PageVo(page);
    }

}