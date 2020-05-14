package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.InteractiveDao;
import com.hebin.edu.resourse.entity.InteractiveEntity;
import com.hebin.edu.resourse.service.InteractiveService;


@Service("interactiveService")
public class InteractiveServiceImpl extends ServiceImpl<InteractiveDao, InteractiveEntity> implements InteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveEntity> page = this.page(
                new Query<InteractiveEntity>().getPage(params),
                new QueryWrapper<InteractiveEntity>()
        );

        return new PageVo(page);
    }

}