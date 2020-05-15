package com.hebin.resourse.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.resourse.dao.JudgeDao;
import com.hebin.resourse.entity.JudgeEntity;
import com.hebin.resourse.service.JudgeService;


@Service("judgeService")
public class JudgeServiceImpl extends ServiceImpl<JudgeDao, JudgeEntity> implements JudgeService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<JudgeEntity> page = this.page(
                new Query<JudgeEntity>().getPage(params),
                new QueryWrapper<JudgeEntity>()
        );

        return new PageVo(page);
    }

}