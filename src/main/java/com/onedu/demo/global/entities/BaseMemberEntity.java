package com.onedu.demo.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 회원이 생성하는 모든 Entity에 상속
 *
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseMemberEntity extends BaseEntity {

    @CreatedBy
    @Column(length = 65, updatable = false)
    // 생성자
    private String createdBy;

    @LastModifiedBy
    @Column(length = 65, insertable = false)
    // 수정자
    private String modifiedBy;

    @Column(length = 65)
    // 삭제자
    private String deletedBy;
}
