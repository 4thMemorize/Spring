package org.memorize.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/normal")
public class NormalControl {
    private Map<Integer, String> list = new HashMap<>();

//    @Autowired
//    public NormalControl() {
//        System.out.println("Constructor");
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody()
    public Object normalReq(@PathVariable("id") Integer id) {
        System.out.println("get id");
        list.put(0, "admin");
        list.put(1, "user");
        list.put(2, "4thMemorize");
        return list.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody()
    public Map<Integer, String> getList() {
        System.out.println("get");
        list.put(0, "admin");
        list.put(1, "user");
        list.put(2, "4thMemorize");
        return list;
    }
}