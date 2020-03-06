package com.lc.cloud.alibaba.consumer.domain.repository;

import com.lc.cloud.alibaba.consumer.domain.model.MoneyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MoneyRecordRepository extends JpaRepository<MoneyRecord, Serializable>,
        JpaSpecificationExecutor<MoneyRecord> {
}
