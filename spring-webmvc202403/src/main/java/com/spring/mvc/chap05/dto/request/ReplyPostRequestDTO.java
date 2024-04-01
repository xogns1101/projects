package com.spring.mvc.chap05.dto.request;

import com.spring.mvc.chap05.entity.Reply;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode @NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyPostRequestDTO {

    // NotBlank : null 은 안됨! 빈문자열도 안됨
    // NotNull : null 만 안됨! 빈문자열은 됨

    @NotBlank
    @Size(min = 1, max = 300)
    private String text; // 댓글 내용

    @NotBlank
    @Size(min = 2, max = 8)
    private String writer;  // 댓글 작성저

    @NotNull
    private int bno; // 원븐 글번호

    // dto를 entity로 바꾸는 변환 메서드
    public Reply toEntity(){

        return Reply.builder()
                .replyText(this.text)
                .replyWriter(this.writer)
                .boardNo(this.bno)
                .build();

    }















}
