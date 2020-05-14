package com.hebin.edu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.user.entity.StudentEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * ѧ
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:48:49
 */
public interface StudentService extends IService<StudentEntity> {

    PageVo queryPage(QueryCondition params);
}

