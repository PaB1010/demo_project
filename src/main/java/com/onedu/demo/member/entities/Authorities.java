package com.onedu.demo.member.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onedu.demo.member.contants.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 다중 권한
 *
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AuthoritiesId.class)
public class Authorities {

    // 회원
    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    // 회원 권한
    @Id
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Authority authority;
}
