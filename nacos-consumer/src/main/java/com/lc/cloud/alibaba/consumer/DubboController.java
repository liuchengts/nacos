package com.lc.cloud.alibaba.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lc.cloud.alibaba.api.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
@RefreshScope
public class DubboController {
    @Reference
    TestService testService;

    /**
     * http://localhost:8081/dubbo/get
     * http://localhost:8081/dubbo/get2
     * http://localhost:8081/dubbo/get3
     */
    /*******
     * 注意 ：若 blockHandler 和 fallback 都进行了配置
     * 则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑
     */
    @GetMapping("get")
    public String get() {
        return testService.get("consumerSend-get");
    }

    @GetMapping("get2")
    public String get2() {
        return testService.get2("consumerSend-get2");
    }

    @GetMapping("get3")
    public String get3() {
        return testService.get3("consumerSend-get3");
    }

    public static String get2BlockHandler(String str) {
        return "get2BlockHandler :" + str;
    }

    public static String get3Fallback(String str) {
        return "get3Fallback :" + str;
    }
}