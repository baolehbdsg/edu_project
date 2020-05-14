package com.hebin.edu.student.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.student.dao.StuTestQaDao;
import com.hebin.edu.student.entity.StuTestQaEntity;
import com.hebin.edu.student.service.StuTestQaService;


@Service("stuTestQaService")
public class StuTestQaServiceImpl extends ServiceImpl<StuTestQaDao, StuTestQaEntity> implements StuTestQaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuTestQaEntity> page = this.page(
                new Query<StuTestQaEntity>().getPage(params),
                new QueryWrapper<StuTestQaEntity>()
        );

        return new PageVo(page);
    }

}