package com.lc.cloud.alibaba.consumer.fuse;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务降级的调用在这里定义方法 最高优先级
 * 这里的方法必须是  public static 修饰
 */
@Slf4j
public class SentinelTestServiceBlockHandler {
    public static String get1BlockHandler(String str, BlockException ex) {
        ex.printStackTrace();
        return "get1BlockHandler :" + str;
    }

    public static String get2BlockHandler(String str, BlockException ex) {
        ex.printStackTrace();
        return "get2BlockHandler :" + str;
    }

    public static String get3BlockHandler(String str, BlockException ex) {
        ex.printStackTrace();
        return "get3BlockHandler :" + str;
    }
}
