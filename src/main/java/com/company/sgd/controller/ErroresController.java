package com.company.sgd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jova_
 */
@Controller

public class ErroresController {

    @GetMapping(value = "/500")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("500");
        return mv;
    }

    @GetMapping(value = "/404")
    public ModelAndView e400() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("404");
        return mv;
    }

    @GetMapping(value = "/403")
    public ModelAndView e403() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("403");
        return mv;
    }
    
    @GetMapping(value = "/307")
    public ModelAndView e307() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("307");
        return mv;
    }
}
