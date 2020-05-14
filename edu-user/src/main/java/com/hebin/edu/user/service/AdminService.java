package com.hebin.edu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.user.entity.AdminEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
public interface AdminService extends IService<AdminEntity> {

    PageVo queryPage(QueryCondition params);
}

