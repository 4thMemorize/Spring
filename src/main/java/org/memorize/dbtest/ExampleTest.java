package org.memorize.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ExampleTest {
    @Autowired
    private ExampleDAOImp dao;

    @RequestMapping(value = "/test/dao", method = RequestMethod.GET)
    @ResponseBody()
    public Object ExampleTest(@RequestParam("name") String name, @RequestParam("tel") String tel, @RequestParam("postcode") String postcode) {
        ExampleVO vo = new ExampleVO();
        Map<String, Object> result = new HashMap<>();
        vo.setName(name);
        vo.setTel(tel);
        vo.setPostcode(postcode);

        if (dao.insertExample(vo) > 0) {
            System.out.println("Insert Success");
            result.put("status", 200);
        }
        else {
            System.out.println("Insert Error Occured");
            result.put("status", 500);
        }
        return result;
    }
}
