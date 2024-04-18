package com.ohnal.chap.service;

import com.ohnal.chap.controller.NaverController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
@Getter

public class NaverLoginService {
    private final NaverController naverController;

    public void naverLogin(Map<String, String> naverParams) {
        String accessToken = getNaverToken(naverParams);
    }

    public String getNaverToken(Map<String, String> naverParams) {
        String getTokenUri = "https://nid.naver.com/oauth2.0/token";

        MultiValueMap<String ,String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("grant_type" , "authorization_code");
        tokenParams.add("client_id",naverParams.get(clientId));



    }
}



