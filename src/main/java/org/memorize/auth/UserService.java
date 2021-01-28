package org.memorize.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDaoImp userDao;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Object insert(String user_id, String user_pw) {
        UserVO vo = new UserVO();
        Map<String, Object> result = new HashMap<>();

        String encryptPassword = passwordEncoder.encode(user_pw);
        System.out.println(encryptPassword);
        vo.setUser_id(user_id);
        vo.setUser_pw(encryptPassword);

        if(userDao.insertUser(vo) > 0) result.put("status", 200);
        else result.put("status", 500);
        return result;
    }

    public Object selectUser() {
        Map<String, Object> result = new HashMap<>();
        Object list = userDao.selectUser();

        if(list.getClass().getName() == "java.util.ArrayList") {
            result.put("data", list);
            result.put("status", 200);
        }
        else result.put("status", 500);
        return result;
    }

    public Object loginUser(String user_id, String user_pw) {
        UserVO vo = new UserVO();
        Map<String, Object> result = new HashMap<>();

        String encryptPassword = passwordEncoder.encode(user_pw);
        System.out.println(encryptPassword);
        vo.setUser_id(user_id);
        vo.setUser_pw(encryptPassword);

        UserVO user = (UserVO) userDao.loginUser(vo);
        System.out.println(user);
        if(user == null) {
            result.put("status", 401);
            return result;
        }
        if(passwordEncoder.matches(user_pw, user.getUser_pw())) {
//            result.put("data", );
            result.put("status", 200);
        }
        else result.put("status", 401);
        return result;
    }

    public Object updateUser(String user_id, String user_pw) {
        UserVO vo = new UserVO();
        Map<String, Object> result = new HashMap<>();

        String encryptPassword = passwordEncoder.encode(user_pw);
        System.out.println(encryptPassword);
        vo.setUser_id(user_id);
        vo.setUser_pw(encryptPassword);

        if(userDao.updateUser(vo) > 0) result.put("status", 200);
        else result.put("status", 500);
        return result;
    }

    public Object deleteUser(String user_id, String user_pw) {
        UserVO vo = new UserVO();
        Map<String, Object> result = new HashMap<>();

        vo.setUser_id(user_id);
        vo.setUser_pw(user_pw);

        if(userDao.deleteUser(vo) > 0) result.put("status", 200);
        else result.put("status", 500);

        return result;
    }
}
