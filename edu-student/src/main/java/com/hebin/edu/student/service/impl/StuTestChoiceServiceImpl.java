package com.hebin.edu.student.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.student.dao.StuTestChoiceDao;
import com.hebin.edu.student.entity.StuTestChoiceEntity;
import com.hebin.edu.student.service.StuTestChoiceService;


@Service("stuTestChoiceService")
public class StuTestChoiceServiceImpl extends ServiceImpl<StuTestChoiceDao, StuTestChoiceEntity> implements StuTestChoiceService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuTestChoiceEntity> page = this.page(
                new Query<StuTestChoiceEntity>().getPage(params),
                new QueryWrapper<StuTestChoiceEntity>()
        );

        return new PageVo(page);
    }

}