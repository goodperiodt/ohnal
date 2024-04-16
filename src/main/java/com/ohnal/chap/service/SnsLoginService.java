package com.ohnal.chap.service;

import lombok.*;
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
public class SnsLoginService {
    public void kakaoLogin(Map<String, String> params) {
        String accessToken = getKakaoAccessToken(params);
    }
    private String getKakaoAccessToken(Map<String , String> requestParam) {
        String requestUri = "https://kauth.kakao.com/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id" , requestParam.get("appKey"));
        params.add("redirect_uri" , requestParam.get("redirect"));
        params.add("code", requestParam.get("code"));

        RestTemplate template = new RestTemplate();

       HttpEntity<Object> requestEntity = new HttpEntity<>(params,headers);

        ResponseEntity<Map> responseEntity = template.exchange(requestUri,
                HttpMethod.POST,
                requestEntity,
                Map.class);

        Map<String, Object> responseJSON = (Map<String, Object>) responseEntity.getBody();

        String accessToken = (String) responseJSON.get("access_token");


        return accessToken;


    }
}
