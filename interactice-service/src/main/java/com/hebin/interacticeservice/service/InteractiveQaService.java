package com.hebin.interacticeservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.interacticeservice.entity.InteractiveQaEntity;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
public interface InteractiveQaService extends IService<InteractiveQaEntity> {

    PageVo queryPage(QueryCondition params);
}

