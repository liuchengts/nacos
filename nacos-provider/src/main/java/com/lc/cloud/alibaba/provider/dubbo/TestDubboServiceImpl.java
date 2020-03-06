package com.lc.cloud.alibaba.provider.dubbo;

import com.lc.cloud.alibaba.api.TestDubboService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestDubboServiceImpl implements TestDubboService {

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
