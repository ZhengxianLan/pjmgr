package com.citic.pjmgr.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lan on 6/10/18.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
