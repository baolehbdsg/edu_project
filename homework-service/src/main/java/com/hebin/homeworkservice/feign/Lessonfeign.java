/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.homeworkservice.feign;

import com.hebin.lesson.feign.LessonApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("lesson-service")
public interface Lessonfeign extends LessonApi {
}
