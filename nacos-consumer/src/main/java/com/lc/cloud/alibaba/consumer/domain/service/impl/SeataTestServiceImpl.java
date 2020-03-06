package com.lc.cloud.alibaba.consumer.domain.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lc.cloud.alibaba.api.MoneyAccountDubboService;
import com.lc.cloud.alibaba.consumer.domain.model.MoneyRecord;
import com.lc.cloud.alibaba.consumer.domain.repository.MoneyRecordRepository;
import com.lc.cloud.alibaba.consumer.domain.service.SeataTestService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@RefreshScope  //Nacos动态刷新配置 需要热加载的bean需要加上@RefreshScope注解，当配置发生变更的时候可以在不重启应用的前提下完成bean中相关属性的刷新
@Service
public class SeataTestServiceImpl implements SeataTestService {
    @Reference
    MoneyAccountDubboService moneyAccountDubboService;
    @Autowired
    MoneyRecordRepository moneyRecordRepository;

    @GlobalTransactional
    @Override
    public BigDecimal use(BigDecimal useAmount, Long id) {
        BigDecimal amount = moneyAccountDubboService.use(useAmount, id);
        moneyRecordRepository.save(MoneyRecord.builder()
                .accountId(id)
                .recordAmount(useAmount)
                .type(-1)
                .build());
        if (1 == 1) throw new RuntimeException("自定义异常");
        return amount;
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public BigDecimal add(BigDecimal addAmount, Long id) {
        BigDecimal amount = moneyAccountDubboService.add(addAmount, id);
        moneyRecordRepository.save(MoneyRecord.builder()
                .accountId(id)
                .recordAmount(addAmount)
                .type(1)
                .build());
        return amount;
    }

    @Override
    public BigDecimal queryAvailableAmount(Long id) {
        return moneyAccountDubboService.queryAvailableAmount(id);
    }

    @Override
    public BigDecimal queryOutAmount(Long id) {
        return moneyAccountDubboService.queryOutAmount(id);
    }

//    /**
//     * 触发异常后的代码控制
//     */
//    public BigDecimal useFallback(BigDecimal useAmount, Long id) {
//        log.warn("useAmount:" + useAmount + " id:" + id);
//        return BigDecimal.ZERO;
//    }
//
//    public BigDecimal addFallback(BigDecimal addAmount, Long id) {
//        log.warn("addAmount:" + addAmount + " id:" + id);
//        return BigDecimal.ZERO;
//    }
//
//    public BigDecimal queryAvailableAmountFallback(Long id) {
//        log.warn("id:" + id);
//        return BigDecimal.ZERO;
//    }
//
//    public BigDecimal queryOutAmountFallback(Long id) {
//        log.warn("id:" + id);
//        return BigDecimal.ZERO;
//    }
}
