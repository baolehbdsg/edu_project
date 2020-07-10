/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.interacticeservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hebin.core.bean.Resp;
import com.hebin.interacticeservice.entity.StuChoiceInteractiveEntity;
import com.hebin.interacticeservice.VO.StuCommitInteractiveVO;
import com.hebin.interacticeservice.entity.StuQaInteractiveEntity;
import com.hebin.interacticeservice.service.StuChoiceInteractiveService;
import com.hebin.interacticeservice.service.StuQaInteractiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "学生提交互动")
@RestController
@RequestMapping("interactive/stuinteractivecommit")
public class StuInteractiveCommitController {
    @Autowired
    StuChoiceInteractiveService stuChoiceInteractiveService;
    @Autowired
    StuQaInteractiveService stuQaInteractiveService;
    /**
     * 学生提交互动
     * 测试状态：通过
     */
    @ApiOperation("学生提交互动")
    @PostMapping("/commit")
    public Resp<Object> commitTest(@RequestBody List<StuCommitInteractiveVO> stuCommitInteractiveVOS){
        //判断有不有choiceType这个字段
        //如果有则存在stuTestChoice里头
        //如果没有就放到问答题那个里头
        //通过权限验证，获取学生id
        String stuId = "11";
        for(int i =0;i<stuCommitInteractiveVOS.size();i++)
        {
            //
            if(stuCommitInteractiveVOS.get(i).getChoiceType()!=null)
            {
                //判断已经有记录则将之前的逻辑删除
                //并且插入新记录
                String interactiveId = stuCommitInteractiveVOS.get(i).getInteractiveId();
                String choiceId = stuCommitInteractiveVOS.get(i).getSubjectId();
                QueryWrapper<StuChoiceInteractiveEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.and(p->p.eq("user_id",stuId).eq("interactive_id",interactiveId).eq("choice_id",choiceId));
                if(stuChoiceInteractiveService.getOne(queryWrapper)!=null)stuChoiceInteractiveService.remove(queryWrapper);

                StuChoiceInteractiveEntity stuChoiceInteractiveEntity = new StuChoiceInteractiveEntity();
                stuChoiceInteractiveEntity.setUserId(stuId);
                BeanUtils.copyProperties(stuCommitInteractiveVOS.get(i),stuChoiceInteractiveEntity);
                stuChoiceInteractiveEntity.setChoiceId(stuCommitInteractiveVOS.get(i).getSubjectId());
                stuChoiceInteractiveEntity.setIsDelete(0);
                stuChoiceInteractiveEntity.setStuInteractiveChoiceAnswer(stuCommitInteractiveVOS.get(i).getAnswer());
                if(stuChoiceInteractiveService.save(stuChoiceInteractiveEntity));
                else return Resp.ok("提交失败");
            }
            else
            {
                //先判断是不是存在该记录，不存在则
                String interactiveId = stuCommitInteractiveVOS.get(i).getInteractiveId();
                String qaId = stuCommitInteractiveVOS.get(i).getSubjectId();

                QueryWrapper<StuQaInteractiveEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.and(p->p.eq("user_id",stuId).eq("interactive_id",interactiveId).eq("qa_id",qaId));
                //删除原有的，然后再对新增记录
                if(stuQaInteractiveService.getOne(queryWrapper)!=null)stuQaInteractiveService.remove(queryWrapper);

                StuQaInteractiveEntity stuQaInteractiveEntity = new StuQaInteractiveEntity();
                stuQaInteractiveEntity.setUserId(stuId);
                BeanUtils.copyProperties(stuCommitInteractiveVOS.get(i),stuQaInteractiveEntity);
                stuQaInteractiveEntity.setQaId(stuCommitInteractiveVOS.get(i).getSubjectId());
                stuQaInteractiveEntity.setIsDelete(0);
                stuQaInteractiveEntity.setStuInteractiveQaAnswer(stuCommitInteractiveVOS.get(i).getAnswer());
                if(stuQaInteractiveService.save(stuQaInteractiveEntity));
                else return Resp.ok("提交失败");
            }
        }
        return Resp.fail("提交成功");
    }
}
