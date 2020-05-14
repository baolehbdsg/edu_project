package com.hebin.edu.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.student.entity.StuChoiceInteractiveEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 学生互动选择
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:51:01
 */
public interface StuChoiceInteractiveService extends IService<StuChoiceInteractiveEntity> {

    PageVo queryPage(QueryCondition params);
}

