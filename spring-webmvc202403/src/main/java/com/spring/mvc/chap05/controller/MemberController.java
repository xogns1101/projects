package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.dto.request.SignUpRequestDTO;
import com.spring.mvc.chap05.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 가입 양식 화면 요청
    // 응답하고자 하는 화면의 경로가 url 과 동일하다면 void 로 처리가
    // 가능하다!(선택사항)
    @GetMapping("/sign-up")
    public void signupView(){

        System.out.println("/members/sign-up : GET!");

    }

    // 아이디, 이메일 중복체크 비동기 요청 처리
    @GetMapping("/check/{type}/{keyword}")
    @ResponseBody
    public ResponseEntity<?> check(@PathVariable String type
                            , @PathVariable String keyword){

        System.out.println("/members/check : async GET");
        System.out.println("type = " + type);
        System.out.println("keyword = " + keyword);

        boolean flag = memberService.checkDuplicateValue(type, keyword);

        return ResponseEntity.ok().body(flag);

    }

    @PostMapping("/sign-up")
    public String signUp(SignUpRequestDTO dto){

        System.out.println("/members/sign-up : POST");
        System.out.println("dto = " + dto);

        memberService.join(dto);

        return "redirect:/board/list";

    }



}
