package com.lc.cloud.alibaba.consumer.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/config")
@RefreshScope //Nacos动态刷新配置 需要热加载的bean需要加上@RefreshScope注解，当配置发生变更的时候可以在不重启应用的前提下完成bean中相关属性的刷新
public class ConfigController {

    @Value("${spring.profiles.active}")
    String active;
    @Autowired
    RestTemplate restTemplate;

    /**
     * http://localhost:8081/config/get
     */
    @GetMapping("get")
    public String get(@RequestParam(required = false) String str) {
        return active + " | " + str;
    }

    /**
     * http://localhost:8081/config/rest
     */
    @SentinelResource("ss")
    @GetMapping("rest")
    public String rest() {
        return restTemplate.getForObject("http://nacos-provider/config/get/" + "?str=consumerSend", String.class);
    }
}