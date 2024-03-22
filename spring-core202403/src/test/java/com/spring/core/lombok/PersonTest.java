package com.spring.core.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void lombokTest(){

        Person p = new Person();
        
        p.setName("홍길동");
        p.setAge(30);

        System.out.println(p);

        String name = p.getName();
        System.out.println("name = " + name);

        Person p2 = new Person("김철수", 29);



    }



}

















