package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.CourseTestRelationEntity;
import com.hebin.core.bean.*;


/**
 * 加入到课程区的，或课程区测试
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseTestRelationService extends IService<CourseTestRelationEntity> {

    PageVo queryPage(QueryCondition params);
}

