/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.service.impl;

import com.hebin.bbs.dao.BbsReplyDao;
import com.hebin.bbs.entity.BbsReplyEntity;
import com.hebin.bbs.service.BbsReplyService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;


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

    @Override
    public void removeReply(String[] replyIds) {

    }

}