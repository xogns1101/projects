package com.spring.mvc.chap02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/model") // 공통 url 맵핑
public class ControllerV2 {

    /*
    /model/hobbies : GET
    -> hobbies.jsp파일로 사용자 이름정보와 취미목록을 뿌려주고 싶다.
    == 1. Model 객체 사용
    -> 자바가 갖고 있는 데이터를 JSP로 넘겨줄 때 사용하는 바구니같은 역할
    */

//    @GetMapping("/hobbies")
//    public String hobbies(Model model){
//
//        System.out.println(" /model/hobbies  : GET 요청!");
//
//        String name = "짹짹이";
//        List<String> hobbyList = new ArrayList<>();
//
//        Collections.addAll(hobbyList, "전깃줄 앉아있기", "좁쌀 훔쳐먹기", "짹쨱거리기", "멍때리기");
//        // Model 객체에 값 담기
//        model.addAttribute("userName", name);
//        model.addAttribute("hobbies", hobbyList);
//
//        return "chap02/hobbies";
//    }


//    @GetMapping("hobbies")
//    public String musics(Model model){
//        List<String> musicRanking = new ArrayList<>();
//        musicRanking.add("강남스타일");
//        musicRanking.add("벚꽃엔딩");
//        musicRanking.add("좋은날");
//        musicRanking.add("거짓말");
//        musicRanking.add("보고싶다");
//
//        model.addAttribute("music", musicRanking);
//
//        return "chap02/hobbies";
//
//    }

//    @GetMapping("hobbies")
//    public String membershipList(Model model){
//
//        List<Map<String, Object>> membership = new ArrayList<>();
//
//        Map<String, Object> member = new HashMap<>();
//        member.put("name", "손오공");
//        member.put("phoneNumber", "010-1234-5678");
//        member.put("grade", "VIP");
//        member.put("point", 12040);
//        membership.add(member);
//
//        member = new HashMap<>();
//        member.put("name", "저팔계");
//        member.put("phoneNumber", "010-4321-1234");
//        member.put("grade", "BASIC");
//        member.put("point", 3420);
//        membership.add(member);
//
//        member = new HashMap<>();
//        member.put("name", "사오정");
//        member.put("phoneNumber", "010-8888-1111");
//        member.put("grade", "GOLD");
//        member.put("point", 1530);
//        membership.add(member);
//
//        member = new HashMap<>();
//        member.put("name", "삼장");
//        member.put("phoneNumber", "010-0000-1234");
//        member.put("grade", "GOLD");
//        member.put("point", 8450);
//        membership.add(member);
//
//        member = new HashMap<>();
//        member.put("name", "우마왕");
//        member.put("phoneNumber", "010-1111-2222");
//        member.put("grade", "BASIC");
//        member.put("point", 420);
//        membership.add(member);
//
//        model.addAttribute("membership", membership);
//
//        return "chap02/hobbies";
//
//    }


    @GetMapping("hobbies")
    public String candidatesList(Model model){

        List<Integer> candidates = new ArrayList<>();
        candidates.add(263001);
        candidates.add(173942);
        candidates.add(563057);

        model.addAttribute("candidates", candidates);

        return "chap02/hobbies";

    }











}
