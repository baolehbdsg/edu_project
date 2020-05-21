/*
 * Copyright (c) 2020. edu_project.
 *
 * 作者：何彬.
 *
 * 版权所有，侵权必究.
 */

package com.hebin.bbs.feign;

import com.hebin.core.bean.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface BbsApi {
    @PostMapping("bbs/bbs/bbsapi/createcoursebbs")
    public Resp<String> createcoursebbs(@RequestParam(value = "bbsName",required = true) String bbsName);
}
