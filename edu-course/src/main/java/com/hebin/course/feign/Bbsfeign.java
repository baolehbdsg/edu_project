/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.course.feign;

import com.hebin.bbs.feign.BbsApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("bbs-service")
public interface Bbsfeign extends BbsApi {

}
