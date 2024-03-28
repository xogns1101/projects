package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

// 게시판 CRUD 기능 명세
@Repository
public interface BoardRepository {
    
    // 목록조회 (List<Board>)
    List<Board> findAll();

    // 게시글 상세 조회 (Board)
    Board findOne(int boardNo);

    // 게시글 동록 (매개변수 전달 받음 해당 entity)
    void save(Board board);

    // 게시글 삭제 (매개변수로 해당 primary key 를 받음)
    void delete(int boardNo);

    // 조회수처리
    void updateViewCount(int bno);


    // 게시글 수정
    
    
    
}
