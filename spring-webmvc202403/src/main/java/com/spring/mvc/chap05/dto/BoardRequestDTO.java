package com.spring.mvc.chap05.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardRequestDTO {

    public String writer;
    private String title, content;


}
