package com.ohnal.chap.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private String email;
    private String password;
    private String nickname;
    private String address;
    private String gender;
    private String profileImage;
    private LoginMethod loginMethod;
    private LocalDateTime regDate;
    private String Auth;
    private String session_id;
    private LocalDateTime limitTime;

    public enum LoginMethod{
        COMMON,KAKAO
    }

}