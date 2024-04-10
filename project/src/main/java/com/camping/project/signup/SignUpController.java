package com.camping.project.signup;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class SignUpController {


        @GetMapping("/sign-up")
      //  @ResponseBody
        public String signUp(){

            return "sign-up/sign-up";
        }







}
