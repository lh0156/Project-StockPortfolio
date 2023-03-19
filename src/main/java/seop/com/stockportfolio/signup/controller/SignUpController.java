package seop.com.stockportfolio.signup.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import seop.com.stockportfolio.member.domain.entity.Member;
import seop.com.stockportfolio.member.service.MemberService;
import seop.com.stockportfolio.signup.service.SignUpService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignUpController {

    private final MemberService memberService;
    private final SignUpService signUpService;

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public ModelAndView signUpRequest(String id,
                                      String name,
                                      String password,
                                      String passwordOk,
                                      String phoneNumber,
                                      Model model) {

        ModelAndView modelAndView = new ModelAndView();
        boolean isErrorFlag = false;

//        if(password.equals(passwordOk)) {
//            modelAndView.addObject("errorMessage_password", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
//            modelAndView.addObject("signUp");
//
//            isErrorFlag = true;
//        }
//
//        if (signUpService.isNotKorean(name) || name.length() >= 10) {
//            modelAndView.addObject("errorMessage_name", "이름에 한글 이외의 언어가 들어가거나 10자 이상입니다.");
//            modelAndView.addObject("signUp");
//
//            isErrorFlag = true;
//        }
//
//        if (signUpService.isNotPhoneNumber(phoneNumber)) {
//            modelAndView.addObject("errorMessage_phoneNumber", "전화번호가 유효하지 않습니다.");
//            modelAndView.addObject("signUp");
//
//            isErrorFlag = true;
//        }

        if (isErrorFlag) {
            return modelAndView;
        }

        memberService.save(new Member(id, name, password, phoneNumber));
        model.addAttribute("id", id);
        modelAndView.setViewName("signUpOk");
        return modelAndView;
    }

}
