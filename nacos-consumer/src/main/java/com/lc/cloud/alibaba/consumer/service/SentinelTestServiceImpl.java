package com.lc.cloud.alibaba.consumer.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lc.cloud.alibaba.api.TestService;
import com.lc.cloud.alibaba.consumer.fuse.SentinelTestServiceBlockHandler;
import com.lc.cloud.alibaba.consumer.fuse.SentinelTestServiceFallbackHandler;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class SentinelTestServiceImpl implements SentinelTestService {
    @Reference
    TestService testService;

    /*******
     * 注意 ：若 blockHandler 和 fallback 都进行了配置
     * 则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑
     */
    @SentinelResource(blockHandler = "get2BlockHandler",
            blockHandlerClass = {SentinelTestServiceBlockHandler.class},
            fallback = "get1FallbackHandler",
            fallbackClass = {SentinelTestServiceFallbackHandler.class})
    @Override
    public String get(String str) {
        if (1 == 1) throw new RuntimeException("自定义异常");
        return testService.get(str);
    }

    @SentinelResource(blockHandler = "get2BlockHandler",
            blockHandlerClass = {SentinelTestServiceBlockHandler.class})
    @Override
    public String get2(String str) {
        if (1 == 1) throw new RuntimeException("自定义异常");
        return testService.get2(str);
    }

    @SentinelResource(fallback = "get3Fallback")
    @Override
    public String get3(String str) {
        if (1 == 1) throw new RuntimeException("自定义异常");
        return testService.get3(str);
    }

    //这里的服务降级或回退方法只需要  public 修饰
    public String get2BlockHandler(String str) {
        return "get2BlockHandler :" + str;
    }

    public String get3Fallback(String str) {
        return "get3Fallback :" + str;
    }
}
