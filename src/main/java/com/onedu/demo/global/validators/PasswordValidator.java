package com.onedu.demo.global.validators;

/**
 * 공통 비밀번호 검증
 *
 */
public interface PasswordValidator {

    /**
     * Alphabet 체크
     *
     * (1) 대소문자 각각 1개 이상 있는 경우
     * (2) 대소문자 구분 없이 Alphabet 1자 이상
     *
     * @param password
     * @param caseInsensitive : true = (2), false = (1)
     * @return
     */
    default boolean alphaCheck(String password, boolean caseInsensitive) {

        // 대소문자 구분 없이 Alpahbet 1자 이상
        if (caseInsensitive) return password.matches(".*[a-zA-Z]+.*");

        // 소문자 1자 이상 포함 패턴 && 대문자 1자 이상 포함 패턴
        return password.matches(".*[a-z]+.*") && password.matches(".*[A-Z]+.*");
    }

    /**
     * 숫자 체크
     *
     * @param password
     * @return
     */
    default boolean numberCheck(String password) {

        // 숫자 1자 이상 포함
        return password.matches(".*\\d.*");
    }

    /**
     * 특수문자 체크
     *
     * @param password
     * @return
     */
    default boolean specialCharsCheck(String password) {

        // 숫자 & Alphabet & 한글 제외한 모든 문자
        String pattern = ".*[^0-9a-zA-Zㄱ-ㅎ가-힣].*";

        return password.matches(pattern);
    }
}