package org.memorize.dbtest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  //State Data Access Object
public class ExampleDAOImp implements ExmapleDAO{
    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.memorize.dbtest.ExampleMapper";

    @Override
    public Integer insertExample(ExampleVO vo) {
        Integer result = sqlSession.insert(namespace+".insertExample", vo);
        return result;
    }
}
