package com.hebin.interactiveservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.interactiveservice.dao.InteractiveEntityDao;
import com.hebin.interactiveservice.entity.InteractiveEntityEntity;
import com.hebin.interactiveservice.service.InteractiveEntityService;
import org.springframework.stereotype.Service;


@Service("interactiveEntityService")
public class InteractiveEntityServiceImpl extends ServiceImpl<InteractiveEntityDao, InteractiveEntityEntity> implements InteractiveEntityService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveEntityEntity> page = this.page(
                new Query<InteractiveEntityEntity>().getPage(params),
                new QueryWrapper<InteractiveEntityEntity>()
        );

        return new PageVo(page);
    }

}