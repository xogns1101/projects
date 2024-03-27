package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.dto.BoardResponseDTO;
import com.spring.mvc.chap05.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.chap05.dto.response.BoardListResponseDTO;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;



    public void insertBoard(BoardWriteRequestDTO dto) {

        Board board = new Board(dto);

        repository.save(board);

    }

    // repository 로부터 전달 받은 entitu list 를 DTO list를 컨트롤러에게 반환
    public List<BoardResponseDTO> getList() {

        List<BoardResponseDTO> dtoList = new ArrayList<>();
        List<Board> boardList = repository.findAll();

        for (Board board : boardList) {

            BoardResponseDTO dto = new BoardResponseDTO(board);
            dtoList.add(dto);

        }
        return dtoList;





    }
}
