package com.company.sgd.controller;

import com.company.sgd.beans.Login;
import com.company.sgd.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogInController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/index")
    public ModelAndView getLogin() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", new Login());
        mv.setViewName("index");
        return mv;
    }
}
