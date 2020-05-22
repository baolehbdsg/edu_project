package com.hebin.resourse.service.impl;

//import com.hebin.course.entity.CourseHomeworkEntity;
import com.hebin.resourse.entity.HomeworkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;

import com.hebin.resourse.dao.HomeworkDao;
import com.hebin.resourse.service.HomeworkService;


@Service("homeworkService")
public class HomeworkServiceImpl extends ServiceImpl<HomeworkDao, HomeworkEntity> implements HomeworkService {
    @Autowired
    HomeworkService homeworkService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<HomeworkEntity> page = this.page(
                new Query<HomeworkEntity>().getPage(params),
                new QueryWrapper<HomeworkEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public String publishHomework(HomeworkEntity homework) {
        //数据校验
        if(homework.getHomeworkId()!="")
        {
            homework.setHomeworkId("");
        }
        //提交
        homeworkService.save(homework);
        return homework.getHomeworkId();
    }

//    @Override
//    public PageVo createHomework(HomeworkVO homeworkVO) {
////        //预处理homeWorkId
////        //上传请求，直接请求存储文件的位置，然后存储文件发送地址给我们
////        //这里暂时不做
////        if(homeworkVO.getHomeworkId()!="")
////        {
////            homeworkVO.setHomeworkId("");
////        }
////        //保存homework信息
////        HomeworkEntity homeworkEntity= new HomeworkEntity();
////        //这里file地址应当从远程文件数据库获取
////        //
////        BeanUtils.copyProperties(homeworkVO,homeworkEntity);
////        //保存作业信息
////        homeworkService.save(homeworkEntity);
////        //远程调用，保存课程服务中的记录
////        /*
////        * 参数为
////        *   homeworkId
////        *   courseId
////        *   deadline
////        */
////        CourseHomeworkEntity courseHomeworkEntity = new CourseHomeworkEntity();
////        BeanUtils.copyProperties(homeworkVO,courseHomeworkEntity);
////        courseFeign.createhomework(courseHomeworkEntity);
////        /*
////        * 远程调用，自动保存到教师的资源区
////        * 传递参数
////        *   homeworkId
////        *   teacherId
////        * */
//
//
//        return null;
//    }

}