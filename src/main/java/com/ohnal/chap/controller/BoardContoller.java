package com.ohnal.chap.controller;

import com.ohnal.chap.common.Search;
import com.ohnal.chap.dto.response.BoardListResponseDTO;
import com.ohnal.chap.entity.Board;
import com.ohnal.chap.common.Page;
import com.ohnal.chap.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardContoller {
    
    private final BoardService boardService;
    
    // 게시판 이동
    @GetMapping("/list")
    public String boardList(Model model, @ModelAttribute("s") Search page) {
        log.info("/board/list 요청 들어옴: GET!, search= {}", page);
        List<BoardListResponseDTO> boardList = boardService.getList(page);
        
        model.addAttribute("bList", boardList);
        
        return "/chap/list";
    }
    
}
