package com.company.sgd.controller;

import com.company.sgd.entity.NombresEntity;
import org.springframework.ui.Model;
import java.util.List;
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
public class ComiteComercialController {

    ContratosFirmadosService service;

    @Autowired
    public ComiteComercialController(ContratosFirmadosService contratosService) {
        this.service = contratosService;
    }

    @GetMapping("/comitecomercial")
    public ModelAndView getGobiernoCorporativo(Model model) {
        List<NombresEntity> nombres = service.getnombres("CC");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("comiteComercial");
        model.addAttribute("listanombres", nombres);
        return mv;
    }
    @Autowired
    FileManager fileManager;
    @Autowired
    HttpServletResponse response;

    @PostMapping("/getdocumentocomitecomercial")
        @ResponseBody
    public void getDocumentoComiteEngorda(@RequestParam("year") String year, @RequestParam("documento") String documento) throws IOException {
        service.getDocumentosAnio(documento, year);
    }
}
