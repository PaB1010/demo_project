package com.onedu.demo.global.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 공통 수동 등록 객체 관리
 *
 */
@Configuration
public class BeansConfig {

    @Lazy
    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        return restTemplate;
    }

    /**
     * 커맨드 객체 값 돌려주는 Reflection API
     *
     * 매개변수 = Class 클래스 객체
     *
     * @return
     */
    @Lazy
    @Bean
    public ModelMapper modelMapper() {

       ModelMapper mapper = new ModelMapper();

       // 자료형 미일치시 PASS
       mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

       return mapper;
    }

    /**
     * JSON </-> JAVA code
     * 
     * 매개변수 = Class 클래스 객체
     * 
     * @return
     */
    @Lazy
    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper om = new ObjectMapper();

        om.registerModule(new JavaTimeModule());

        return om;
    }
}
