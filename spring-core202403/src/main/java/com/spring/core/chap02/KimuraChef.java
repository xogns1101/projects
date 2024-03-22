package com.spring.core.chap02;

import org.springframework.stereotype.Component;

@Component("kc")
public class KimuraChef implements Chef {

    public void cook(){
        System.out.println("기무라 쉐프가 요리합니다.");
    }
}
