package org.memorize.restful;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest")
public class RestControl {
    private Map<Integer, String> list = new HashMap<>();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object rest(@PathVariable("id") Integer id) {
        list.put(0, "admin");
        list.put(1, "user");
        list.put(2, "4thMemorize");

        return list.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<Integer, String> getList() {
        list.put(0, "admin");
        list.put(1, "user");
        list.put(2, "4thMemorize");
        return list;
    }
}
