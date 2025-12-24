package com.onedu.demo.member.libs;

import com.onedu.demo.member.MemberInfo;
import com.onedu.demo.member.contants.Authority;
import com.onedu.demo.member.entities.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 회원 관련 공통 유틸
 *
 */
@Component
public class MemberUtil {

    /**
     * 로그인 여부
     *
     * @return
     */
    public boolean isLogin() {

        return getMember() != null;
    }

    /**
     * 관리자 여부
     *
     * @return
     */
    public boolean isAdmin() {

        return isLogin() && getMember().get_authorities().stream().anyMatch(a -> a == Authority.ADMIN);
    }


    /**
     * 현재 로그인한 회원 정보 조회
     *
     * @return
     */
    public Member getMember() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof MemberInfo) {

            MemberInfo memberInfo = (MemberInfo) auth.getPrincipal();

            return memberInfo.getMember();
        }

        return null;
    }
}
