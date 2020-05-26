package com.hebin.bbs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.bbs.entity.CourseBbsEntity;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;


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

