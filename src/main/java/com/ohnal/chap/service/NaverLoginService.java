package com.ohnal.chap.service;

import com.ohnal.chap.controller.NaverController;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
@Getter

public class NaverLoginService {
    private final NaverController naverController;

    public void naverLogin(Map<String, String> naverParams , HttpSession session) {

        String accessToken = getNaverToken(naverParams);
        session.setAttribute("access_token",accessToken);


    }

    public String getNaverToken(Map<String, String> naverParams) {
        String getTokenUri = "https://nid.naver.com/oauth2.0/token";

        MultiValueMap<String ,String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("grant_type" , "authorization_code");
        tokenParams.add("client_id",naverParams.get("clientId"));
        tokenParams.add("client_secret",naverParams.get("clientSecret"));
        tokenParams.add("code",naverParams.get("code"));
        tokenParams.add("state",naverParams.get("state"));
        log.info("tokenParams :",tokenParams);

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Object> requestEntity = new HttpEntity<>(naverParams, headers);
        ResponseEntity<Map> responseEntity
                = template.exchange(getTokenUri, HttpMethod.POST, requestEntity, Map.class);

        Map<String, Object> responseJSON = (Map<String, Object>) responseEntity.getBody();
        log.info("응답 JSON 데이터: {}", responseJSON);

        String accessToken = (String) responseJSON.get("access_token");

        return accessToken;


    }
}



