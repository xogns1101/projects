package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    private final JdbcTemplate template;
 
    //enum 클래스로 하여 BoardMapper 생성! class 앞에 public 빼야함
    // implements RowMapper<해당 entity> 할 것!
    class BoardMapper implements RowMapper<Board> {
        @Override
        public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

            Board board = new Board(
                    rs.getInt("board_no"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getInt("view_count"),
                    // date 객체는 아래 참고
                    rs.getTimestamp("reg_date").toLocalDateTime(),
                    rs.getString("writer")

            );

            return board;
        }
    }

    // 항상 기억하기! -> SELECT 진행 시에는 query(전체 조회), queryForObject(단일조회) 사용
    // INSERT, UPDATE, DELETE 는 update 메서드 사용
    

    // 전체 조회 -> 전체 조회시 query 매서드 진행
    @Override
    public List<Board> findAll() {

        String sql = "SELECT * FROM tbl_board ORDER BY board_no DESC";

        return template.query(sql, new BoardMapper());

    }

    // primary key 에 해당하는 하나의 행을 조회 -> 단일 조회시 queryForObject 매서드 진행
    // -> queryForObject를 사용하게 되면 예외발생이 하기 때문에 try/catch 로 감싸주기
    // catch 엔 null 로 return 할 것!
    @Override
    public Board findOne(int boardNo) {

        String sql = "SELECT * FROM tbl_board WHERE board_no = ?";

        try {
           return  template.queryForObject(sql, new BoardMapper(), boardNo);
        } catch (DataAccessException e) {
            return null;
        }


    }

    // 매개변수로는 entity 를 주면서 인풋에 들어갈 컬럼값을 sql 로 작성
    @Override
    public void save(Board board) {

        String sql = "INSERT INTO tbl_board " +
                " (title, content, writer)" +
                "VALUES(?, ?, ?)";

        template.update(sql, board.getTitle(),
                board.getContent(),
                board.getWriter());

    }

    // 삭제 진행 할때는 해당 sql, primary key 전달하기
    @Override
    public void delete(int boardNo) {

        String sql = "DELETE FROM tbl_board WHERE board_no = ?";

        template.update(sql, boardNo);

    }

    @Override
    public void updateViewCount(int bno) {

        String sql = "UPDATE tbl_board SET " +
                "view_count = view_count + 1 WHERE board_no = ?";

        template.update(sql, bno);

    }
}
