/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 * <p>
 * https://www.guli.cloud
 * <p>
 * 版权所有，侵权必究！
 */

package com.hebin.modules.sys.dao;

import com.hebin.modules.sys.entity.SysRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
