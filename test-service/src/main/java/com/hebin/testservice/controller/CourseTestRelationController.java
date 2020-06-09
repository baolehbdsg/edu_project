package com.hebin.testservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.resourse.DTO.ChoiceDTO;
import com.hebin.resourse.DTO.QADTO;
import com.hebin.resourse.DTO.TestdetailDTO;
import com.hebin.testservice.VO.CreateTestVO;
import com.hebin.testservice.entity.CourseTestRelationEntity;
import com.hebin.testservice.entity.TestChoiceEntity;
import com.hebin.testservice.entity.TestEntityEntity;
import com.hebin.testservice.entity.TestQaEntity;
import com.hebin.testservice.feign.ResourseFeign;
import com.hebin.testservice.service.CourseTestRelationService;
import com.hebin.testservice.service.TestChoiceService;
import com.hebin.testservice.service.TestEntityService;
import com.hebin.testservice.service.TestQaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 加入到课程区的，或课程区测试
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "加入到课程区的,或课程区测试")
@RestController
@RequestMapping("test/coursetestrelation")
public class CourseTestRelationController {
    @Autowired
    private CourseTestRelationService courseTestRelationService;
    @Autowired
    private TestEntityService testEntityService;
    @Autowired
    private TestChoiceService testChoiceService;
    @Autowired
    private TestQaService testQaService;
    @Autowired
    ResourseFeign resourseFeign;
    /**
     * 查看课程的测试列表
     * 测试状态:通过
     */
    @ApiOperation("查看课程的测试列表")
    @GetMapping("/list/{courseId}")
    @PreAuthorize("hasAuthority('course:coursetestrelation:list')")
    public Resp<PageVo> list(QueryCondition queryCondition,@PathVariable String courseId) {
        //先通过courseId得到一个testIds
        //再通过testIds查对应的test实体
        //最后封装成list<CourseTestVO>然后返回
        //分页要在一开始就开始分页
        //通过课程Id获取testId的分页信息
        QueryWrapper<CourseTestRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        IPage<CourseTestRelationEntity> courseTestRelationEntityIPage = new Query<CourseTestRelationEntity>().getPage(queryCondition);
        courseTestRelationService.page(courseTestRelationEntityIPage,queryWrapper);
        List<CourseTestRelationEntity> courseTestRelationEntities = courseTestRelationEntityIPage.getRecords();
        //最后传回的结果值
        List<CreateTestVO> createTestVOS = new ArrayList<CreateTestVO>();
        String [] testIds = new String[courseTestRelationEntities.size()];
        int i = 0;
        //先获取这些Id值
        for (CourseTestRelationEntity courseTestRelationEntity:courseTestRelationEntityIPage.getRecords()
             ) {
            testIds[i]= courseTestRelationEntity.getTestId();
            i++;
        }
        //通过这些id值查询作业实体中的值
        QueryWrapper<TestEntityEntity> qw = new QueryWrapper<>();
        qw.in("test_id",testIds);
        //再根据当前的数据量的大小，来对createVO进行赋值
        List<TestEntityEntity> testEntityEntities=testEntityService.list(qw);

        for(int j = 0;j<testEntityEntities.size();j++)
        {
            CreateTestVO createTestVO = new CreateTestVO();
            BeanUtils.copyProperties(testEntityEntities.get(j),createTestVO);
            createTestVOS.add(createTestVO);
            //
            for(int p=0;p<courseTestRelationEntities.size();p++)
            {
                if(courseTestRelationEntities.get(p).getTestId().equals(createTestVOS.get(j).getTestId()))
                {
                    BeanUtils.copyProperties(courseTestRelationEntities.get(p),createTestVOS.get(j));
                }
            }
        }
        PageVo pageVo= new PageVo(courseTestRelationEntityIPage);
        pageVo.setList(createTestVOS);
        return Resp.ok(pageVo);
    }
    /**
     * 查看测试详细信息
     * 需要关联该测试下的所有题号,并且远程调用题目信息
     * 测试状态：未开发完成
     */
    @ApiOperation("查看测试详细信息")
    @GetMapping("/info/{testId}")
    @PreAuthorize("hasAuthority('course:coursetestrelation:info')")
    public Resp<TestdetailDTO> info(QueryCondition queryCondition,@PathVariable("testId") String testId){
        //封装类
        TestdetailDTO testdetailDTO = new TestdetailDTO();
        //查出test实体
        QueryWrapper<TestEntityEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("test_id",testId);
        TestEntityEntity testEntityEntity = new TestEntityEntity();
        testEntityEntity = testEntityService.getOne(queryWrapper);
        //然后给TestdetailDTO实体赋值
        BeanUtils.copyProperties(testEntityEntity,testdetailDTO);
        //查出测试相关的选择题，简答题等条目
        //选择题
        QueryWrapper<TestChoiceEntity> queryWrappertestChoice = new QueryWrapper<>();
        queryWrappertestChoice.eq("test_id",testId);
        List<TestChoiceEntity> testChoiceEntity = testChoiceService.list(queryWrappertestChoice);
        //填空题
        QueryWrapper<TestQaEntity> queryWrappertestQA = new QueryWrapper<>();
        queryWrappertestQA.eq("test_id",testId);
        List<TestQaEntity>testQaEntities=testQaService.list(queryWrappertestQA);
        //先进行属性赋值，再传
        //
        List<ChoiceDTO> choiceDTOS = new ArrayList<>();
        List<QADTO> qadtos = new ArrayList<>();
        for(int i =0;i<testChoiceEntity.size();i++)
        {
            ChoiceDTO choiceDTO=new ChoiceDTO();
            BeanUtils.copyProperties(testChoiceEntity.get(i),choiceDTO);
            choiceDTOS.add(choiceDTO);

        }
        for(int i =0;i<testQaEntities.size();i++)
        {
            QADTO qadto = new QADTO();
            BeanUtils.copyProperties(testQaEntities.get(i),qadto);
            qadtos.add(qadto);
        }
        //再通过这些条目的Id去调用resourse的信息
        List<ChoiceDTO> choices=resourseFeign.choice(choiceDTOS);
        List<QADTO> qa=resourseFeign.qa(qadtos);
        testdetailDTO.setChoiceDTOS(choiceDTOS);
        testdetailDTO.setQadtos(qa);
        //获取resourse的值，进行封装后返回给前端
//		CourseTestRelationEntity courseTestRelation = courseTestRelationService.getById(id);
        return Resp.ok(testdetailDTO);
    }
    /**
     * 新建测试
     * 测试状态：通过
     */
    @ApiOperation("新建测试")
    @PostMapping("/createtest")
    @PreAuthorize("hasAuthority('course:coursetestrelation:save')")
    public Resp<Object> createTest(@RequestBody CreateTestVO createTestVO){
        //先保存测试实体
        //再保存两个之间的关系
        TestEntityEntity testEntityEntity = new TestEntityEntity();
        BeanUtils.copyProperties(createTestVO,testEntityEntity);
        testEntityService.save(testEntityEntity);
        CourseTestRelationEntity courseTestRelationEntity =new CourseTestRelationEntity();
        BeanUtils.copyProperties(createTestVO,courseTestRelationEntity);
        courseTestRelationEntity.setTestId(testEntityEntity.getTestId());
        courseTestRelationService.save(courseTestRelationEntity);
        return Resp.ok("新建成功");
    }
    /**
     * 发布测试
     * 测试状态:通过
     */
    @ApiOperation("发布测试")
    @PostMapping("/publishtest")
    @PreAuthorize("hasAuthority('course:coursetestrelation:update')")
    public Resp<Object> publishTest(String courseId,String testId){

        QueryWrapper<CourseTestRelationEntity> queryWrapper =new QueryWrapper<>();
        queryWrapper.and(i->i.eq("course_id",courseId).eq("test_id",testId));
        CourseTestRelationEntity courseTestRelationEntity = new CourseTestRelationEntity();
        courseTestRelationEntity.setPublish(1);
        if(courseTestRelationService.update(courseTestRelationEntity,queryWrapper))return Resp.ok("发布成功");
        else return Resp.ok("发布失败");
    }
    /**
     * 删除测试
     * 测试状态：未完成
     */
    @ApiOperation("删除测试")
    @PostMapping("/deletetest")
    @PreAuthorize("hasAuthority('course:coursetestrelation:delete')")
    public Resp<Object> deleteTest(@RequestBody String[] ids){
        //删除课程与测试信息
        //删除测试实体(逻辑删除)
        //删除测试与问答，测试与选择，学生与测试
        //最好都是逻辑删除
		courseTestRelationService.removeByIds(Arrays.asList(ids));
        return Resp.ok(null);
    }

}
