package com.hebin.edu.lesson.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.edu.lesson.entity.TeacherHomeworkEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
public interface TeacherHomeworkService extends IService<TeacherHomeworkEntity> {

    PageVo queryPage(QueryCondition params);
}

