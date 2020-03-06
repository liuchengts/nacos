package com.lc.cloud.alibaba.provider.domain.repository;

import com.lc.cloud.alibaba.provider.domain.model.MoneyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MoneyAccountRepository extends JpaRepository<MoneyAccount, Serializable>,
        JpaSpecificationExecutor<MoneyAccount> {
}
