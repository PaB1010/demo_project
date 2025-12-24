package com.onedu.demo.global.validators;


public interface MobileValidator {

    default boolean checkMobile(String num) {

        num = num.replaceAll("\\D", "");

        String pattern = "^010\\d{4}\\d{4}$";

        return num.matches(pattern);
    }
}
