package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.CourseInteractiveRelationEntity;
import com.hebin.core.bean.*;


/**
 * 课程与互动关系
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseInteractiveRelationService extends IService<CourseInteractiveRelationEntity> {

    PageVo queryPage(QueryCondition params);
}

