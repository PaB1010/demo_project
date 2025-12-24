package com.onedu.demo.member.jwt;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * Token 생성 & Login 처리
 *
 */
@Service
@EnableConfigurationProperties(JwtProperties.class)
public class TokenService {


}
