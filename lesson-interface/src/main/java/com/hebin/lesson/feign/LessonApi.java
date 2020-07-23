/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.feign;

//import com.hebin.lesson.entity.TeacherHomeworkEntity;
import com.hebin.lesson.entity.TeacherHomeworkEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LessonApi {
    @ApiOperation("通过课程区同时保存到备课区")
    @PostMapping("lesson/teacherhomework/save/homework")
    public void saveHomework(@RequestBody TeacherHomeworkEntity teacherHomework);
}
