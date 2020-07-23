/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.feign;

import com.hebin.testservice.feign.TestApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("test-service")
public interface TestFeign extends TestApi {

}
