package com.lc.cloud.alibaba.provider.service.impl;

import com.lc.cloud.alibaba.api.TestService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String get(String str) {
        return str + System.currentTimeMillis();
    }
}
