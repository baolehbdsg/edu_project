/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.user.feign;



import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserApi {
    @GetMapping("/user/student/userlist")
    public PageVo userlist(@RequestParam("params") QueryCondition params,@RequestParam("userIds") String []userIds);
}
