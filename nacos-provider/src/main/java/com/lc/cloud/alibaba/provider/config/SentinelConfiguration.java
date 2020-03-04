package com.lc.cloud.alibaba.provider.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Sentinel 配置
 */
@Configuration
public class SentinelConfiguration {

    /**
     * 配置方法级别的Sentinel aop
     */
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    /**
     * 让web层请求都经过 sentinelFilter
     */
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelFilter");
        registration.setOrder(1);

        return registration;
    }
}
