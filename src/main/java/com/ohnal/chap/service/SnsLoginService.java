package com.ohnal.chap.service;

import com.ohnal.chap.dto.request.SignUpRequestDTO;
import com.ohnal.chap.dto.response.KakaoUserResponseDTO;
import com.ohnal.chap.entity.Member;
import com.ohnal.chap.mapper.MemberMapper;
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
public class SnsLoginService {
    private final MemberService memberService;
    public void kakaoLogin(Map<String, String> params) {

        String accessToken = getKakaoAccessToken(params);

        KakaoUserResponseDTO kakaoUserDTO = getKakaoUserInfo(accessToken);

        String email = kakaoUserDTO.getAccount().getEmail();

        if (memberService.checkDuplicateValue("email",email)) {
            memberService.join(
                    SignUpRequestDTO.builder()
                            .email(email)
                            .password("0000")
                            .name(kakaoUserDTO.getProperties().getNickname())
                            .loginMethod(Member.LoginMethod.KAKAO)
                            .build(),
                    kakaoUserDTO.getProperties().getProfileImage()
            );
        }

        //
        //로그인 처리 메서드생성해야함
        //

    }

    private KakaoUserResponseDTO getKakaoUserInfo(String accessToken) {
        String requestUri = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization" , "Bearer "+accessToken);
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        RestTemplate template = new RestTemplate();
        ResponseEntity<KakaoUserResponseDTO> responseEntity = template.exchange(
                requestUri, HttpMethod.POST, new HttpEntity<>(headers), KakaoUserResponseDTO.class
        );
        KakaoUserResponseDTO responseJSON = responseEntity.getBody();


        return responseJSON;

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

        HttpEntity<Object> requestEntity = new HttpEntity<>(params, headers);

        ResponseEntity<Map> responseEntity
                = template.exchange(requestUri, HttpMethod.POST, requestEntity, Map.class);


        Map<String, Object> responseJSON = (Map<String, Object>) responseEntity.getBody();
        log.info("응답 JSON 데이터: {}", responseJSON);

        String accessToken = (String) responseJSON.get("access_token");
        return accessToken;

    }
}
