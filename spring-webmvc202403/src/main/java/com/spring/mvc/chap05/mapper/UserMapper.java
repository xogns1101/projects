package com.spring.mvc.chap05.mapper;

import com.spring.mvc.chap05.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 회원 가입 로직
   void save(User user);




}
