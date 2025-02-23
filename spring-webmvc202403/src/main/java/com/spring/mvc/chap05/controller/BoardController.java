package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.common.Page;
import com.spring.mvc.chap05.common.PageMaker;
import com.spring.mvc.chap05.common.Search;
import com.spring.mvc.chap05.dto.response.BoardDetailResponseDTO;
import com.spring.mvc.chap05.dto.response.BoardResponseDTO;
import com.spring.mvc.chap05.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.chap05.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    // 1. 목록 조회 요청 (/board/list : GET)
    // chap05/list.jsp
    @GetMapping("/list")
    public String list(Model model
                    , @ModelAttribute("s") Search page){

        System.out.println("search = " + page);

        List<BoardResponseDTO> dtoList = service.getList(page);

        // 페이징 버튼 알고리즘 적용 -> 사용자가 요청한 페이지 정보, 총 게시물 개수를 전달
        // 페이징 알고리즘 자동 호출
        PageMaker pageMaker = new PageMaker(page, service.getCount(page));

        // model에 글 목록 뿐만 아니라 페이지 버튼 정보도 같이 담아서 전달 하자
        model.addAttribute("bList", dtoList);
        model.addAttribute("maker", pageMaker);
        
        // 메서드의 파라미터값을 model 객체에 바로 추가하고 싶다면
        // @ModelAttribute 를 사용
        // model.addAttribute("s", page);

        return "chap05/list";

    }


    // 2. 글쓰기 화면요청 (/board/write : GET)
    // chap05/write.jsp 이동
    @GetMapping("/write")
    public String write(){

        return "chap05/write";
    }

    // 3. 글쓰기 등록요청 (/board/write : POST)
    // BoardWriteRequesDTO 을 활용하여 파라미터 처리 -> dto.request 패키지 생성
    // 등록 완료 후에는 목록 조회 요청이 다시 들어오게끔 처리
    @PostMapping("/write")
    public String write(BoardWriteRequestDTO dto
                    , HttpSession session){

        service.insertBoard(dto, session);


        return "redirect:/board/list";
    }


    // 4. 글 삭제 요청 (/board/delete : GET)
    // 글번호 전달 되면 삭제 진행
    @GetMapping("/delete")
    public String delete(int bno){

        System.out.println("/board/delete : GET" + bno);

        service.delete(bno);

        return "redirect:/board/list";
    }


    
    // 5. 글 상세보기 요청 (/board/detail : GET)
    // 글번호 전달되면 해당 내용 상세보기 처리
    // chap05/detail.jsp
    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable("bno") int bno
                    , @ModelAttribute("s") Search search
                    , Model model){

        System.out.println("/board/detail : GET!" + bno);

        BoardDetailResponseDTO detail = service.getDetail(bno);

        model.addAttribute("b", detail);

        return "chap05/detail";
    }







}
