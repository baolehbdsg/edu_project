package com.hebin.course.service.impl;

import com.hebin.core.utils.DateUtils;
import com.hebin.course.VO.HomeworkVO;
import com.hebin.course.entity.CourseHomeworkEntity;
import com.hebin.course.feign.Lessonfeign;
import com.hebin.course.feign.Resoursefeign;
import com.hebin.lesson.entiry.TeacherHomeworkEntity;
import com.hebin.resourse.entity.HomeworkEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.*;

import com.hebin.course.dao.CourseHomeworkDao;
import com.hebin.course.service.CourseHomeworkService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service("courseHomeworkService")
public class CourseHomeworkServiceImpl extends ServiceImpl<CourseHomeworkDao, CourseHomeworkEntity> implements CourseHomeworkService {
    @Autowired
    Resoursefeign resoursefeign;
    @Autowired
    CourseHomeworkService courseHomeworkService;
    @Autowired
    Lessonfeign lessonfeign;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseHomeworkEntity> page = this.page(
                new Query<CourseHomeworkEntity>().getPage(params),
                new QueryWrapper<CourseHomeworkEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo getCourseHomeworkList(QueryCondition params,String courseId) {
        IPage<CourseHomeworkEntity> page=new Query<CourseHomeworkEntity>().getPage(params);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("course_id",Long.parseLong(courseId));
        baseMapper.selectPage(page,qw);
        return new PageVo(page);
    }

    @Override
    public String createCourseHomework(HomeworkVO homeworkVO) {
        //先保存homework然后获得homework具体id
        //必须校验所有的id值

        HomeworkEntity homework = new HomeworkEntity();
        BeanUtils.copyProperties(homeworkVO,homework);
        String homeworkId = resoursefeign.publishHomework(homework).getData();
        //这两个保存可以用多线程执行的
        //保存到CourseHomework
        CourseHomeworkEntity courseHomeworkEntity = new CourseHomeworkEntity();
        Date date = new Date();
        courseHomeworkEntity.setCreateTime(date);
        BeanUtils.copyProperties(homeworkVO,courseHomeworkEntity);
        courseHomeworkEntity.setHomeworkId(homeworkId);
        courseHomeworkService.save(courseHomeworkEntity);
        //调用备课区服务进行保存
        TeacherHomeworkEntity teacherHomeworkEntity =new TeacherHomeworkEntity();
        teacherHomeworkEntity.setHomeworkId(homeworkId);
        teacherHomeworkEntity.setUserId(homeworkVO.getTeacherId());
        lessonfeign.saveHomework(teacherHomeworkEntity);
        return "success";
    }

}