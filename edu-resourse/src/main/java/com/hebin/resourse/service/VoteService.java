package com.hebin.resourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.resourse.entity.VoteEntity;



/**
 * ͶƱ
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
public interface VoteService extends IService<VoteEntity> {

    PageVo queryPage(QueryCondition params);
}

