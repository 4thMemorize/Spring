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
    private BoardDaoImp dao;

    @Resource(name = "asyncConfig")
    private AsyncConfig asyncConfig;

    @Resource(name = "asyncTask")
    private AsyncTask asyncTask;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody()
    public Object insertBoard(@RequestBody Map<String, Object> param) {
        BoardVO vo = new BoardVO();
        Map<String, Object> result = new HashMap<>();

        vo.setWriter((String)param.get("writer"));;
        vo.setTitle((String)param.get("title"));
        vo.setContent((String)param.get("content"));
        vo.setDate();

        if(dao.insertBoard(vo) > 0) {
            System.out.println("Insert Success");
            result.put("status", 200);
        }
        else {
            System.out.println("Insert Error Occured");
            result.put("status", 500);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody()
    public Object selectBoard() {
        Map<String, Object> result = new HashMap<>();
        Object list = dao.selectBoard();
        System.out.println(list);
        result.put("data", list);
        if (list.getClass().getName() == "java.util.ArrayList") {
            result.put("status", 200);
        }
        else {
            result.put("status", 500);
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody()
    public Object updateBoard(@RequestBody Map<String, Object> param) {
        BoardVO vo = new BoardVO();
        Map<String, Object> result = new HashMap<>();
        vo.setId((Integer)param.get("id"));
        vo.setWriter((String)param.get("writer"));
        vo.setTitle((String)param.get("title"));
        vo.setContent((String)param.get("content"));
        Integer response = dao.updateBoard(vo);

        if(response > 0) {
            result.put("status", 200);
        }
        else {
            result.put("status", 500);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody()
    public Object deleteBoard(@RequestBody Map<String, Object> param) {
        BoardVO vo = new BoardVO();
        Map<String, Object> result = new HashMap<>();
        vo.setId((Integer)param.get("id"));
        Integer response = dao.deleteBoard(vo);

        if(response > 0) {
            result.put("status", 200);
        }
        else {
            result.put("status", 500);
        }

        return result;
    }
}
