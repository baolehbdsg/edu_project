/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.feign;

import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Resp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HomeworkApi {
    //远程调用
    @ApiOperation("新增作业与小组关系")
    @PostMapping("homework/homeworkgroup/create/grouphomework")
    public Resp<PageVo> createGroupHomework(@RequestParam("homeworkId")String homeworkId, @RequestParam("groupId")String groupId);
    //删除作业与小组的关系
    @ApiOperation("新增作业与小组关系")
    @PostMapping("/delete/grouphomework")
    public Resp<PageVo> deleteGroupHomework(@RequestParam("homeworkId")String homeworkId,@RequestParam("groupId")String groupId);
}
