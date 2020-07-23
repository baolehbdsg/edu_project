package com.hebin.homeworkservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.homeworkservice.DTO.HomeworkDetailDTO;
import com.hebin.homeworkservice.VO.HomeworkVO;
import com.hebin.homeworkservice.VO.ImportHomeworkVO;
import com.hebin.homeworkservice.entity.CourseHomeworkEntity;
import com.hebin.homeworkservice.entity.HomeworkGroupEntity;
import com.hebin.homeworkservice.service.CourseHomeworkService;
import com.hebin.homeworkservice.service.HomeworkGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 课程与作业
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "小组作业")
@RestController
@RequestMapping("homework/homeworkgroup")
public class HomeworkGroupController {
    @Autowired
    HomeworkGroupService homeworkGroupService;
    //1.提交小组作业

//    @ApiOperation("提交小组作业")
//    @PostMapping("/commit/grouphomework")
//    public Resp<PageVo> commitGroupHomework(@RequestBody )
//    {
//
//        return null;
//    }

    //远程调用
    @ApiOperation("新增作业与小组关系")
    @PostMapping("/create/grouphomework")
    public Resp<PageVo> createGroupHomework(@RequestParam("homeworkId")String homeworkId,@RequestParam("groupId")String groupId)
    {
        HomeworkGroupEntity homeworkGroupEntity = new HomeworkGroupEntity();
        homeworkGroupEntity.setGroupId(groupId);
        homeworkGroupEntity.setHomeworkId(homeworkId);
        homeworkGroupService.save(homeworkGroupEntity);
        return null;
    }
    //删除作业与小组的关系
    @ApiOperation("新增作业与小组关系")
    @PostMapping("/delete/grouphomework")
    public Resp<PageVo> deleteGroupHomework(@RequestParam("homeworkId")String homeworkId,@RequestParam("groupId")String groupId)
    {
//        HomeworkGroupEntity homeworkGroupEntity = new HomeworkGroupEntity();
//        homeworkGroupEntity.setGroupId(groupId);
//        homeworkGroupEntity.setHomeworkId(homeworkId);
        QueryWrapper<HomeworkGroupEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("homework_id",homeworkId).eq("group_id",groupId));
        homeworkGroupService.remove(queryWrapper);
        return null;
    }
}
