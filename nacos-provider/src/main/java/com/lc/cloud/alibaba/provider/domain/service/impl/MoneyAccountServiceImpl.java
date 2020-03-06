package com.lc.cloud.alibaba.provider.domain.service.impl;

import com.lc.cloud.alibaba.provider.domain.model.MoneyAccount;
import com.lc.cloud.alibaba.provider.domain.repository.MoneyAccountRepository;
import com.lc.cloud.alibaba.provider.domain.service.MoneyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MoneyAccountServiceImpl implements MoneyAccountService {
    @Autowired
    MoneyAccountRepository moneyAccountRepository;

    @Override
    public BigDecimal use(BigDecimal useAmount, Long id) {
        MoneyAccount account = getMoneyAccount(id);
        if (BigDecimal.ZERO.compareTo(useAmount) >= 0) throw new RuntimeException("[" + id + "]消耗的金额必须大于0");
        BigDecimal actualUseAmount = useAmount;
        if (null == account) {
            account = new MoneyAccount();
            account.setAvailableAmount(BigDecimal.ZERO);
            account.setOutAmount(BigDecimal.ZERO);
        }
        if (account.getAvailableAmount().compareTo(useAmount) < 0) actualUseAmount = account.getAvailableAmount();
        account.setAvailableAmount(account.getAvailableAmount().subtract(actualUseAmount));
        account.setOutAmount(account.getOutAmount().add(actualUseAmount));
        moneyAccountRepository.save(account);
        return actualUseAmount;
    }

    @Override
    public BigDecimal add(BigDecimal addAmount, Long id) {
        MoneyAccount account = null;//getMoneyAccount(id);
        if (BigDecimal.ZERO.compareTo(addAmount) >= 0) throw new RuntimeException("[" + id + "]增加的金额必须大于0");
        if (null == account) {
            account = new MoneyAccount();
            account.setAvailableAmount(BigDecimal.ZERO);
        }
        account.setAvailableAmount(account.getAvailableAmount().add(addAmount));
        moneyAccountRepository.save(account);
        return account.getAvailableAmount();
    }

    @Override
    public BigDecimal queryAvailableAmount(Long id) {
        return getMoneyAccount(id).getAvailableAmount();
    }

    @Override
    public BigDecimal queryOutAmount(Long id) {
        return getMoneyAccount(id).getOutAmount();
    }

    private MoneyAccount getMoneyAccount(Long id) {
        return moneyAccountRepository.findById(id).orElse(null);
    }
}
