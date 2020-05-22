/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.course.feign;

import com.hebin.course.entity.CourseHomeworkEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CourseApi {
    @PostMapping("course/coursehomework/create/coursehomework")
    public void createCourseHomework(@RequestBody CourseHomeworkEntity courseHomework);
}
