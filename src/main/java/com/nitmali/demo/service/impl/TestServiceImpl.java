package com.nitmali.demo.service.impl;

import com.nitmali.demo.mapper.first.FirstMapper;
import com.nitmali.demo.mapper.second.SecondMapper;
import com.nitmali.demo.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author nitmali
 * @date 2019/1/10 16:11
 */
@Service
@Slf4j
public class TestServiceImpl implements ITestService {

    @Resource
    private FirstMapper firstMapper;

    @Resource
    private SecondMapper secondMapper;

    @Override
    public void test() {
        log.info("firstMapper test get count: " + firstMapper.countAll());
        log.info("secondMapper test get count: " +  secondMapper.countAll());
    }
}
