package com.lc.cloud.alibaba.provider.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Seata 所需要的记录表
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "undo_log")
public class UndoLog implements Serializable {
    @Id
    @Column(name = "id",
            columnDefinition = "bigint(20) COMMENT 'ID,自增'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "branch_id",
            columnDefinition = ("bigint(20) NOT NULL COMMENT '批次ID'"))
    Long branchId;

    @Column(name = "xid",
            columnDefinition = ("varchar(100) NOT NULL"))
    String xid;

    @Column(name = "context",
            columnDefinition = ("varchar(128) NOT NULL"))
    String context;

    @Column(name = "rollback_info",
            columnDefinition = ("longblob NOT NULL"))
    String rollbackInfo;

    @Column(name = "log_status",
            columnDefinition = ("integer(11) NOT NULL"))
    Integer logStatus;

    @Column(name = "log_created",
            columnDefinition = ("datetime NOT NULL"))
    Date logCreated;

    @Column(name = "log_modified",
            columnDefinition = ("datetime NOT NULL"))
    Date logModified;

    @Column(name = "ext",
            columnDefinition = ("varchar(100)"))
    String ext;
}
