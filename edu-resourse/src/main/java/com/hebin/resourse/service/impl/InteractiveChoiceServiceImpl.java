package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.resourse.dao.InteractiveChoiceDao;
import com.hebin.resourse.entity.InteractiveChoiceEntity;
import com.hebin.resourse.service.InteractiveChoiceService;


@Service("interactiveChoiceService")
public class InteractiveChoiceServiceImpl extends ServiceImpl<InteractiveChoiceDao, InteractiveChoiceEntity> implements InteractiveChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<InteractiveChoiceEntity> page = this.page(
                new Query<InteractiveChoiceEntity>().getPage(params),
                new QueryWrapper<InteractiveChoiceEntity>()
        );

        return new PageVo(page);
    }

}