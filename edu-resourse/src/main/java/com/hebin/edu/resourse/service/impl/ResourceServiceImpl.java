package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.ResourceDao;
import com.hebin.edu.resourse.entity.ResourceEntity;
import com.hebin.edu.resourse.service.ResourceService;


@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceEntity> implements ResourceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ResourceEntity> page = this.page(
                new Query<ResourceEntity>().getPage(params),
                new QueryWrapper<ResourceEntity>()
        );

        return new PageVo(page);
    }

}