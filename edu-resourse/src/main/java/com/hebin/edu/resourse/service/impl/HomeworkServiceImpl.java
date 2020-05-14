package com.hebin.edu.resourse.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.resourse.dao.HomeworkDao;
import com.hebin.edu.resourse.entity.HomeworkEntity;
import com.hebin.edu.resourse.service.HomeworkService;


@Service("homeworkService")
public class HomeworkServiceImpl extends ServiceImpl<HomeworkDao, HomeworkEntity> implements HomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<HomeworkEntity> page = this.page(
                new Query<HomeworkEntity>().getPage(params),
                new QueryWrapper<HomeworkEntity>()
        );

        return new PageVo(page);
    }

}