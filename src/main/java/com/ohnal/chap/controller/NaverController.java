package com.ohnal.chap.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class NaverController {

    @Value("${sns.naver.client-id}")
    private String clientId;

    @Value("${sns.naver.client-secret}")
    private String clientSecret;

    @Value("${sns.naver.redirect-uri}")
    private String redirectUri;

    @Value("${sns.naver.state}")
    private String state;



    @GetMapping("/naver/login")
    private String naverLogin(){
        String  uri = "https://nid.naver.com/oauth2.0/authorize";
        uri += "?response_type=code";
        uri += "&client_id="+clientId;
        uri += "&state="+state;
        uri += "&redirect_uri="+redirectUri;

        log.info("url:{}", uri);
        return "redirect:"+uri;

    }


}
