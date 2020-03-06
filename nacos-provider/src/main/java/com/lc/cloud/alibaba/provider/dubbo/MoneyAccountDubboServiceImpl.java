package com.lc.cloud.alibaba.provider.dubbo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lc.cloud.alibaba.api.MoneyAccountDubboService;
import com.lc.cloud.alibaba.provider.domain.service.MoneyAccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Slf4j
@Service
public class MoneyAccountDubboServiceImpl implements MoneyAccountDubboService {

    @Autowired
    MoneyAccountService moneyAccountService;

    @SentinelResource(blockHandler = "useBlock")
    @Override
    public BigDecimal use(BigDecimal useAmount, Long id) {
        return moneyAccountService.use(useAmount, id);
    }

    @SentinelResource(blockHandler = "addBlock")
    @Override
    public BigDecimal add(BigDecimal addAmount, Long id) {
        return moneyAccountService.add(addAmount, id);
    }

    @SentinelResource(blockHandler = "queryAvailableAmountBlock")
    @Override
    public BigDecimal queryAvailableAmount(Long id) {
        return moneyAccountService.queryAvailableAmount(id);
    }

    @SentinelResource(blockHandler = "queryOutAmountBlock")
    @Override
    public BigDecimal queryOutAmount(Long id) {
        return moneyAccountService.queryOutAmount(id);
    }


    /**
     * 触发流量降级后的代码控制
     */
    public BigDecimal useBlock(BigDecimal useAmount, Long id, BlockException ex) {
        log.warn("useAmount:" + useAmount + " id:" + id, ex);
        return BigDecimal.ZERO;
    }

    public BigDecimal addBlock(BigDecimal addAmount, Long id, BlockException ex) {
        log.warn("addAmount:" + addAmount + " id:" + id, ex);
        return BigDecimal.ZERO;
    }

    public BigDecimal queryAvailableAmountBlock(Long id, BlockException ex) {
        log.warn("id:" + id, ex);
        return BigDecimal.ZERO;
    }

    public BigDecimal queryOutAmountBlock(Long id, BlockException ex) {
        log.warn("id:" + id, ex);
        return BigDecimal.ZERO;
    }
}