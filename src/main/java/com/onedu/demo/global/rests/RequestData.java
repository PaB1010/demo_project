package com.onedu.demo.global.rests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * 요청 데이터
 *
 * @param <T>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestData<T> {

    private List<T> data;
}
