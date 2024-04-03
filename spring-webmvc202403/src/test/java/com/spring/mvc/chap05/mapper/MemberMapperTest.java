package com.spring.mvc.chap05.mapper;

import com.spring.mvc.chap05.entity.Auth;
import com.spring.mvc.chap05.entity.Member;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;



    @Test
    @DisplayName("회원 가입에 성공해야 한다")
    void saveTest() {
        // given
        
        // when
        Member m = Member.builder()
                .account("abc1234")
                .password("aaa1111")
                .name("김춘식")
                .email("abc1234@naver.com")
                .build();
        memberMapper.save(m);


        // then

    }

    @Test
    @DisplayName("아이디가 abc1234인 계정을 조회하면 그 회원의 이름은 김춘식이여야 한다")
    void findMemberTest() {
        // given
        String account = "abc1234";
        // when
        Member member = memberMapper.findMember(account);

        // then
        assertEquals( member.getName(), "김춘식");
    }

    @Test
    @DisplayName("계정이 abc1234일 경우 중복확인 결과값이 true 여야 한다")
    void duplicateTest() {
        // given
        String account = "abc1234";
        // when
        boolean id = memberMapper.isDuplicate("account", account);
        // then
        assertTrue(id);
    }

    @Test
    @DisplayName("이메일 abc@naver.com 일 경우 중복확인 값이 false 여야 한다")
    void duplicateEmailTest() {
        // given
        String email = "abc@naver.com";
        // when
        boolean e = memberMapper.isDuplicate("email", email);
        // then
        assertFalse(e);
    }

}