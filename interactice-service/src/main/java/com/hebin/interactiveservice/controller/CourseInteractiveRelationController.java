package com.hebin.interactiveservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebin.core.bean.PageVo;
import com.hebin.core.bean.Query;
import com.hebin.core.bean.QueryCondition;
import com.hebin.core.bean.Resp;
import com.hebin.interactiveservice.VO.CreateInteractive;
import com.hebin.interactiveservice.entity.CourseInteractiveRelationEntity;
import com.hebin.interactiveservice.entity.InteractiveEntityEntity;
import com.hebin.interactiveservice.service.CourseInteractiveRelationService;
import com.hebin.interactiveservice.service.InteractiveEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 课程与互动关系
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 15:13:14
 */
@Api(tags = "课程与互动关系")
@RestController
@RequestMapping("interactive/courseinteractiverelation")
public class CourseInteractiveRelationController {
    @Autowired
    private CourseInteractiveRelationService courseInteractiveRelationService;
    @Autowired
    private InteractiveEntityService interactiveEntityService;
    /**
     * 查看课程内的互动列表
     * 完成状态：通过
     */
    @ApiOperation("查看课程内的互动列表")
    @GetMapping("/interactiveList/{courseId}")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:list')")
    public Resp<PageVo> interactivelist(QueryCondition queryCondition,@PathVariable("courseId")String courseId) {
        //根据不同权限，查看的视图不同
        //如果是教师权限，可以查看到该课程下未发布的
        //学生权限只能看到已经发布的互动信息
        QueryWrapper<CourseInteractiveRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        IPage<CourseInteractiveRelationEntity> page = new Query<CourseInteractiveRelationEntity>().getPage(queryCondition);
        courseInteractiveRelationService.page(page,queryWrapper);
        List<CourseInteractiveRelationEntity> courseInteractiveRelationEntities = page.getRecords();
        String interactiveIds [] = new String[courseInteractiveRelationEntities.size()];
        for(int i = 0;i<courseInteractiveRelationEntities.size();i++)
        {
            interactiveIds[i] = courseInteractiveRelationEntities.get(i).getInteractiveId();
        }
        QueryWrapper<InteractiveEntityEntity> interactiveEntityEntityQueryWrapper = new QueryWrapper<>();
        interactiveEntityEntityQueryWrapper.in("interactive_id",interactiveIds);
        List<InteractiveEntityEntity> interactiveEntityEntities = interactiveEntityService.list(interactiveEntityEntityQueryWrapper);
        PageVo pageVo = new PageVo(page);
        pageVo.setList(interactiveEntityEntities);
        return Resp.ok(pageVo);
    }
    /**
     * 查看某个互动的详细信息
     * 测试状态：未通过
     * 查看的应该是这个互动内的题目信息，先完成新增互动题目
     */
    @ApiOperation("查看某个互动的详细信息")
    @GetMapping("/info/{interactiveId}")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:info')")
    public Resp<CourseInteractiveRelationEntity> info(@PathVariable("interactiveId") String interactiveId){
		CourseInteractiveRelationEntity courseInteractiveRelation = courseInteractiveRelationService.getById(interactiveId);
        return Resp.ok(courseInteractiveRelation);
    }
    /**
     * 新建互动
     * 测试状态：ok
     * 远程调用
     */
    @ApiOperation("新建互动")
    @PostMapping("/createinteractive")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:save')")
    public Resp<Object> createInteractive(@RequestBody CreateInteractive createInteractive){
        CourseInteractiveRelationEntity courseInteractiveRelationEntity = new CourseInteractiveRelationEntity();
        InteractiveEntityEntity interactiveEntityEntity = new InteractiveEntityEntity();
        BeanUtils.copyProperties(createInteractive,interactiveEntityEntity);
        interactiveEntityEntity.setIsDelete(0);
        interactiveEntityService.save(interactiveEntityEntity);
        BeanUtils.copyProperties(createInteractive,courseInteractiveRelationEntity);
        courseInteractiveRelationEntity.setInteractiveId(interactiveEntityEntity.getInteractiveId());
        courseInteractiveRelationEntity.setIsDelete(0);
        courseInteractiveRelationService.save(courseInteractiveRelationEntity);

        return Resp.ok("ok");

    }

    /**
     * 发布互动
     * 测试状态：完成
     */
    @ApiOperation("发布互动")
    @PostMapping("/publishinteractive")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:update')")
    public Resp<Object> publishInteractive(@RequestParam("interactiveId")String interactiveId){
        QueryWrapper<CourseInteractiveRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interactive_id",interactiveId);
        CourseInteractiveRelationEntity courseInteractiveRelationEntity = new CourseInteractiveRelationEntity();
        courseInteractiveRelationEntity.setPublish(1);
        if(courseInteractiveRelationService.update(courseInteractiveRelationEntity,queryWrapper))return Resp.ok("发布成功");
        return Resp.ok("发布失败，请重新发布");
    }

    /**
     * 删除互动
     * 只用删除course_interactive_relation
     * 和interactive_interactive_entity
     */
    @ApiOperation("删除互动")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		courseInteractiveRelationService.removeByIds(Arrays.asList(ids));
        return Resp.ok(null);
    }
    /**
     * 修改互动标题或上传（内容）
     * type先暂时不让修改
     * 测试状态：通过
     */
    @ApiOperation("修改互动")
    @PostMapping("/modifyinteractive")
    @PreAuthorize("hasAuthority('course:courseinteractiverelation:update')")
    public Resp<Object> modifyInteractive(@RequestBody InteractiveEntityEntity interactiveEntityEntity){
        QueryWrapper<InteractiveEntityEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interactive_id",interactiveEntityEntity.getInteractiveId());
        if(interactiveEntityService.update(interactiveEntityEntity,queryWrapper))return Resp.ok("修改成功");
        return Resp.ok("修改失败");
    }

}
