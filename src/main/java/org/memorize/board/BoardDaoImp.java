package org.memorize.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImp implements BoardDao{
    @Autowired
    SqlSession sqlSession;

    private static final String namespace = "org.memorize.board.Mapper";

    @Override
    public Integer insertBoard(BoardVO vo) {
        return sqlSession.insert(namespace+".insertBoard", vo);
    }

    @Override
    public Object selectBoard() {
        return sqlSession.selectList(namespace+".selectBoard");
    }

    @Override
    public Integer updateBoard(BoardVO vo) {
        return sqlSession.update(namespace+".updateBoard", vo);
    }

    @Override
    public Integer deleteBoard(BoardVO vo) {
        return sqlSession.delete(namespace+".deleteBoard", vo);
    }

}
