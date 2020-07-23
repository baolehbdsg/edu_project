/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.lesson.feign;

import com.hebin.interactiveservice.feign.InteractiveApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("interactive-service")
public interface InteractiveFeign extends InteractiveApi {

}
