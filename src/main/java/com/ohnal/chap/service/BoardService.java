package com.ohnal.chap.service;

import com.ohnal.chap.common.Search;
import com.ohnal.chap.dto.response.BoardListResponseDTO;
import com.ohnal.chap.entity.Board;
import com.ohnal.chap.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    
    private final BoardMapper boardMapper;
    
    // 게시물 불러오기
    public List<BoardListResponseDTO> getList(Search page) {
        List<BoardListResponseDTO> dtoList = new ArrayList<>();
        List<Board> boardList = boardMapper.findAll(page);
        for (Board board : boardList) {
            BoardListResponseDTO dto = new BoardListResponseDTO(board);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
}
