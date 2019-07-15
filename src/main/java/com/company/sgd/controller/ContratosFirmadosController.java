package com.company.sgd.controller;

import com.company.sgd.service.ContratosFirmadosService;
import com.company.sgd.service.FileManager;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContratosFirmadosController {

    ContratosFirmadosService service;
    @Autowired
    FileManager fileManager;
    @Autowired
    HttpServletResponse response;

    @Autowired
    public ContratosFirmadosController(ContratosFirmadosService contratosService) {
        this.service = contratosService;
    }

    @GetMapping("/contratosfirmados")
    public ModelAndView getContratosFirmados() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contratosFirmados");
        return mv;
    }

    @PostMapping("/getdocumentocontratos")
        @ResponseBody
    public void cliente(@RequestParam("documento") String documento) throws IOException {
        service.getContratosFirmados(documento);

    }
}
