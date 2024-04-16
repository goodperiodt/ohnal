package com.ohnal.chap.controller;

import com.ohnal.chap.dto.request.SignUpRequestDTO;
import com.ohnal.chap.entity.Member;
import com.ohnal.chap.service.MemberService;
import com.ohnal.util.FileUtils;
import com.ohnal.util.MailSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    @Value("${file.upload.root-path}")
    private String rootPath;


    private final MemberService memberService;
    private final MailSendService mailSendService;

    @GetMapping("/sign-up")
    public void signUp() {
        log.info("/members/sign-up: GET");
    }

    @GetMapping("/check/{type}/{keyword}")
    @ResponseBody
    public ResponseEntity<?> check(@PathVariable String type,
                                   @PathVariable String keyword) {
        log.info("/members/check: async GET");
        log.debug("type: {}, keyword: {}", type, keyword);

        boolean flag = memberService.checkDuplicateValue(type, keyword);

        return ResponseEntity.ok().body(flag);
    }
@PostMapping("/sign-up")
public String signUp(SignUpRequestDTO dto){
    String savePath = FileUtils.uploadFile(dto.getProfileImage(), rootPath);
    log.info("save-path: {}", savePath);

    // 일반 방식(우리사이트를 통해)으로 회원가입
    dto.setLoginMethod(Member.LoginMethod.COMMON);

    memberService.join(dto, savePath);
    return "redirect:/index";
}


}
