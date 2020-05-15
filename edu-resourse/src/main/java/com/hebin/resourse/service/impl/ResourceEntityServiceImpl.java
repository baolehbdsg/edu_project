package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.resourse.dao.ResourceEntityDao;
import com.hebin.resourse.entity.ResourceEntityEntity;
import com.hebin.resourse.service.ResourceEntityService;


@Service("resourceEntityService")
public class ResourceEntityServiceImpl extends ServiceImpl<ResourceEntityDao, ResourceEntityEntity> implements ResourceEntityService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ResourceEntityEntity> page = this.page(
                new Query<ResourceEntityEntity>().getPage(params),
                new QueryWrapper<ResourceEntityEntity>()
        );

        return new PageVo(page);
    }

}