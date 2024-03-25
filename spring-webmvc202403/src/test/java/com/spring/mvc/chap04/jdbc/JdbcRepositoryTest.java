package com.spring.mvc.chap04.jdbc;

import com.spring.mvc.chap04.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcRepositoryTest {

    @Autowired
    JdbcRepository jdbcRepository;

    @Test
    @DisplayName("Peseon 객체 정보를 데이터베이스에 정상 삽입해야 한다")
    void saveTest(){
        Person p = new Person(0, "홍길동", 29);
        jdbcRepository.save(p);

    }

}