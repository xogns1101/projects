package com.spring.core.config;

import com.spring.core.chap01.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 호텔을 운영하기 위해 필요한 의존객체를 전담해서 생성해 주는 역할
@Configuration // 현재 클래스를 설정 파일로 등록 -> @ComponentScan 기능을 사용하기 위한 사전작업
@ComponentScan(basePackages = "com.spring.core.chap02")
// "com.spring.core.chap02"경로에 @Component 가 붙은 모든 객체를 스캔해서 빈으로 등록
public class HotelManager {



    }
