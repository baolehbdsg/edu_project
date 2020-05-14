package com.hebin.edu.bbs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.bbs.entity.BbsEntity;
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

