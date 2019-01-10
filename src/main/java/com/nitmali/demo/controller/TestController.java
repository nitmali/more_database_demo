package com.nitmali.demo.controller;

import com.nitmali.demo.service.ITestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author nitmali
 * @date 2019/1/10 16:24
 */
@RestController
public class TestController {
    @Resource
    private ITestService iTestService;

    @GetMapping("/test")
    public void systemRun() {
        iTestService.test();
    }
}
