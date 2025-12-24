package com.onedu.demo.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/**
 * 모든 Entity에게 상속
 *
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    
    @CreatedDate
    @Column(updatable = false)
    // 등록일시
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(insertable = false)
    // 수정일시
    private LocalDateTime modifiedAt;
    
    // 삭제 일시
    private LocalDateTime deletedAt;
}
