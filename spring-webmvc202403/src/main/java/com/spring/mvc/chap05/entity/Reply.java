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

    ALTER TABLE tbl_reply
    ADD account VARCHAR(50);

    ALTER TABLE tbl_reply
    ADD CONSTRAINT fk_reply_account
    FOREIGN KEY (account)
    REFERENCES tbl_member (account)
    ON DELETE CASCADE;

*/
@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    private int replyNo;
    @Setter
    private String replyText;
    @Setter
    private String replyWriter;
    private LocalDateTime replyDate;
    private int boardNo;
    private LocalDateTime updateDate;
    @Setter
    private String account;




}
