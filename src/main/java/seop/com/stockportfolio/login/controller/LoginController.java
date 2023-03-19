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
import seop.com.stockportfolio.member.repository.MemberRepository;
import seop.com.stockportfolio.member.service.MemberService;
import seop.com.stockportfolio.stock.domain.entity.Stock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
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
    public ModelAndView loginRequest(String id, String password, HttpServletRequest request) {

        Member member = memberService.findOneById(id);

        if(member!=null && member.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("member", member);

            // 해당 멤버가 가지고 있는 stock이 있는지 확인
            Set<Stock> stocks = member.getStocks();
            if (stocks.isEmpty()) {
                // 주식 입력 페이지로 이동
                return new ModelAndView("redirect:/inputStock");
            } else {
                // 메인 페이지로 이동
                return new ModelAndView("redirect:/main");
            }

        } else {
            // 로그인 실패 시, 로그인 화면으로 이동하면서 실패 메시지 전달
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            return mav;
        }
    }

}
