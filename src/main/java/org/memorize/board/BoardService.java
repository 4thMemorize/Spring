package org.memorize.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardDaoImp boardDao;

    public Object insert(String writer, String title, String content) {
        BoardVO vo = new BoardVO();
        Map<String, Object> result = new HashMap<>();

        vo.setWriter(writer);
        vo.setTitle(title);
        vo.setContent(content);
        vo.setDate();

        if (boardDao.insertBoard(vo) > 0) result.put("status", 200);
        else result.put("status", 500);
        return result;
    }

    public Object select() {
        Map<String, Object> result = new HashMap<>();
        Object list = boardDao.selectBoard();

        if (list.getClass().getName() == "java.util.ArrayList") {
            result.put("data", list);
            result.put("status", 200);
        } else result.put("status", 500);
        return result;
    }

    public Object update(Integer id, String writer, String title, String content) {
        BoardVO vo = new BoardVO();
        Map<String, Object> result = new HashMap<>();
        vo.setId(id);
        vo.setWriter(writer);
        vo.setTitle(title);
        vo.setContent(content);

        if (boardDao.updateBoard(vo) > 0) result.put("status", 200);
        else result.put("status", 500);

        return result;
    }

    public Object delete(Integer id) {
        BoardVO vo = new BoardVO();
        Map<String, Object> result = new HashMap<>();
        vo.setId(id);

        if(boardDao.deleteBoard(vo) > 0) result.put("status", 200);
        else result.put("status", 500);

        return result;
    }
}
