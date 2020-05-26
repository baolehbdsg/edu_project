package com.hebin.homeworkservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.homeworkservice.DTO.HomeworkDetailDTO;
import com.hebin.homeworkservice.VO.HomeworkVO;
import com.hebin.homeworkservice.VO.ImportHomeworkVO;
import com.hebin.homeworkservice.dao.CourseHomeworkDao;
import com.hebin.homeworkservice.entity.CourseHomeworkEntity;
import com.hebin.homeworkservice.feign.Lessonfeign;
import com.hebin.homeworkservice.feign.Resoursefeign;
import com.hebin.homeworkservice.service.CourseHomeworkService;
import com.hebin.lesson.entiry.TeacherHomeworkEntity;
import com.hebin.resourse.entity.HomeworkEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String importCourseHomework(ImportHomeworkVO importHomeworkVO) {
        //先生成一个CourseHomework对象，然后遍历保存
        CourseHomeworkEntity courseHomeworkEntity =new CourseHomeworkEntity();
        courseHomeworkEntity.setCourseId(importHomeworkVO.getCourseId());
        courseHomeworkEntity.setDeadline((Date) importHomeworkVO.getDeadline());
        courseHomeworkEntity.setCanDelay(importHomeworkVO.getCanDelay());
        courseHomeworkEntity.setCreateTime(new Date());
        for (String homeworkId:importHomeworkVO.getHomeworkIds()) {
            //每次必须重置id会有插入错误，因为框架自动返回ID
            courseHomeworkEntity.setId("");
            courseHomeworkEntity.setHomeworkId(homeworkId);
            courseHomeworkService.save(courseHomeworkEntity);
        }
        return "ok";
    }

    @Override
    public HomeworkDetailDTO getHomeworkDetail(String homeworkId, String courseId) {
        HomeworkEntity homeworkEntity=resoursefeign.getHomeworkDetail(homeworkId).getData();
        HomeworkDetailDTO homeworkDetailDTO  = new HomeworkDetailDTO();
        BeanUtils.copyProperties(homeworkEntity,homeworkDetailDTO);
        QueryWrapper<CourseHomeworkEntity> qw=new QueryWrapper<CourseHomeworkEntity>();
        qw.and(i -> i.eq("homework_id", homeworkId).eq("course_id", courseId));
        CourseHomeworkEntity courseHomeworkEntity=courseHomeworkService.getOne(qw);
        BeanUtils.copyProperties(courseHomeworkEntity,homeworkDetailDTO);
        return homeworkDetailDTO;
    }

}