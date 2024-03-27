package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreRepositoryImplTest {

    @Autowired
    ScoreRepositoryImpl repository;

    @Test
    @DisplayName("새로운 성적 정보를 save를 통해 추가한다")
    void saveTest(){

        ScoreRequestDTO dto = new ScoreRequestDTO("박영희", 99, 98, 100);

        Score score =new Score(dto);

        boolean flag = repository.save(score);

        assertTrue(flag);

    }

    @Test
    @DisplayName("tbl_score의 모든 학생 목록을 조회 했을때 학생의 수는 4명일 것이다")
    void findAllTest() {
//        // given
//
//        // when
//        List<Score> scoreList = repository.findAll(sort);
//
//        System.out.println("scoreList = " + scoreList);
//
//        // then
//        assertEquals(3, scoreList.size());
    }

    @Test
    @DisplayName("3번학생의 이름은 박영희일 것이다")
    void findOneTest() {
        // given
        int stuNum = 3;

        // when
        Score score = repository.findOne(stuNum);
        // then
        assertEquals("박영희", score.getName());

    }
    
    @Test
    @DisplayName("1번학생을 삭제한 후 1번 학생을 조회했을때 조회되지 않아야한다 ")
    void deleteTest() {
        // given
        int stuNum = 3;
        // when
        boolean flag = repository.delete(stuNum);
        Score deleteScore = repository.findOne(stuNum);
        // then
        assertTrue(flag);
        assertNull(deleteScore);
    }
}