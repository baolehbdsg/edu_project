/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interactiveservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.interactiveservice.entity.StuChoiceInteractiveEntity;


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

