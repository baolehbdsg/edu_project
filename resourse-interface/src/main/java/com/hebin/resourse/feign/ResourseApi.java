/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.resourse.feign;

import com.hebin.core.bean.Resp;
import com.hebin.resourse.entity.HomeworkEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ResourseApi {
    @ApiOperation("发布作业")
    @PostMapping("resourse/homework/publish/homework")
    public Resp<String> publishHomework(@RequestBody HomeworkEntity homework);

    @ApiOperation("作业详情查询")
    @GetMapping("resourse/homework/gethomeworkdetail/{homeworkId}")
    public Resp<HomeworkEntity> getHomeworkDetail(@PathVariable("homeworkId") String homeworkId);
}
