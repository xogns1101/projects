package com.spring.mvc.chap05.entity;


import lombok.*;

import java.time.LocalDateTime;

/*
    CREATE TABLE tbl_reply(
        reply_no INT PRIMARY KEY AUTO_INCREMENT,
        reply_text VARCHAR(1000) NOT NULL,
        reply_writer VARCHAR(100) NOT NULL,
        reply_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        board_no INT,

        CONSTRAINT fk_reply FOREIGN KEY(board_no) REFERENCES tbl_board(board_no)
        ON DELETE CASCADE
    );
*/
@Getter @Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    private int replyNo;
    private String replyText;
    private String replyWriter;
    private LocalDateTime replyDate;
    private int boardNo;
    private LocalDateTime updateDate;




}
