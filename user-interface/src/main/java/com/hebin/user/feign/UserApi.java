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
import com.hebin.user.entity.StudentEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserApi {
    @GetMapping("/user/student/userlist")
    public PageVo userlist(@RequestParam("params") QueryCondition params,@RequestParam("userIds") String []userIds);

    @GetMapping("/user/student/userlistbyids")
    public List<StudentEntity> userListByIds(@RequestParam("userIds") String []userIds);
}
