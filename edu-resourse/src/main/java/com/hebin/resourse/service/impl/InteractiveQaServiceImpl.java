package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.resourse.dao.InteractiveQaDao;
import com.hebin.resourse.entity.InteractiveQaEntity;
import com.hebin.resourse.service.InteractiveQaService;


@Service("interactiveQaService")
public class InteractiveQaServiceImpl extends ServiceImpl<InteractiveQaDao, InteractiveQaEntity> implements InteractiveQaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveQaEntity> page = this.page(
                new Query<InteractiveQaEntity>().getPage(params),
                new QueryWrapper<InteractiveQaEntity>()
        );

        return new PageVo(page);
    }

}