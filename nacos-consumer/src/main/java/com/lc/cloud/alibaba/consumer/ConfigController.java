package com.lc.cloud.alibaba.consumer;

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
@RefreshScope
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