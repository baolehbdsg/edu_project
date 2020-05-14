package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.InteractiveEntityDao;
import com.hebin.edu.resourse.entity.InteractiveEntityEntity;
import com.hebin.edu.resourse.service.InteractiveEntityService;


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