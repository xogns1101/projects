package com.spring.mvc.chap01;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FoodOrderDTO {

    // 클라이언트 쪽에서 전달 되는 파라미터 이름과 똑같이 필드를 구성해야 한다
    // setter와 기본 생성자가 반드시 존재 해야 함
    private String foodName;
    private String category;
    private int price;



































}
