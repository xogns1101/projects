package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.dto.request.LoginRequestDTO;
import com.spring.mvc.chap05.dto.request.SignUpRequestDTO;
import com.spring.mvc.chap05.service.LoginResult;
import com.spring.mvc.chap05.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // 로그인 양식 화면 요청
    @GetMapping("/sign-in")
    public void signInView(){

        System.out.println("/members/sign-in : GET");

    }

    // 로그인 검증 요청
    @PostMapping("/sign-in")
    public String signIn(LoginRequestDTO dto
                         // Model 에 담긴 데이터는 리다이렉트 시 jsp 로 전달되지 못한다
                         // 리다이렉트는 응답이 나갔다가 재요청이 들어오는데, 그 과정에서
                         // 첫번째 응답이 나가는 순간 모델은 소멸함.
                         //(Model 의 생명주기는 한 번의 요청과 응답 사이에서만 유효)
                , RedirectAttributes ra
                , HttpServletResponse response){

        
        System.out.println("/members/sign-in : POST");
        System.out.println("dto = " + dto);

        LoginResult result = memberService.authenticate(dto);
        // 확인 용도
        System.out.println("result = " + result);

        ra.addFlashAttribute("result", result);
        
        if(result == LoginResult.SUCCESS){ // 로그인 성공

            // 로그인을 했다는 정보를 계속 유지하기 위한 수단으로 쿠키 사용
            mekeLoginCookie(dto, response);

            return "redirect:/board/list";
        }
        
        return  "redirect:/members/sign-in"; // 로그인 실패시


    }

    private void mekeLoginCookie(LoginRequestDTO dto, HttpServletResponse response) {

        // 쿠키에 로그인 기록을 저장
        // 쿠키 객체를 생성 -> 생성자의 매개값으로 쿠키의 이름과 저장할 값을 전달
        // (문자열만 저장됨. 용량의 한계도 있음)
        Cookie cookie = new Cookie("login", dto.getAccount());
        
        // 쿠키 세부 설정
        cookie.setMaxAge(60); // 쿠키 수명 설정(초)
        cookie.setPath("/"); // 이 쿠키는 모든 경로에서 유효함

        // 쿠키가 완성됬다면 응답 객체에 쿠키를 태워서 클라이언트로 전송
        response.addCookie(cookie);



    }


}
