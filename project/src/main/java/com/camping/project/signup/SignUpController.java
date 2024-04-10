package com.camping.project.signup;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SignUpController {


        @GetMapping("/sign-up")
        public String signUp(){

            return "sign-up/sign-up";
        }







}
