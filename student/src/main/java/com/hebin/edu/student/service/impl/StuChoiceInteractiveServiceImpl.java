package com.hebin.edu.student.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.student.dao.StuChoiceInteractiveDao;
import com.hebin.edu.student.entity.StuChoiceInteractiveEntity;
import com.hebin.edu.student.service.StuChoiceInteractiveService;


@Service("stuChoiceInteractiveService")
public class StuChoiceInteractiveServiceImpl extends ServiceImpl<StuChoiceInteractiveDao, StuChoiceInteractiveEntity> implements StuChoiceInteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuChoiceInteractiveEntity> page = this.page(
                new Query<StuChoiceInteractiveEntity>().getPage(params),
                new QueryWrapper<StuChoiceInteractiveEntity>()
        );

        return new PageVo(page);
    }

}