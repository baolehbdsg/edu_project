package com.hebin.edu.student.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.student.dao.StuCommitHomeworkDao;
import com.hebin.edu.student.entity.StuCommitHomeworkEntity;
import com.hebin.edu.student.service.StuCommitHomeworkService;


@Service("stuCommitHomeworkService")
public class StuCommitHomeworkServiceImpl extends ServiceImpl<StuCommitHomeworkDao, StuCommitHomeworkEntity> implements StuCommitHomeworkService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StuCommitHomeworkEntity> page = this.page(
                new Query<StuCommitHomeworkEntity>().getPage(params),
                new QueryWrapper<StuCommitHomeworkEntity>()
        );

        return new PageVo(page);
    }

}