package com.onedu.demo.global.libs;

import com.onedu.demo.member.libs.MemberUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 공통 유틸
 *
 */
@Lazy
@Component
@RequiredArgsConstructor
public class Utils {

    private final MemberUtil memberUtil;

    private final HttpServletRequest request;

    private final MessageSource messageSource;

    /**
     * 메세지 코드로 조회된 문구
     *
     * @param code
     * @return
     */
    public String getMessage(String code) {

        // 사용자 요청 헤더 - Accept-Language
        Locale lo = request.getLocale();

        return messageSource.getMessage(code, null, lo);
    }

    public List<String> getMessages(String[] codes) {

        return Arrays.stream(codes).map(c -> {

            try {

                return getMessage(c);

            } catch (Exception e) {

                return "";
            }
        }).filter(s -> !s.isBlank()).toList();
    }

    /**
     * REST 커맨드 객체 검증 실패시에 에러 코드를 가지고 메세지 추출
     *
     * @param errors
     * @return
     */
    public Map<String, List<String>> getErrorMessage(Errors errors) {

        ResourceBundleMessageSource ms = (ResourceBundleMessageSource) messageSource;

        /**
         * 필드별 에러 코드
         *
         */
        Map<String, List<String>> messages = errors.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, f -> getMessages(f.getCodes()), (v1, v2) -> v2));

        /**
         * 글로벌 에러 코드
         *
         */
        List<String> gMessages = errors.getGlobalErrors()
                .stream()
                .flatMap(o -> getMessages(o.getCodes()).stream())
                .toList();

        if (!gMessages.isEmpty()) messages.put("global", gMessages);

        return messages;
    }

    /**
     * 요청 헤더
     *
     * @return
     */
    public String getAuthToken() {

        String auth = request.getHeader("Authorization");

        return StringUtils.hasText(auth) ? auth.substring(7).trim() : null;
    }

    /**
     * 전체 주소
     *
     * @param url
     * @return
     */
    public String getUrl(String url) {

        int port = request.getServerPort();

        String _port = port == 80 || port == 443 ? "" : ":" + port;

        return String.format("%s://%s%s%s%s", request.getScheme(), request.getServerName(), _port, request.getContextPath(), url);
    }

    /**
     * 모바일 접속 여부
     *
     * @return
     */
    public boolean isMobile() {

        String ua = request.getHeader("User-Agent");

        String pattern = ".*(iPhone|iPod|iPad|BlackBerry|Android|Windows CE|LG|MOT|SAMSUNG|SonyEricsson).*";

        return StringUtils.hasText(ua) && ua.matches(pattern);
    }

    /**
     * 요청 헤더
     *
     * - JWT 토큰이 있으면 자동 추가
     *
     * @return
     */
    public HttpHeaders getRequestHeader() {

        String token = getAuthToken();

        HttpHeaders headers = new HttpHeaders();

        if (StringUtils.hasText(token)) headers.setBearerAuth(token);

        return headers;
    }

    /**
     * 회원 / 비회원 구분 해시
     *
     * 회원 - 회원번호
     * 비회원 - IP + User-Agent
     *
     * @return
     */
    public int getMemberHash() {

        // 회원
        if (memberUtil.isLogin()) return Objects.hash(memberUtil.getMember().getSeq());

        else {

            String ip = request.getRemoteAddr();

            String ua = request.getHeader("User=Agent");

            return Objects.hash(ip, ua);
        }
    }

    /**
     * 사용자 구분을 위한 해시값 조회
     *
     * @return
     */
    public String getUserHash() {

        String userKey = "" + Objects.hash("useHash");

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals(userKey)) return cookie.getValue();
        }

        return null;
    }
}
