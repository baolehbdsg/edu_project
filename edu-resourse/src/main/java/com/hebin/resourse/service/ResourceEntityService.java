package com.hebin.resourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.resourse.entity.ResourceEntityEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:30
 */
public interface ResourceEntityService extends IService<ResourceEntityEntity> {

    PageVo queryPage(QueryCondition params);
}

