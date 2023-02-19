package seop.com.stockportfolio.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import seop.com.stockportfolio.login.service.LoginService;
import seop.com.stockportfolio.member.domain.entity.Member;
import seop.com.stockportfolio.member.service.MemberService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginRequest(Member member) {
        log.info("id: {}", member.getId());
        log.info("password: {}", member.getPassword());
        log.info("phoneNumber: {}", member.getPhoneNumber());

        return "redirect:/login";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public ModelAndView signUpRequest(String name, String password, String phoneNumber, String passwordOk) {

        ModelAndView modelAndView = new ModelAndView();

        boolean isErrorFlag = false;

        if(!password.equals(passwordOk)) {
            modelAndView.addObject("errorMessage_password", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            modelAndView.addObject("signUp");

            isErrorFlag = true;
        }

        if (loginService.isNotKorean(name) || name.length() >= 10) {
            modelAndView.addObject("errorMessage_name", "이름에 한글 이외의 언어가 들어가거나 10자 이상입니다.");
            modelAndView.addObject("signUp");

            isErrorFlag = true;
        }

        if (loginService.isNotPhoneNumber(phoneNumber)) {
            modelAndView.addObject("errorMessage_phoneNumber", "전화번호가 유효하지 않습니다.");
            modelAndView.addObject("signUp");

            isErrorFlag = true;
        }

        if (isErrorFlag) {
            return modelAndView;
        }

        memberService.save(new Member(name, password, phoneNumber));
        modelAndView.setViewName("login");

        return modelAndView;
    }

}
