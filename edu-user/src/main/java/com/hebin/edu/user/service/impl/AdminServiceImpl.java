package com.hebin.edu.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.user.dao.AdminDao;
import com.hebin.edu.user.entity.AdminEntity;
import com.hebin.edu.user.service.AdminService;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AdminEntity> page = this.page(
                new Query<AdminEntity>().getPage(params),
                new QueryWrapper<AdminEntity>()
        );

        return new PageVo(page);
    }

}