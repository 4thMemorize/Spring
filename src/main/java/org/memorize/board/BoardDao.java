package org.memorize.board;

public interface BoardDao {
    public Integer insertBoard(BoardVO vo);
    public Object selectBoard();
    public Integer updateBoard(BoardVO vo);
    public Integer deleteBoard(BoardVO id);
}
