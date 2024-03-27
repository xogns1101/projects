package com.spring.mvc.chap04.controller;

/*
    # 컨트롤러
    - 클라이언트의 요청을 받아서 처리하고 응답을 제공하는 객체

    # 요청 URL Endpoint
    1. 학생의 성적정보 등록폼 화면을 보여주고
       동시에 지금까지 저장되어 있는 성적 정보 목록을 조회
    - /score/list   :   GET

    2. 학생의 입력된 성적정보를 데이터베이스에 저장하는 요청
    - /score/register   :  POST

    3. 성적정보를 삭제 요청
    - /score/remove    :  GET or POST

    4. 성적정보 상세 조회 요청
    - /score/detail  :   GET
 */

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.dto.ScoreResponseDTO;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/score")
@RequiredArgsConstructor // fonal이 붙은 필드를 초기화하는 생성자를 선언
public class ScoreController {
    
    // DB에 데이터를 저장하기 위해 컨트롤러는 서비스가  꼭 필요하다(의존관계)
    // 의존 객체는 불변성을 띠게 작성하는 것이 좋다 -> RequiredArgsConstructor로 초기화 진행
    private final ScoreService service;

    // FM 방식으로 처리 -> 롬복으로 대체, 생성자가 단 하나라면 @Autowired를 생략할 수 있음
//    @Autowired
//    public ScoreController(ScoreService service) {
//        this.service = service;
//    }

    // 성적 목록 조화
    @GetMapping("/list")
    public String list(Model model
            , @RequestParam(value = "sort", defaultValue = "num") String sort){

        List<ScoreResponseDTO> srdto = service.findAll(sort);

        model.addAttribute("scoreList", srdto);

        return "chap04/score-list";

    }

    @PostMapping("/register")
    public String scoreRegister(ScoreRequestDTO dto
            , Model model){

        System.out.println("dto = " + dto);

        service.insertScore(dto);

        // 등록이 완료되었다면 목록 화면으로 데이터를 전달해서
        // 목록 화면을 보여주고 싶다

        /*
            # forward vs redirect
            - 포워드는 요청 리소스를 그대로 전달해줌.
            - 따라서 URL이 변경되지 않고 한번의요청과 한번의 응답만 이뤄짐
            - forward 할 때는 포워딩할 파일의 경로를 적는다(/views/chap04/score-list.jsp)

            - 리다이렉트는 요청후에 자동응답이 나가고
              2번째 자동요청이 들어오면서 2번째 응답을 내보냄
            - 따라서 2번째 요청의 URL로 자동 변경됨
            - redirect 할 때는 다시 들어왔으면 하는 요청 url 을 적는 것 (/score/list -> 목록 요청)
         */

        return "redirect:/score/list";
    }


    // 삭제
    @PostMapping("/remove")
    public String scoreRemove(int stuNum){

        System.out.println("stuNum = " + stuNum);

        service.remove(stuNum);

        return "redirect:/score/list";
    }

    // 성적 상세 조회 요청
    @GetMapping("/detail")
    public String scoreDetail(int stuNum
                    , Model model){
        
        // chap04/score-detail.jsp
        // 상세보기 이기 때문에 DTO가 아닌 Entity를 담아서 jsp 로 보내기
//        Score score = service.detail(stuNum);
//
//        model.addAttribute("detail", score);

        // 메서드 호출
        retrieve(stuNum, model);

        return "chap04/score-detail";
    }

    // 수정페이지로 이동 요청
    @GetMapping("/modify")
    public String scoreModify(int stuNum, Model model){
        System.out.println("/score/modify : GET!");

        retrieve(stuNum, model);

        return "chap04/score-modify";
    }

    @PostMapping("/modify")
    public String scoreModify(ScoreRequestDTO dto
                        , int stuNum){

        // 서비스 , 레파지토리 계층과 연계하여 update 처리 진행
        // 수정이 완료된 후 사용자에게 응답할 페이지는 
        // 최신 수정 내용이 완료된 detail 페이지로 이동 - redirect

        service.update(dto, stuNum);


        return "redirect:/score/detail?stuNum=" + stuNum;


    }



    private void retrieve(int stuNum, Model model) {
        Score score = service.detail(stuNum);
        model.addAttribute("detail", score);
    }







}
