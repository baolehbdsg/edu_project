package com.hebin.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.course.entity.CourseResourceEntity;
import com.hebin.core.bean.*;


/**
 * 课程与资源
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
public interface CourseResourceService extends IService<CourseResourceEntity> {

    PageVo queryPage(QueryCondition params);
}

