package com.hebin.edu.resourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.resourse.entity.InteractiveEntityEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
public interface InteractiveEntityService extends IService<InteractiveEntityEntity> {

    PageVo queryPage(QueryCondition params);
}
