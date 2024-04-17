package com.ohnal.chap.controller;

import com.ohnal.chap.dto.LoginRequestDTO;
import com.ohnal.chap.service.LoginResult;
import com.ohnal.chap.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    @Value("${file.upload.root-path}")
    private String rootPath;

    private final MemberService memberService;
/////////////////////////////////////////////////////////////////////////////////////////////////


    @PostMapping("/sign-in")
    public String signIn(LoginRequestDTO dto,
                         RedirectAttributes ra,
                         HttpServletResponse response,
                         HttpServletRequest request
    ) {
        log.info("/members/sign-in: POST!, dto: {}", dto);


        LoginResult result = memberService.authenticate(dto, request.getSession(), response);
        log.info("result: {}", result);

        ra.addFlashAttribute("result", result);

        if (result == LoginResult.SUCCESS) {


            memberService.maintainLoginState(request.getSession(), dto.getAddress());

            return "redirect:/index";
        }

        return "redirect:/sign-in";

    }
    private void makeLoginCookie(LoginRequestDTO dto, HttpServletResponse response) {
        Cookie cookie = new Cookie("Login", dto.getAddress());

        cookie.setMaxAge(100);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


}