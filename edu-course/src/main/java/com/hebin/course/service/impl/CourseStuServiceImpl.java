package com.hebin.course.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseStuDao;
import com.hebin.course.entity.CourseStuEntity;
import com.hebin.course.service.CourseStuService;


@Service("courseStuService")
public class CourseStuServiceImpl extends ServiceImpl<CourseStuDao, CourseStuEntity> implements CourseStuService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseStuEntity> page = this.page(
                new Query<CourseStuEntity>().getPage(params),
                new QueryWrapper<CourseStuEntity>()
        );

        return new PageVo(page);
    }

}