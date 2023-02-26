package seop.com.stockportfolio.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import seop.com.stockportfolio.login.service.LoginService;
import seop.com.stockportfolio.member.domain.dto.request.MemberParam;
import seop.com.stockportfolio.member.domain.entity.Member;
import seop.com.stockportfolio.member.service.MemberService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginRequest(String id, String password, String phoneNumber) {

        log.info("id: {}", id);
        log.info("password: {}", password);
        log.info("phoneNumber: {}", phoneNumber);


        return "redirect:/login";
    }

}
