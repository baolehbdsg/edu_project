package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.SingleChoiceDao;
import com.hebin.edu.resourse.entity.SingleChoiceEntity;
import com.hebin.edu.resourse.service.SingleChoiceService;


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