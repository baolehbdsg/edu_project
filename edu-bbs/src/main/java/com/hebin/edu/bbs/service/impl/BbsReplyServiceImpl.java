package com.hebin.edu.bbs.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.bbs.dao.BbsReplyDao;
import com.hebin.edu.bbs.entity.BbsReplyEntity;
import com.hebin.edu.bbs.service.BbsReplyService;


@Service("bbsReplyService")
public class BbsReplyServiceImpl extends ServiceImpl<BbsReplyDao, BbsReplyEntity> implements BbsReplyService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<BbsReplyEntity> page = this.page(
                new Query<BbsReplyEntity>().getPage(params),
                new QueryWrapper<BbsReplyEntity>()
        );

        return new PageVo(page);
    }

}