package com.hebin.edu.student.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.student.dao.StuQaInteractiveDao;
import com.hebin.edu.student.entity.StuQaInteractiveEntity;
import com.hebin.edu.student.service.StuQaInteractiveService;


@Service("stuQaInteractiveService")
public class StuQaInteractiveServiceImpl extends ServiceImpl<StuQaInteractiveDao, StuQaInteractiveEntity> implements StuQaInteractiveService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuQaInteractiveEntity> page = this.page(
                new Query<StuQaInteractiveEntity>().getPage(params),
                new QueryWrapper<StuQaInteractiveEntity>()
        );

        return new PageVo(page);
    }

}