/*
 * Copyright (c) 2020. edu_project. 
 *
 * 作者：何彬. 
 *
 * 版权所有，侵权必究. 
 */

package com.hebin.bbs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.bbs.entity.BbsEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 14:24:50
 */
public interface BbsService extends IService<BbsEntity> {

    PageVo queryPage(QueryCondition params);
}

