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
     */
    @SentinelResource("dubbo")
    @GetMapping("get")
    public String get() {
        return testService.get("consumerSend");
    }
}