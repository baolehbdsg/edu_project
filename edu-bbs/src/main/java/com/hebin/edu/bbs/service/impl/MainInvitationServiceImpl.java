package com.hebin.edu.bbs.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.bbs.dao.MainInvitationDao;
import com.hebin.edu.bbs.entity.MainInvitationEntity;
import com.hebin.edu.bbs.service.MainInvitationService;


@Service("mainInvitationService")
public class MainInvitationServiceImpl extends ServiceImpl<MainInvitationDao, MainInvitationEntity> implements MainInvitationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<MainInvitationEntity> page = this.page(
                new Query<MainInvitationEntity>().getPage(params),
                new QueryWrapper<MainInvitationEntity>()
        );

        return new PageVo(page);
    }

}