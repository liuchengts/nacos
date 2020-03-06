package com.lc.cloud.alibaba.api;

import java.math.BigDecimal;

public interface MoneyAccountDubboService {
    /***
     * 消耗账户可用金额
     * @param useAmount  要消耗的金额
     * @param id   账户id
     * @return 返回实际消耗的金额
     */
    BigDecimal use(BigDecimal useAmount, Long id);

    /***
     * 增加账户可用金额
     * @param addAmount  要增加的金额
     * @param id   账户id
     * @return 返回账户可用的金额
     */
    BigDecimal add(BigDecimal addAmount, Long id);

    /**
     * 查询账户可用金额
     *
     * @param id 账户id
     * @return 返回账户可用的金额
     */
    BigDecimal queryAvailableAmount(Long id);


    /**
     * 查询账户已用金额
     *
     * @param id 账户id
     * @return 返回账户已用的金额
     */
    BigDecimal queryOutAmount(Long id);

}
