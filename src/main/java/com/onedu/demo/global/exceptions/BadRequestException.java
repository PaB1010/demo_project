package com.onedu.demo.global.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

/**
 * 400
 *
 */
public class BadRequestException extends CommonException {

    public BadRequestException() {

        this("BadRequest");

        setErrorCode(true);
    }

    public BadRequestException(String message) {

        super(message, HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(Map<String, List<String>> messages) {

        super(messages, HttpStatus.BAD_REQUEST);
    }
}
