package org.memorize.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/api/auth")
public class UserAPIController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody()
    public Object insertUser(@RequestBody Map<String, Object> param) {
        String user_id = (String)param.get("user_id");
        String user_pw = (String)param.get("user_pw");

        return service.insert(user_id, user_pw);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Object selectUser() {
        return service.selectUser();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Object loginUser(@RequestBody Map<String, Object> param) {
        String user_id = (String) param.get("user_id");
        String user_pw = (String) param.get("user_pw");
        return service.loginUser(user_id, user_pw);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateBoard(@RequestBody Map<String, Object> param) {
        String user_id = (String)param.get("user_id");
        String user_pw = (String)param.get("user_pw");

        return service.updateUser(user_id, user_pw);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUser(@RequestBody Map<String, Object> param) {
        String user_id = (String)param.get("user_id");
        String user_pw = (String)param.get("user_pw");

        return service.deleteUser(user_id, user_pw);
    }
}
