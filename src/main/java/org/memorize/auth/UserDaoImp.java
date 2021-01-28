package org.memorize.auth;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{
    @Autowired
    SqlSession sqlSession;

    private static final String namespace = "org.memorize.auth.Mapper";

    @Override
    public Integer insertUser(UserVO vo) {
        System.out.println(vo.getUser_pw());
        System.out.println(vo.getUser_id());
        return sqlSession.insert(namespace+".insertUser", vo);
    }

    @Override
    public Object selectUser() {
        return sqlSession.selectList(namespace+".selectUser");
    }

    @Override
    public Object loginUser(UserVO vo) {
        return sqlSession.selectOne(namespace+".loginUser", vo);
    }

    @Override
    public Integer updateUser(UserVO vo) {
        return sqlSession.update(namespace+".updateUser", vo);
    }

    @Override
    public Integer deleteUser(UserVO vo) {
        return sqlSession.delete(namespace+".deleteUser", vo);
    }
}
