package com.hebin.course.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseBbsDao;
import com.hebin.course.entity.CourseBbsEntity;
import com.hebin.course.service.CourseBbsService;


@Service("courseBbsService")
public class CourseBbsServiceImpl extends ServiceImpl<CourseBbsDao, CourseBbsEntity> implements CourseBbsService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseBbsEntity> page = this.page(
                new Query<CourseBbsEntity>().getPage(params),
                new QueryWrapper<CourseBbsEntity>()
        );

        return new PageVo(page);
    }

}