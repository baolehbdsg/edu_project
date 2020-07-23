package com.hebin.course.controller;

import java.util.*;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.bbs.DTO.CoursebbsDTO;
import com.hebin.core.bean.*;

import com.hebin.course.VO.CourseStuVO;
import com.hebin.course.VO.CreateGroup;
import com.hebin.course.VO.DeleteCourseStuVO;
import com.hebin.course.entity.GroupEntity;
import com.hebin.course.feign.HomeworkFeign;
import com.hebin.course.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.course.entity.CourseStuEntity;
import com.hebin.course.service.CourseStuService;




/**
 * 课程与学生
 *
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程与学生")
@RestController
@RequestMapping("course/coursestu")
public class CourseStuController {
    @Autowired
    private CourseStuService courseStuService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private HomeworkFeign homeworkFeign;
    /**
     * 学生查看已选课程信息
     */
    @ApiOperation("学生查看已选课程列表")
    @GetMapping("/liststucourseinfo/{userId}")
    @PreAuthorize("hasAuthority('course:coursestu:info')")
    public Resp<Object> info(QueryCondition queryCondition,@PathVariable("userId") String userId){

        PageVo pageVo = courseStuService.getListStuCourse(queryCondition,userId);
        return Resp.ok(pageVo);
    }

    /**
     * 学生选课
     */
    @ApiOperation("学生选课")
    @PostMapping("/elective")
    @PreAuthorize("hasAuthority('course:coursestu:save')")
    public Resp<Object> elective(@RequestBody CourseStuVO courseStuVO){
        CourseStuEntity courseStuEntity = new CourseStuEntity();
        courseStuEntity.setCourseId(courseStuVO.getCourseId());
        courseStuEntity.setUserId(courseStuVO.getStuId());
		courseStuService.save(courseStuEntity);
        return Resp.ok("选课成功");
    }
    //固定分组
    //如果是自由分组，学生自由组队
    //学生组队
    //是不是固定分组由前端决定
    //比如在某个作业下，学生进行创建分组，那么其分组类型为2
    @ApiOperation("学生创建分组")
    @PostMapping("/creategroup")
    @PreAuthorize("hasAuthority('course:coursestu:save')")
    public Resp<Object> createGroup(@RequestBody CreateGroup createGroup)
    {
        GroupEntity groupEntity = new GroupEntity();
        BeanUtils.copyProperties(createGroup,groupEntity);
        groupEntity.setIs_captain(1);
        groupEntity.setEntryTime(new Date());
        groupService.save(groupEntity);
        //远程调用
        return Resp.ok("创建成功");
    }

    //学生加入分组
    @ApiOperation("学生加入分组")
    @PostMapping("/entrygroup")
    public Resp<Object> entryGroup(@RequestBody GroupEntity groupEntity,@RequestParam("homeworkId")String homeworkId)
    {

        groupEntity.setIs_captain(0);
        groupEntity.setEntryTime(new Date());
        groupService.save(groupEntity);
        homeworkFeign.createGroupHomework(homeworkId,groupEntity.getGroupId());
        return Resp.ok("创建成功");

    }
    //退出分组
    @ApiOperation("学生退出分组")
    @PostMapping("/exitgroup")
    public Resp<Object> exitGroup(@RequestParam("groupId") String groupId,
                                  @RequestParam("courseId") String courseId,
                                  @RequestParam("homeworkId")String homeworkId)
    {
        String studentId = "234";
        QueryWrapper<GroupEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("group_id",groupId).
                eq("course_id",courseId).
                eq("student_id",studentId).
                eq("is_captain",0));
        if(groupService.getOne(queryWrapper)!=null)
        {
            groupService.remove(queryWrapper);
        }
        else {
            QueryWrapper<GroupEntity> queryWrapperlist = new QueryWrapper<>();
            queryWrapperlist.and(i->i.eq("group_id",groupId).eq("course_id",courseId).eq("is_captain",0));
            List<GroupEntity> groupEntityList = groupService.list(queryWrapperlist);
            if(groupEntityList.isEmpty()) {
                groupService.remove(queryWrapper);
                homeworkFeign.deleteGroupHomework(homeworkId,groupId);
            }
            else
            {
                groupEntityList.sort(new Comparator<GroupEntity>() {
                    @Override
                    public int compare(GroupEntity o1, GroupEntity o2) {
                        if(o1.getEntryTime().compareTo(o2.getEntryTime())==-1) return 0;
                        else return 1;
                    }
                });
                groupEntityList.get(0).setIs_captain(1);
                QueryWrapper<GroupEntity> updateQw = new QueryWrapper<>();
                updateQw.and(i->i.eq("group_id",groupEntityList.get(0).getGroupId()).eq("student_id",groupEntityList.get(0).getStudentId()));
                groupService.update(groupEntityList.get(0),updateQw);
            }
        }
        //传入学生id和小组id
        //先查出他是不是小组组长，如果不是直接退出，如果是，则查出其他成员，如果其他成员不存在，则直接退出,并销毁，否则比较他们加入的时间、
        //退出小组后则销毁远端homework与小组的关系
        //加入时间最早的成为组长，或者看是否组长退出时移交自己的组长给指定人选
        return Resp.ok("退出成功");
    }
    //解散分组

    //更换组长：权限：组长
    @ApiOperation("更换组长")
    @PostMapping("/changecaptain")
    public Resp<Object> changeCaptain(@RequestParam("groupId") String groupId,
                                      @RequestParam("tagetId") String targetId)
    {
        String userId = "123";
        QueryWrapper<GroupEntity> sourceCaptain = new QueryWrapper<>();
        sourceCaptain.and(i->i.eq("group_id",groupId).eq("studentId",userId));
        QueryWrapper<GroupEntity> tagetCaptain = new QueryWrapper<>();
        tagetCaptain.and(i->i.eq("group_id",groupId).eq("studentId",targetId));
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setIs_captain(0);
        groupService.update(groupEntity,sourceCaptain);
        groupEntity.setIs_captain(1);
        groupService.update(groupEntity,tagetCaptain);
        return Resp.ok("修改成功");
    }
//    /**
//     * 修改学生信息--
//     */
//    @ApiOperation("修改学生信息")
//    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('course:coursestu:update')")
//    public Resp<Object> update(@RequestBody CourseStuEntity courseStu){
//		courseStuService.updateById(courseStu);
//
//        return Resp.ok(null);
//    }
    /**
     * 删除学生
     */
    @ApiOperation("删除当前已选课学生")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:coursestu:delete')")
    public Resp<Object> delete(@RequestBody DeleteCourseStuVO deleteCourseStuVO){
        if(courseStuService.deleteCourseStu(deleteCourseStuVO)) return Resp.ok("删除成功");
        else return Resp.fail("删除失败");


    }
    /**
     * 查询选课学生情况
     */
    @ApiOperation("查询选课学生列表")
    @GetMapping("/electivestudent/{courseId}")
    @PreAuthorize("hasAuthority('course:course:delete')")
    public Resp<Object> electiveStudent(QueryCondition queryCondition,@PathVariable("courseId") String courseId){
        //应该是返回查出来的学生的基本信息加上小组名称，小组序号
        PageVo pageVo=courseStuService.getListCourseStu(queryCondition,courseId);
        return Resp.ok(pageVo);
    }

}
