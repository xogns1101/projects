package com.spring.mvc.chap01;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ControllerV1 {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

//    @RequestMapping(value = "/food", method = RequestMethod.GET)
    @GetMapping("/food")
   // @ResponseBody
    public String showFood(){
        //System.out.println("Controller V1 이 생성됨");
        System.out.println("get 요청이 들어옴");
        return "chap01/food";
    }
    
    // ================ 요청 파라미터 읽기(클라이언트가 보낸 데이터) ================================
    // 1.HttpServletRequest 객체 이용하기 -> 전통적 방싣

//    @RequestMapping(value = "/food", method = RequestMethod.POST)
//    @PostMapping("/food")
//    public String foodCategory(HttpServletRequest request){
//
//        String name = request.getParameter("foodName");
//        String category = request.getParameter("category");
//
//        System.out.println("name = " + name);
//        System.out.println("category = " + category);
//
//        return  "chap01/food";
//    }

   // 2. @RequestParam 사용
    // 파라미터 변수명과 매개변수명을 동일하게 맞추면 @RequestParam을 생략 할 수 있음
//   @PostMapping("/food")
//   public String foods(@RequestParam("foodName") String foodName
//                    , @RequestParam("category") String category
//                    , @RequestParam("price") int price){
//
//       System.out.println("foodName = " + foodName);
//       System.out.println("category = " + category);
//       System.out.println("price = " + price);
//
//        return "chap01/food";
//   }



    // 3. DTO (Data Transfer Object) 객체 사용 -> 커맨드 객체를 활용한 파라미터 처리
    // 처리해야 할 파라미터 양이 많거나, 서로 연관되어 있는 데이터인 경우 사용

    @PostMapping("/food")
    public String food(FoodOrderDTO orderDTO){

        System.out.println("orderDTO = " + orderDTO);

        return "chap01/food";
    }


   


}
