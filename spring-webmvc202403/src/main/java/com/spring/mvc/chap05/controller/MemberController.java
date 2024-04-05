package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.dto.request.LoginRequestDTO;
import com.spring.mvc.chap05.dto.request.SignUpRequestDTO;
import com.spring.mvc.chap05.service.LoginResult;
import com.spring.mvc.chap05.service.MemberService;
import com.spring.mvc.util.LoginUtils;
import com.spring.mvc.util.upload.FileUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.spring.mvc.util.LoginUtils.isAutoLogin;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // properties 파일에 작성한 값을 가져오는 아노테이션
    @Value("${file.upload.root-path}")
    private String rootPath;

    // 회원 가입 양식 화면 요청
    // 응답하고자 하는 화면의 경로가 url 과 동일하다면 void 로 처리가
    // 가능하다!(선택사항)
    @GetMapping("/sign-up")
    public void signupView(){

        log.info("/members/sign-up : GET");

    }

    // 아이디, 이메일 중복체크 비동기 요청 처리
    @GetMapping("/check/{type}/{keyword}")
    @ResponseBody
    public ResponseEntity<?> check(@PathVariable String type
                            , @PathVariable String keyword){

        log.info("/members/check : async GET");
        log.debug("type : {}, keyword : {}", type, keyword);

        boolean flag = memberService.checkDuplicateValue(type, keyword);

        return ResponseEntity.ok().body(flag);

    }

    @PostMapping("/sign-up")
    public String signUp(SignUpRequestDTO dto){

        log.info("/members/sign-up : POST, dto : {}", dto);
        log.info("attached file name : {}", dto.getProfileImage().getOriginalFilename());

        // 서버에 파일 업로드 지시
        String savePath = FileUtils.uploadFile(dto.getProfileImage(), rootPath);

        log.info("save-path : {}", savePath);

        memberService.join(dto, savePath);

        return "redirect:/board/list";

    }

    // 로그인 양식 화면 요청
    @GetMapping("/sign-in")
    public void signInView(){

        log.info("/members/sign-in : GET");

    }

    // 로그인 검증 요청
    @PostMapping("/sign-in")
    public String signIn(LoginRequestDTO dto
                         // Model 에 담긴 데이터는 리다이렉트 시 jsp 로 전달되지 못한다
                         // 리다이렉트는 응답이 나갔다가 재요청이 들어오는데, 그 과정에서
                         // 첫번째 응답이 나가는 순간 모델은 소멸함.
                         //(Model 의 생명주기는 한 번의 요청과 응답 사이에서만 유효)
                , RedirectAttributes ra
                , HttpServletResponse response
                , HttpServletRequest request){

        
        log.info("/members/sign-in : POST, dto : {}", dto);

        // 자동 로그인 서비스를 추가 하기 위해 세션과 응답객체도 함께 전달
        LoginResult result = memberService.authenticate(dto, request.getSession(), response);
        // 확인 용도
        log.info("result = {}", result);

        ra.addFlashAttribute("result", result);
        
        if(result == LoginResult.SUCCESS){ // 로그인 성공

            // 로그인을 했다는 정보를 계속 유지하기 위한 수단으로 쿠키 사용
//            mekeLoginCookie(dto, response);

            // 세션으로 로그인 유지
            memberService.maintainLoginState(request.getSession(), dto.getAccount());


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

    // 로그 아윳 처리
    @GetMapping("/sign-out")
    public String signOut(HttpSession session
                    , HttpServletRequest request
                    , HttpServletResponse response){

        log.info("/members/sign-out : GET");

        // 자동 로그인 중인지 확인
        if(isAutoLogin(request)){
            // 쿠키를 삭제해주고 DB 데이터도 원래대로 돌려놔야 한다
            memberService.autoLoginClear(request, response);
        }

        // 세션에서 로그인 정보 기록 삭제
        session.removeAttribute("login");
        
        // 세션 전체 무효화(초기화)
        session.invalidate();

        return "redirect:/members/sign-in";
        
    }








}
