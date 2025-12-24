package com.onedu.demo.global.advices;

import com.onedu.demo.global.exceptions.CommonException;
import com.onedu.demo.global.libs.Utils;
import com.onedu.demo.global.rests.JSONData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestControllerAdvice(annotations = RestControllerAdvice.class, basePackages = "com.onedu")
public class CommonControllerAdvice {

    private final Utils utils;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData> errorHandler(Exception e) {

        // 기본 값 = 500
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        Object message = e.getMessage();

        // 사용자 정의 예외
        if (e instanceof CommonException commonException) {

            status = commonException.getStatus();

            Map<String, List<String>> errorMessages = commonException.getErrorMessages();

            if (errorMessages != null) message = errorMessages;

            else message = commonException.isErrorCode() ? utils.getMessage((String)message) : message;
        }

        JSONData data = new JSONData();

        data.setSucceess(false);

        data.setStatus(status);

        data.setMessage(message);

        e.printStackTrace();

        return ResponseEntity.status(status).body(data);
    }
}
