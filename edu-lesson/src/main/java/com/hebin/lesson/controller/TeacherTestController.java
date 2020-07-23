/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.controller;

import java.util.Date;
import java.util.List;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.lesson.DTO.ListTestDTO;
import com.hebin.lesson.VO.CreateTestVO;
import com.hebin.lesson.entity.TeacherDir;
import com.hebin.lesson.entity.TeacherTestEntity;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.lesson.feign.TestFeign;
import com.hebin.lesson.service.TeacherDirService;
import com.hebin.resourse.DTO.TestdetailDTO;
import com.hebin.testservice.VO.CreateChoiceVO;
import com.hebin.testservice.VO.CreateQaVO;
import com.hebin.testservice.entity.TestEntityEntity;
import com.hebin.testservice.feignDTO.CreateTestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hebin.lesson.service.TeacherTestService;




/**
 * 
 *
 * @author hebin
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:53:54
 */
@Api(tags = "备课区-测试")
@RestController
@RequestMapping("lesson/teachertest")
public class TeacherTestController {
    @Autowired
    private TeacherTestService teacherTestService;
    @Autowired
    private TestFeign testFeign;

    @Autowired
    private TeacherDirService teacherDirService;
    /**
     * 列表
     */
    @ApiOperation("新增测试")
    @PostMapping("/createtest")
    @PreAuthorize("hasAuthority('lesson:teachertest:list')")
    public Resp<Object> createTest(@RequestBody CreateTestVO createTestVO) {
        CreateTestDTO createTestDTO = new CreateTestDTO();
        BeanUtils.copyProperties(createTestVO,createTestDTO);
        String testId=testFeign.createTest(createTestDTO);
        String userId="245";
        TeacherTestEntity teacherTestEntity = new TeacherTestEntity();
        teacherTestEntity.setUserId(userId);
        teacherTestEntity.setCreateTime(new Date());
        if(createTestVO.getFatherId()==null||createTestVO.getFatherId()=="")teacherTestEntity.setFatherId("0");
        else teacherTestEntity.setFatherId(createTestVO.getFatherId());
        teacherTestEntity.setIsDelete(0);
        teacherTestEntity.setTestId(testId);
        teacherTestService.save(teacherTestEntity);
        return Resp.ok("创建成功");
    }
    @ApiOperation("查看测试区资源")
    @GetMapping("/listtest")
    @PreAuthorize("hasAuthority('lesson:teacherinteractive:list')")
    public Resp<Object> listtest(@RequestParam("fatherId")String fatherId) {
        //步骤：1查询所有测试（type==1）且父文件夹id为0的
        //2.远程调用获取这些id的实体
        //3.查询dir下的type=0的且父文件夹id为0的
        //4.返回一个统一对象
        String userId = "245";

        ListTestDTO listTestDTO = new ListTestDTO();
        QueryWrapper<TeacherTestEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("user_id",userId).eq("father_id",fatherId).ne("is_delete",1));
        List<TeacherTestEntity> teacherTestEntityList=teacherTestService.list(queryWrapper);

        String ids[] = new String[teacherTestEntityList.size()];
        for(int i = 0;i<teacherTestEntityList.size();i++)
        {
            ids[i] = teacherTestEntityList.get(i).getTestId();
        }


        //返回结果1 进行对test的远程调用
        listTestDTO.setTestEntityEntities(testFeign.listTest(ids));
        //返回结果2
        QueryWrapper<TeacherDir> teacherDirQueryWrapper = new QueryWrapper<>();
        teacherDirQueryWrapper.and(i->i.eq("user_id",userId).eq("father_dir_id",fatherId).eq("type",1));
        listTestDTO.setTeacherDirs(teacherDirService.list(teacherDirQueryWrapper));
        return Resp.ok(listTestDTO);
    }
    @ApiOperation("在测试区下新增/修改选择题")
    @PostMapping("/createchoice")
    public Resp<Object> createChoice(@RequestBody CreateChoiceVO createChoiceVO)
    {
        testFeign.createChoice(createChoiceVO);
        return Resp.ok("保存成功");
    }
    //
    @ApiOperation("修改测试（标题名称等）")
    @PostMapping("/updateinteractive")
    public Resp<Object> updateInteractive(@RequestBody TestEntityEntity testEntity)
    {
        testFeign.updateTest(testEntity);
        return Resp.ok("成功");
    }
    //未测试
    @ApiOperation("在测试区下新增/修改简答题")
    @PostMapping("/createqa")
    public Resp<Object> createqa(@RequestBody CreateQaVO createQaVO)
    {
        String userId = "";

        return testFeign.createQa(createQaVO);
    }
    //
    @ApiOperation("删除测试")
    @PostMapping("/deletetest")
    public Resp<Object> deletetest(@RequestParam("testId") String testId)
    {
        //选择不伤筋动骨的方式，直接删除备课区的索引即可
        QueryWrapper<TeacherTestEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("test_id",testId);
       teacherTestService.remove(queryWrapper);
        return Resp.ok("成功");
    }
    @ApiOperation("查看测试详情")
    @GetMapping("/detailtest")
    public Resp<TestdetailDTO> detailTest(QueryCondition queryCondition, @PathVariable("testId") String testId)
    {
        return testFeign.info(queryCondition,testId);
    }
    @ApiOperation("删除某个简答题")
    @PostMapping("/deleteqa")
    public Resp<Object> deleteQa(@RequestParam("testId") String testId,@RequestParam("qaId") String qaId)
    {
        //在互动层删除那一层关系即可
        return testFeign.deleteQa(testId,qaId);
    }
    @ApiOperation("删除某个选择题")
    @PostMapping("/deletechoice")
    public Resp<Object> deleteChoice(@RequestParam("testId") String testId,@RequestParam("choiceId") String choiceId)
    {
        //在互动层删除那一层关系即可
        return testFeign.deleteChoice(testId,choiceId);
    }




}
