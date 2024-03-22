package com.spring.core.chap02;

import com.spring.core.chap01.Hotel;
import com.spring.core.config.HotelManager;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    // 스프링 컨테이너를 읽어오는 객체
    AnnotationConfigApplicationContext ctx
            = new AnnotationConfigApplicationContext(HotelManager.class);


    @Test
    void hotelAutoTest(){
//        Hotel hotel = new Hotel();
        Hotel hotel = ctx.getBean(Hotel.class);
        hotel.reserve();



    }

}