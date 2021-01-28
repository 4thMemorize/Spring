package org.memorize.auth;

public interface UserDao {
    public Integer insertUser(UserVO vo);
    public Object selectUser();
    public Object loginUser(UserVO vo);
    public Integer updateUser(UserVO vo);
    public Integer deleteUser(UserVO vo);
}
