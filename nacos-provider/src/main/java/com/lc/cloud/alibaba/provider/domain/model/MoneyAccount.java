package com.lc.cloud.alibaba.provider.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 业务模拟 账户金额表
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "money_account")
public class MoneyAccount implements Serializable {
    @Id
    @Column(name = "id",
            columnDefinition = "bigint(20) COMMENT 'ID,自增'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "available_amount",
            columnDefinition = ("decimal(10,2) DEFAULT 0.00 NOT NULL COMMENT '可用金额'"))
    BigDecimal availableAmount;

    @Column(name = "out_amount",
            columnDefinition = ("decimal(10,2) DEFAULT 0.00 NOT NULL COMMENT '已支出金额'"))
    BigDecimal outAmount;

    @Column(name = "created_at",
            columnDefinition = ("datetime COMMENT '创建时间'"))
    Date createdAt;

    @Column(name = "updated_at",
            columnDefinition = ("datetime COMMENT '修改时间'"))
    Date updatedAt;

    /**
     * 更新
     */
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }

    /**
     * 初始化创建时间和修改时间
     */
    @PrePersist
    public void prePersist() {
        this.createdAt = this.updatedAt = new Date();
    }
}
