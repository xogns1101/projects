package com.spring.mvc.chap05.mapper;

import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ReplyMapperTest {

    // 게시글
    @Autowired
    BoardMapper boardMapper;

    // 게시글의 댓글
    @Autowired
    ReplyMapper replyMapper;

    @Test
    @DisplayName("게시물 100개 등록, 랜덤으로 1000개의 댓글을 게시글에 등록한다")
    void bulkInsertTest() {
        // given

        // when
        // 게시물 100개 등록
        for (int i = 1; i <= 100; i++) {
            Board b = Board.builder()
                        .title("재밌는 글 " + i)
                        .content("재밌는 내용 " + i)
                        .writer("재밌는 사람 " + i)
                        .build();
            boardMapper.save(b);
        }

        // 랜덤 댓글 1000개 등록
        for (int i = 1; i <= 1000 ; i++) {

            Reply r = Reply.builder()
                    .replyText("하하호호히히" + i)
                    .replyWriter("잼맨이" + i)
                    .boardNo((int) (Math.random() * 100) + 1)
                    .build();

            replyMapper.save(r);
        }
        // then
    }

    @Test
    @DisplayName("77번 게시물의 댓글 목록을 조회 했을 때 결과 리스트의 사이즈는 n이여야 한다")
    void findAllTest() {
        // 77번 게시물 찾기
        // given
        int boardNo = 77;
        // 77번 게시물의 모든 댓글 찾기
        // when
//        List<Reply> replyList = replyMapper.findAll(boardNo, p);
        // 댓글의 갯수가 7인것을 단언하기
        // then
//        assertEquals(7, replyList.size());
//
    }
    
    @Test
    @DisplayName("77번 게시물의 댓글 중 n번 댓글을 삭제 하면 n번 댓글은 조회되지 않을 것이고 , 77번을 전체 조회하면 리스트 사이즈는 " +
            "하나 줄어있어야함")
    void deleteTest() {
        
        // given
        // 77번 게시물
        int boardNo = 77;
        // 116번의 댓글 번호
        int replyNo = 116;
        // when
        // 77번의 게시믈의 116번 댓글 지우기
        replyMapper.delete(replyNo);
        Reply reply = replyMapper.findOne(replyNo);

        // then
        // 지워 졌으니 null 단언
        assertNull(reply);

        assertEquals(7, replyMapper.count(boardNo));
    }

   @Test
   @DisplayName("103번 댓글의 댓글 내용을 수정하면 다시 조회 했을때 수정될" +
           "내용이 조회되어야 한다")
   void modify() {
       // given
       int replyNo = 103;
       String updateText  = "수정을 해보았다";
       //  build 사용하기
       Reply reply = Reply.builder()
               .replyText(updateText)
               .replyNo(replyNo)
               .build();
       // when
        replyMapper.modify(reply);
       Reply foundRelpy = replyMapper.findOne(replyNo);
       // then
       assertEquals(updateText, foundRelpy.getReplyText());
       
   }
    
    
    
}

