package com.hebin.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hebin.bbs.DTO.CoursebbsDTO;
import com.hebin.bbs.entity.BbsEntity;
import com.hebin.bbs.entity.CourseBbsEntity;
import com.hebin.bbs.service.BbsService;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.bbs.dao.CourseBbsDao;
import com.hebin.bbs.service.CourseBbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("courseBbsService")
public class CourseBbsServiceImpl extends ServiceImpl<CourseBbsDao, CourseBbsEntity> implements CourseBbsService {
    @Autowired
    BbsService bbsService;
    @Autowired
    CourseBbsService courseBbsService;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CourseBbsEntity> page = this.page(
                new Query<CourseBbsEntity>().getPage(params),
                new QueryWrapper<CourseBbsEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public void createBBS(CoursebbsDTO coursebbsDTO) {
        BbsEntity bbsEntity = new BbsEntity();
        bbsEntity.setForumName(coursebbsDTO.getCourseName()+"的课程论坛");
        bbsService.save(bbsEntity);
        CourseBbsEntity courseBbsEntity = new CourseBbsEntity();
        courseBbsEntity.setCbBbs(bbsEntity.getBbsId());
        courseBbsEntity.setCbCourse(coursebbsDTO.getCourseId());
        courseBbsService.save(courseBbsEntity);
    }

}