package com.hebin.edu.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.student.entity.StuTestChoiceEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 选择题作答情况
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
public interface StuTestChoiceService extends IService<StuTestChoiceEntity> {

    PageVo queryPage(QueryCondition params);
}

