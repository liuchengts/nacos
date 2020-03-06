package com.lc.cloud.alibaba.consumer.controllers;

import com.lc.cloud.alibaba.consumer.domain.service.SentinelTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
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