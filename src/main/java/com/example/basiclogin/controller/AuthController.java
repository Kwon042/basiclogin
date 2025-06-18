package com.example.basiclogin.controller;

import com.example.basiclogin.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    // session 기준임
    @PostMapping("/withdraw")
    public String withdraw(@SessionAttribute(name = "memberId", required = false) Long memberId,
                           HttpServletRequest request) {
        if (memberId != null) {
            memberService.withdraw(memberId);
            request.getSession().invalidate();  // 세션 제거 (자동 로그아웃)
        }
        return "redirect:/session-login";
    }
}
