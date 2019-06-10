/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.sgd.controller;
import com.company.sgd.service.FileManager;
import com.company.sgd.service.SegurosService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author the_d
 */
@Controller
public class SegurosController {
    @Autowired
    FileManager fileManager;
    @Autowired
    HttpServletResponse response;
    
    SegurosService service;

    @Autowired
    public SegurosController(SegurosService SService) {
        this.service = SService;
    }    
    
    @GetMapping("/seguros")
    public ModelAndView sayHello() {
    	ModelAndView mv = new ModelAndView();        
        mv.setViewName("seguros");
        return mv;
    }
    
    @PostMapping("/getS")
    @ResponseBody
    public void getDocument(@RequestParam("x") String x) {
        service.getS(x);
    }
    
    @PostMapping("/getSZip")
    @ResponseBody
    public void getZip(@RequestParam("x") String x) {
        service.getZip(x);
    }
}
