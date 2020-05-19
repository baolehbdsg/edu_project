package com.hebin.resourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.resourse.entity.InteractiveEntityEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
public interface InteractiveEntityService extends IService<InteractiveEntityEntity> {

    PageVo queryPage(QueryCondition params);
}
