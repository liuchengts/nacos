package com.lc.cloud.alibaba.consumer.fuse;

import lombok.extern.slf4j.Slf4j;

/**
 * 服务异常后的调用在这里定义方法
 * 这里的方法必须是  public static 修饰
 */
@Slf4j
public class SentinelTestServiceFallbackHandler {
    public static String get1FallbackHandler(String str) {
        return "get1FallbackHandler :" + str;
    }

    public static String get2FallbackHandler(String str) {
        return "get2FallbackHandler :" + str;
    }

    public static String get3FallbackHandler(String str) {
        return "get3FallbackHandler :" + str;
    }
}
