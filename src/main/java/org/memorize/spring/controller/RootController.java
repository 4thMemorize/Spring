package org.memorize.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {
    @RequestMapping(path="/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("Title", "Home");
        mav.addObject("Content", "Welcome to Home!");
        mav.setViewName("index");
        return mav;
    }
}
