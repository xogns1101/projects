package com.spring.mvc.chap05.dto.request;

import com.spring.mvc.chap05.entity.Reply;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode @NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDeleteRequest {

    private int rno;

    public Reply toEntity(){

        return Reply.builder()
                .replyNo(rno)
                .build();
    }



}
