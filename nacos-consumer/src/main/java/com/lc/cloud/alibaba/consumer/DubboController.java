package com.lc.cloud.alibaba.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lc.cloud.alibaba.consumer.service.SentinelTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
@RefreshScope  //需要热加载的bean需要加上@RefreshScope注解，当配置发生变更的时候可以在不重启应用的前提下完成bean中相关属性的刷新
public class DubboController {

    @Autowired
    SentinelTestService sentinelTestService;
    /**
     * http://localhost:8081/dubbo/get
     * http://localhost:8081/dubbo/get2
     * http://localhost:8081/dubbo/get3
     */
    @GetMapping("get")
    public String get() {
        return sentinelTestService.get("consumerSend-get");
    }

    @GetMapping("get2")
    public String get2() {
        return sentinelTestService.get2("consumerSend-get2");
    }

    @GetMapping("get3")
    public String get3() {
        return sentinelTestService.get3("consumerSend-get3");
    }
}