package com.camp.mvc.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {


    @PostMapping("/sign-up")
    public String signUp(){


        return "";
    }













}
