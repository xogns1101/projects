package com.spring.mvc.chap05.mapper;

import com.spring.mvc.chap05.common.Page;
import com.spring.mvc.chap05.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 마이바티스의  SQL 실행을 위한 인터페이스임을 명시
@Mapper
public interface BoardMapper {

    // 목록조회 (List<Board>)
    List<Board> findAll(Page page);

    // 게시글 상세 조회 (Board)
    Board findOne(int boardNo);

    // 게시글 동록 (매개변수 전달 받음 해당 entity)
    void save(Board board);

    // 게시글 삭제 (매개변수로 해당 primary key 를 받음)
    void delete(int boardNo);

    // 조회수처리
    void updateViewCount(int bno);

    // 총 게시물의 개수 리턴
    int getCount();


    // 게시글 수정


















}
