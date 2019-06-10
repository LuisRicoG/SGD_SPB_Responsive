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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComiteEngordaReglasController {

    ContratosFirmadosService service;
    @Autowired
    FileManager fileManager;
    @Autowired
    HttpServletResponse response;

    @Autowired
    public ComiteEngordaReglasController(ContratosFirmadosService contratosService) {
        this.service = contratosService;
    }

    @GetMapping("/comiteengordareglas")
    public ModelAndView getGobiernoCorporativoReglas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("comiteEngordaReglas");
        return mv;
    }

    @PostMapping("/getdocumentocomiteengordareglas")
    public void getDocumentoComiteEngordaReglas(@RequestParam("year") String year, @RequestParam("documento") String documento) throws IOException {
        service.getDocumentosAnio(documento, year);
    }
}
