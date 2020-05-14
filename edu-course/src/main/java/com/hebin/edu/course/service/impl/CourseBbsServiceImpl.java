package com.hebin.edu.course.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.course.dao.CourseBbsDao;
import com.hebin.edu.course.entity.CourseBbsEntity;
import com.hebin.edu.course.service.CourseBbsService;


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