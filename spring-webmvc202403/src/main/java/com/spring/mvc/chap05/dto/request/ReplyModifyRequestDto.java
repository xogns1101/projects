package com.spring.mvc.chap05.dto.request;

import com.spring.mvc.chap05.entity.Reply;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter @Getter @ToString
@EqualsAndHashCode @NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyModifyRequestDto {

    @NotNull
    private int rno; // 수정할 댓글 내용

    @NotBlank
    private String text; // 수정할 댓글 내용

    // dto를 entity로 바꾸는 메서드
    public Reply toEntity(){

        return Reply.builder()
                .replyNo(rno)
                .replyText(text)
                .build();

    }


}
