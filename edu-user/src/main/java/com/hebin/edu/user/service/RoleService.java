package com.hebin.edu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.user.entity.RoleEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
public interface RoleService extends IService<RoleEntity> {

    PageVo queryPage(QueryCondition params);
}

