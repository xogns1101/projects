package com.spring.core.chap02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("ar")
public class AsianRestaurant implements Restaurant {

    private Chef chef;
    private SushiCoures coures = new SushiCoures();

    @Autowired
    public AsianRestaurant(@Qualifier("kc")  Chef chef) {
        this.chef = chef;
    }

    public void order(){
        System.out.println("스시 오마카세를 주문 합니다.");
        coures.combineMenu();
        chef.cook();


    }



}
