package org.memorize.spring.controller;

import java.util.Map;

public class ConcreteController extends AbstractController{
    public ConcreteController() {
        this.setRequiredParams(new String[] {"name"});
        this.setViewName("controller");
    }

    @Override
    public void control(Map<String, String> params, Map<String, Object> model) throws Exception {
        System.out.println(params.get("name"));
        model.put("message", params.get("name"));
    }
}
