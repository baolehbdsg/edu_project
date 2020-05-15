package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.resourse.dao.MultipleChoiceDao;
import com.hebin.resourse.entity.MultipleChoiceEntity;
import com.hebin.resourse.service.MultipleChoiceService;


@Service("multipleChoiceService")
public class MultipleChoiceServiceImpl extends ServiceImpl<MultipleChoiceDao, MultipleChoiceEntity> implements MultipleChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<MultipleChoiceEntity> page = this.page(
                new Query<MultipleChoiceEntity>().getPage(params),
                new QueryWrapper<MultipleChoiceEntity>()
        );

        return new PageVo(page);
    }

}