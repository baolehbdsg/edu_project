package com.hebin.course.service.impl;

import com.baomidou.mybatisplus.core.toolkit.sql.StringEscape;
import com.hebin.course.feign.UserFeign;
import com.hebin.user.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        for(int i=0;i<courseStuEntities.size();i++)
        {
            stuIds[i]=courseStuEntities.get(i).getUserId();
        }
        return userFeign.userlist(params,stuIds);
    }

    @Override
    public PageVo getListStuCourse(QueryCondition params, String userId) {

        IPage<CourseStuEntity> page =new Query<CourseStuEntity>().getPage(params);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",userId);
        baseMapper.selectPage(page,qw);
        //通过userrId查学生基本信息，返回并封装
        //封装group_num,group_name，查course_stu
        //远程调用用户接口
//        List<>;
        return new PageVo(page);
    }

}