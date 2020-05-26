package com.hebin.course.service.impl;

import com.hebin.bbs.DTO.CoursebbsDTO;
import com.hebin.course.VO.CourseVO;
import com.hebin.course.entity.CourseTeacherEntity;
import com.hebin.course.feign.Bbsfeign;
import com.hebin.course.service.CourseTeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseDao;
import com.hebin.course.entity.CourseEntity;
import com.hebin.course.service.CourseService;


@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {
    @Autowired
    CourseService courseService;
    @Autowired
    CourseTeacherService courseTeacherService;
    @Autowired
    Bbsfeign bbsfeign;
    @Override
    public PageVo createCourse(CourseVO courseVO) {
        //预处理课程id
        if(courseVO.getCourseId()!="")
        {
            courseVO.setCourseId("");
        }
        //将属性值复制到course中
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(courseVO,courseEntity);
        //保存课程信息
        courseService.save(courseEntity);

        String teacherId= courseVO.getTeacherId();
        CourseTeacherEntity courseTeacherEntity = new CourseTeacherEntity();
        courseTeacherEntity.setCourseId(courseEntity.getCourseId());
        courseTeacherEntity.setUserId(teacherId);
        //保存教师和课程的关系
        courseTeacherService.save(courseTeacherEntity);

        Resp<String> resp = new Resp<>();
        //远程调用创建bbs
        //先封装信息
        //再进行远程调用
        CoursebbsDTO coursebbsDTO = new CoursebbsDTO();
        coursebbsDTO.setCourseId(courseEntity.getCourseId());
        coursebbsDTO.setCourseName(courseEntity.getCourseName());
        resp=bbsfeign.createcoursebbs(coursebbsDTO);
        return null;
    }

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseEntity> page = this.page(
                new Query<CourseEntity>().getPage(params),
                new QueryWrapper<CourseEntity>()
        );

        return new PageVo(page);
    }

}