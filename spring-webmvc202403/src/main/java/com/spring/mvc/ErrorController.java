package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
@Controller
public class ErrorController {

    @GetMapping("/404")
    public String error404(){
        return "error/error404";
    }

    @GetMapping("/500")
    public String error500(){
        return "error/error500";
    }

}
