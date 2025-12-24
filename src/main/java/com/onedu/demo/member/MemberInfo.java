package com.onedu.demo.member;

import com.onedu.demo.member.contants.Authority;
import com.onedu.demo.member.entities.Member;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * UserDetails Interface 구현체
 *
 */
@Data
@Builder
public class MemberInfo implements UserDetails {

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private Member member;

    private List<Authority> _authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return email;
    }

    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    // 계정 잠김 여부
    @Override
    public boolean isAccountNonLocked() {

        return member.getDeletedAt() != null;
    }

    // 비밀번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {

        LocalDateTime credentialChangedAt = member.getCredentialChangedAt();

        return credentialChangedAt != null && credentialChangedAt.isAfter(LocalDateTime.now().minusMonths(1L));
    }

    // False = 탈퇴 회원
    @Override
    public boolean isEnabled() {

        return member.getDeletedAt() == null;
    }
}
