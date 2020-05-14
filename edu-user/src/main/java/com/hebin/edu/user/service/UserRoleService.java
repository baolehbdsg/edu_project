package com.hebin.edu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.user.entity.UserRoleEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
public interface UserRoleService extends IService<UserRoleEntity> {

    PageVo queryPage(QueryCondition params);
}

