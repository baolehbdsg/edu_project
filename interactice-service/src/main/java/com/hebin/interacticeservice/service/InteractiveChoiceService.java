package com.hebin.interacticeservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.interacticeservice.entity.InteractiveChoiceEntity;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
public interface InteractiveChoiceService extends IService<InteractiveChoiceEntity> {

    PageVo queryPage(QueryCondition params);
}

