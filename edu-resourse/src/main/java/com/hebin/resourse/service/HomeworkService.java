package com.hebin.resourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.resourse.entity.HomeworkEntity;


/**
 * 
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
public interface HomeworkService extends IService<HomeworkEntity> {

    PageVo queryPage(QueryCondition params);

    String publishHomework(HomeworkEntity homework);

//    PageVo createHomework(HomeworkVO homeworkVO);
}

