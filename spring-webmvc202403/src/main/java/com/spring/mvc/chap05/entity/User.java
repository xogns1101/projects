package com.spring.mvc.chap05.entity;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode @NoArgsConstructor
@AllArgsConstructor @Builder
public class User {

    private String account;
    private String password;
    private String telNumber;
    private String name;
    private String auth;

}
