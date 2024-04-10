package com.spring.mvc.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user")
public class SignUpController {

        @GetMapping("/sign-up")
        public String signUp(){

            return "user/sign-up";
        }

}
