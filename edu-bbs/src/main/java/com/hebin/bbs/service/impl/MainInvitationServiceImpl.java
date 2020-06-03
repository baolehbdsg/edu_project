/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.service.impl;

import com.hebin.bbs.dao.MainInvitationDao;
import com.hebin.bbs.entity.BbsReplyEntity;
import com.hebin.bbs.entity.MainInvitationEntity;
import com.hebin.bbs.service.BbsReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.bbs.service.MainInvitationService;

import java.util.List;


@Service("mainInvitationService")
public class MainInvitationServiceImpl extends ServiceImpl<MainInvitationDao, MainInvitationEntity> implements MainInvitationService {

    @Autowired
    MainInvitationService mainInvitationService;
    @Autowired
    BbsReplyService bbsReplyService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<MainInvitationEntity> page = this.page(
                new Query<MainInvitationEntity>().getPage(params),
                new QueryWrapper<MainInvitationEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo getInvitationList(QueryCondition queryCondition, String bbsId) {
        IPage<MainInvitationEntity> mainInvitationEntityIPage = new Query<MainInvitationEntity>().getPage(queryCondition);
        QueryWrapper<MainInvitationEntity> qw  = new QueryWrapper<MainInvitationEntity>();
        qw.eq("bbs_id",bbsId);
        mainInvitationService.page(mainInvitationEntityIPage,qw);//如果还要显示作者信息，那么前端自己主动通过userId去查就行了
        return new PageVo(mainInvitationEntityIPage);
    }

    @Override
    public PageVo getReplyDetailList(QueryCondition params,String invitationId) {
        IPage<BbsReplyEntity> page =new Query<BbsReplyEntity>().getPage(params);
        QueryWrapper<BbsReplyEntity> qw = new QueryWrapper<>();
        qw.and(i->i.eq("invitation_id",invitationId).eq("reply_type",0));
        bbsReplyService.page(page,qw);
        return new PageVo(page);
    }

//    @Override
//    public Boolean removeInvitations(String []invitationIds) {
//        //1.先获取底下的回复id
//        //2.删除底下的评论
//        //3.删除自己
//        return null;
//    }

}