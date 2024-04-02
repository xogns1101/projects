package com.spring.mvc.chap05.mapper;

import com.spring.mvc.chap05.common.Page;
import com.spring.mvc.chap05.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    
    // 댓글 등록
    void save(Reply reply);

    // 댓글 수정(내용 수정)
    void modify(Reply reply);

    // 댓글 삭제
    void delete(int replyNo);

    // 댓글 개별 조회
    Reply findOne(int replyNo);


    // 댓글 전체 목록 조회(페이징)
    // 마이바티스에서 맵퍼에 매개변수가 2개 이상일 때는 변수명으로 바로
    // 지목이 불가능하다
    // 1. 변수를 하나만 쓰기(전달하고자 하는 값이 여러게라면 객체로 한번에 포장해서 넘기기)
    // 2. Map으로 포장해서 넘기기 (Map의 Key가 지목하는 이름이 된다)
    // 3. @Param을 사용하여 직접 이름 붙히기
    List<Reply> findAll(@Param("boardNo") int boardNo
                        , @Param("p") Page page);

    // 댓글 총 개수 조회
    int count(int boardNo);
    
    
}
