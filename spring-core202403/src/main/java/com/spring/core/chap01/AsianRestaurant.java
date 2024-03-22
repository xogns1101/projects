package com.spring.core.chap01;

public class AsianRestaurant implements Restaurant{

    private KimuraChef chef = new KimuraChef();
    private SushiCoures coures = new SushiCoures();

    public void order(){
        System.out.println("스시 오마카세를 주문 합니다.");
        coures.combineMenu();
        chef.cook();


    }



}
