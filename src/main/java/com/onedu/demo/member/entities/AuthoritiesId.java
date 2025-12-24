package com.onedu.demo.member.entities;

import com.onedu.demo.member.contants.Authority;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 회원 권한 Id Class
 *
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AuthoritiesId implements Serializable {

    private Member member;

    private Authority authority;
}
