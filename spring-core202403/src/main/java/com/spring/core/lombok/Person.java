package com.spring.core.lombok;

    /*
 자바 빈 (java bean)
 웹 프로그래밍에서 어떠한 객체를 가지고 오기 위한 기법이며, 자바 언어로 작성된
 클래스를 일반적으로 부르는 호칭입니다.

 자바빈을 설계하기 위한 규약이 존재합니다.
 1. 은닉(캡슐화)을 구현해서 클래스를 제작합니다. (변수 private, getter/setter)
 2. getter 메서드는 매개변수가 존재하지 않아야 한다.
 3. 생성자는 매개값을 받지 않는 생성자(필수), 매개값을 받는 생성자(선택)가 존재한다.
 4. 모든 getter/setter 메서드는 접근 제한이 public 이어야 한다.

*/

import lombok.*;

@Setter @Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 초기화 하는 생성자
@ToString
@EqualsAndHashCode
public class Person {

    private String name;
    private int age;







}
