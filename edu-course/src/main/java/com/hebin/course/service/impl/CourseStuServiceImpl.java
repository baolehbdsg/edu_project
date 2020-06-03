package com.hebin.course.service.impl;

import com.baomidou.mybatisplus.core.toolkit.sql.StringEscape;
import com.hebin.course.VO.DeleteCourseStuVO;
import com.hebin.course.entity.CourseEntity;
import com.hebin.course.feign.UserFeign;
import com.hebin.course.service.CourseService;
import com.hebin.user.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseStuDao;
import com.hebin.course.entity.CourseStuEntity;
import com.hebin.course.service.CourseStuService;


@Service("courseStuService")
public class CourseStuServiceImpl extends ServiceImpl<CourseStuDao, CourseStuEntity> implements CourseStuService {
    @Autowired
    CourseStuService courseStuService;
    @Autowired
    UserFeign userFeign;
    @Autowired
    CourseService courseService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseStuEntity> page = this.page(
                new Query<CourseStuEntity>().getPage(params),
                new QueryWrapper<CourseStuEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo getListCourseStu(QueryCondition params, String courseId) {

        QueryWrapper<CourseStuEntity> qw = new QueryWrapper();
        qw.eq("course_id",courseId);
        //通过课程id获取学生id，然后通过远程调用，获得学生信息然后回传
        List<CourseStuEntity> courseStuEntities=courseStuService.list(qw);

        String stuIds[] = new String[courseStuEntities.size()];
        //如果该课的学生列表为空，直接返回一个空的page
        if(stuIds.length==0)return new PageVo();
        for(int i=0;i<courseStuEntities.size();i++)
        {
            stuIds[i]=courseStuEntities.get(i).getUserId();
        }

        System.out.println(Arrays.toString(stuIds));
        return userFeign.userlist(params,stuIds);
    }

    @Override
    public PageVo getListStuCourse(QueryCondition params, String userId) {

        IPage<CourseEntity> page =new Query<CourseEntity>().getPage(params);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",userId);
        //先获取courseStu数据
        List<CourseStuEntity> courseStuEntities= courseStuService.list(qw);;
        String courseIds[]= new String[courseStuEntities.size()];
        //如果该学生的课表为空则返回一个空列表
        if(courseIds.length==0)return new PageVo();
        //获取相关的courseId
        for(int i=0;i<courseIds.length;i++)
        {
            courseIds[i]=courseStuEntities.get(i).getCourseId();
        }
        //根据courseIds查询课程信息
        QueryWrapper<CourseEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("course_id",courseIds);
        //返回课程的基本信息
        courseService.page(page,queryWrapper);
        return new PageVo(page);
    }

    @Override
    public Boolean deleteCourseStu(DeleteCourseStuVO deleteCourseStuVO) {
        String [] stuIds = deleteCourseStuVO.getUserId();
        String courseId = deleteCourseStuVO.getCourseId();
        QueryWrapper<CourseStuEntity> queryWrapper =new QueryWrapper<CourseStuEntity>();
        queryWrapper.and(i -> i.eq("course_id", courseId).in("user_id", stuIds));
        return courseStuService.remove(queryWrapper);
    }

}