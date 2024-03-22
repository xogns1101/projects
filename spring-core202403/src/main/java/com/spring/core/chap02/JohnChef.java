package com.spring.core.chap02;

import org.springframework.stereotype.Component;

@Component("jc")
public class JohnChef implements Chef {

    public void cook(){
        System.out.println("존 셰프가 서양 요리를 합니다.");
    }

}
