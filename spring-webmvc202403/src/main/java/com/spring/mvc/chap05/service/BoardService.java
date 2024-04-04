package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.common.Search;
import com.spring.mvc.chap05.dto.response.BoardDetailResponseDTO;
import com.spring.mvc.chap05.dto.response.BoardResponseDTO;
import com.spring.mvc.chap05.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.mapper.BoardMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

  //  private final BoardRepository repository;

    private final BoardMapper mapper; // mybatis가 우리가 만든 xml을 클래스로 변환해서 객체를 주입해 줌


    public void insertBoard(BoardWriteRequestDTO dto, HttpSession session) {

        Board board = new Board(dto);

        mapper.save(board);

    }

    // repository 로부터 전달 받은 entitu list 를 DTO list를 컨트롤러에게 반환
    public List<BoardResponseDTO> getList(Search page) {

        List<BoardResponseDTO> dtoList = new ArrayList<>();
        List<Board> boardList = mapper.findAll(page);

        for (Board board : boardList) {

            BoardResponseDTO dto = new BoardResponseDTO(board);
            dtoList.add(dto);

        }

        return dtoList;

    }

    public BoardDetailResponseDTO getDetail(int bno) {

        // 상세보기니까 조회수를 하나 올려주는 처리를 해야 한다
        mapper.updateViewCount(bno);

        Board board = mapper.findOne(bno);

        return new BoardDetailResponseDTO(board);


    }

    public void delete(int bno) {

        mapper.delete(bno);

    }

    public int getCount(Search page) {

        return mapper.getCount(page);

    }


}
