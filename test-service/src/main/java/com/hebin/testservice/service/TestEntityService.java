package com.hebin.testservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.testservice.entity.TestEntityEntity;


/**
 * 测试
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
public interface TestEntityService extends IService<TestEntityEntity> {

    PageVo queryPage(QueryCondition params);
}

