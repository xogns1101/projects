package com.spring.mvc.chap05.dto.response;

import com.spring.mvc.chap05.entity.Board;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode
public class BoardResponseDTO {

    private final int boardNo;
    private final String shortTitle; // 5글자 이상이면 잘라내기
    private final String shortContent;// 30 자 이상이면 잘라내기
    private final String regDate; // 날짜 패턴 yyyy--MM--dd HH:mm
    private final int viewCount;
    private final String writer;

    public BoardResponseDTO(Board board) {

        this.boardNo = board.getBoardNo();
        this.shortTitle = makeShortTitle(board.getTitle());
        this.shortContent = makeShortContent(board.getContent());
        this.regDate = makePrettierDateString(board.getRegDate());
        this.viewCount = board.getViewCount();
        this.writer = board.getWriter();

    }

    // 날짜와 시간 포멧터 사용하여 변경하기
    public static String makePrettierDateString(LocalDateTime regDate) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return dtf.format(regDate);


    }

    private String makeShortContent(String content) {
        return sliceString(content, 30);
    }

    private String makeShortTitle(String title) {

        return sliceString(title, 5);

    }

    /**
     *
     * @param targetString : 줄이고 싶은 원본 문자열
     * @param wishLength : 짜르고 싶은 글자 수
     * @return : wishLength보다 targetString이 길면
     *              wishLength만큼 짤라서 뒤에 ... 붙여서 리턴
     */
    private static String sliceString(String targetString, int wishLength) {
        return (targetString.length() > wishLength)
                ? targetString.substring(0, wishLength) + "..."
                : targetString
                ;
    }

}
