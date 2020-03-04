package com.lc.cloud.alibaba.provider.service.impl;

import com.lc.cloud.alibaba.api.TestService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String get(String str) {
        return "get1 TestServiceImpl" + System.currentTimeMillis();
    }

    @Override
    public String get2(String str) {
        return "get2 TestServiceImpl" + System.currentTimeMillis();
    }

    @Override
    public String get3(String str) {
        return "get3 TestServiceImpl" + System.currentTimeMillis();
    }
}
