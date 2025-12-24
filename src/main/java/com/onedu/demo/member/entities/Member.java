package com.onedu.demo.member.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onedu.demo.global.entities.BaseEntity;
import com.onedu.demo.member.contants.Authority;
import com.onedu.demo.member.contants.Gender;
import com.onedu.demo.member.contants.MemberCondition;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 회원 Entity
 *
 */

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends BaseEntity {

    // 회원 번호
    @Id @GeneratedValue
    private Long seq;

    // 회원 권한
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Authorities> authorities;

    // 회원 상태
    @Enumerated(EnumType.STRING)
    private MemberCondition memberCondition;

    // 이메일
    @Column(length = 65, nullable = false, unique = true)
    private String email;

    // 비밀번호
    @Column(length = 65, nullable = false)
    private String password;

    // 비밀번호 변경 일시
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime credentialChangedAt;

    // 회원명
    @Column(length = 40, nullable = false)
    private String name;

    // 닉네임
    @Column(length = 40, nullable = false)
    private String nickName;

    // 자기소개
    @Lob
    private String bio;

    // 생년월일
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate birthDt;

    // 성별
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;

    // 우편번호
    @Column(length = 10, nullable = false)
    private String zipCode;

    // 주소
    @Column(length = 100, nullable = false)
    private String address;

    // 상세 주소
    @Column(length = 100)
    private String addressSub;

    // 휴대전화
    @Column(length = 20, nullable = false)
    private String phoneNumber;

    // 프로필 이미지
    // 파일 추후 추가

    @Transient
    private List<Authority> authorities_;

    public List<Authority> get_authorities() {

        return authorities == null || authorities.isEmpty() ? List.of()
                : authorities.stream().map(Authorities::getAuthority).toList();
    }
}
