package com.spring.core.chap01;

public class WesternRestaurant implements Restaurant{

    // 의존 객체
    private Chef chef;
    private WesternCoures coures = new WesternCoures();

    public WesternRestaurant(Chef chef) {
        this.chef = chef;
    }

    // 요리를 주문하는 기능
    public void order(){
        System.out.println("서양 요리를 주문 합니다.");
        // 요리 코스 메뉴를 구성해야 한다
        coures.combineMenu();
        // 요리사에게 요리 명령을 내려야 한다
        chef.cook();
        
    }

}
