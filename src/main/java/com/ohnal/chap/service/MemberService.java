package com.ohnal.chap.service;

import com.ohnal.chap.dto.LoginRequestDTO;
import com.ohnal.chap.dto.request.SignUpRequestDTO;
import com.ohnal.chap.dto.response.LoginUserResponseDTO;
import com.ohnal.chap.entity.Member;
import com.ohnal.chap.mapper.MemberMapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ohnal.util.LoginUtils.LOGIN_KEY;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;

    public void join(SignUpRequestDTO dto, String savePath) {
        memberMapper.save(dto.toEntity(encoder, savePath));
    }


    public boolean checkDuplicateValue(String type, String keyword) {
        return memberMapper.isDuplicate(type, keyword);
    }



    public LoginResult authenticate(LoginRequestDTO dto,
                                    HttpSession session , HttpServletResponse response) {

        Member foundMember = memberMapper.findMember(dto.getAddress());
        if (foundMember == null) {
            return LoginResult.NO_ACC;
        }
        String inputPassword = dto.getPassword();
        String realPassword = foundMember.getPassword();

        if (!encoder.matches(inputPassword,realPassword)) {
             return  LoginResult.NO_PW;
        }
          return LoginResult.SUCCESS;
    }
    public void maintainLoginState(HttpSession session, String account) {
        Member foundMember = memberMapper.findMember(account);
        LoginUserResponseDTO dto = LoginUserResponseDTO.builder()
                .account(foundMember.getEmail())
                .name(foundMember.getName())
                .email(foundMember.getEmail())
                .auth(foundMember.getAuth())
                .profile(foundMember.getProfileImage())
                .loginMethod(foundMember.getLoginMethod().toString())
                .build();
        session.setAttribute(LOGIN_KEY , dto);
        session.setMaxInactiveInterval(60 * 60);
    }
}
