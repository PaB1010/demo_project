package com.onedu.demo.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 모든 JSON Data 형식
 *
 */
@Data
@NoArgsConstructor
public class JSONData {


    // 기본 값 = OK
    private HttpStatus status = HttpStatus.OK;

    // 기본 값 = true
    private boolean succeess = true;

    // 중첩된 필드일 가능성이 있어 Object
    private Object message;

    // 성공시 Data
    private Object data;

    private JSONData(Object data) {

        this.data = data;
    }
}
