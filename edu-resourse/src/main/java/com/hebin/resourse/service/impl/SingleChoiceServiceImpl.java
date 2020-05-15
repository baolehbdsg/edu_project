package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.resourse.dao.SingleChoiceDao;
import com.hebin.resourse.entity.SingleChoiceEntity;
import com.hebin.resourse.service.SingleChoiceService;


@Service("singleChoiceService")
public class SingleChoiceServiceImpl extends ServiceImpl<SingleChoiceDao, SingleChoiceEntity> implements SingleChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SingleChoiceEntity> page = this.page(
                new Query<SingleChoiceEntity>().getPage(params),
                new QueryWrapper<SingleChoiceEntity>()
        );

        return new PageVo(page);
    }

}