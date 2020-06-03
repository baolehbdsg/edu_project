/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.service;

import com.hebin.bbs.entity.MainInvitationEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;

import java.util.List;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 */
public interface MainInvitationService extends IService<MainInvitationEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo getInvitationList(QueryCondition queryCondition, String bbsId);

    PageVo getReplyDetailList(QueryCondition params,String invitationId);

//    Boolean removeInvitations(String []invitationIds);
}

