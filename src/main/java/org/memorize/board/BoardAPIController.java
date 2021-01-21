package org.memorize.board;

import org.memorize.task.AsyncConfig;
import org.memorize.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/api/board")
public class BoardAPIController {
    @Autowired
    private BoardService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody()
    public Object insertBoard(@RequestBody Map<String, Object> param) {
        String writer = (String)param.get("writer");
        String title = (String)param.get("title");
        String content = (String)param.get("content");

        // Validate Input Values

        return service.insert(writer, title, content);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody()
    public Object selectBoard() {
        return service.select();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody()
    public Object updateBoard(@RequestBody Map<String, Object> param) {
        Integer id = (Integer)param.get("id");
        String writer = (String)param.get("writer");
        String title = (String)param.get("title");
        String content = (String)param.get("content");

        //Validate Input Values

        return service.update(id, writer, title, content);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody()
    public Object deleteBoard(@RequestBody Map<String, Object> param) {
        Integer id = (Integer) param.get("id");

        //Validate Input Values

        return service.delete(id);
    }
}
