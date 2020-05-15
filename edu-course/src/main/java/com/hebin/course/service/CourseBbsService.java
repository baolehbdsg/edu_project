package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.CourseBbsEntity;
import com.hebin.core.bean.*;


/**
 * 课程与论坛
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseBbsService extends IService<CourseBbsEntity> {

    PageVo queryPage(QueryCondition params);
}

