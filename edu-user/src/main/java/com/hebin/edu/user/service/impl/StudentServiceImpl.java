package com.hebin.edu.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.edu.user.dao.StudentDao;
import com.hebin.edu.user.entity.StudentEntity;
import com.hebin.edu.user.service.StudentService;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<StudentEntity>()
        );

        return new PageVo(page);
    }

}