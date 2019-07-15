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
public class ComiteComercialReporteController {

    ContratosFirmadosService service;

    @Autowired
    public ComiteComercialReporteController(ContratosFirmadosService contratosService) {
        this.service = contratosService;
    }

    @GetMapping("/consejoadministracion")
    public ModelAndView getGobiernoCorporativoConsejoAdm(Model model) {
        List<NombresEntity> nombres = service.getnombres("CA");        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("consejoAdministracion");
        model.addAttribute("listanombres", nombres);
        return mv;
    }
    
    @Autowired
    FileManager fileManager;
    @Autowired
    HttpServletResponse response;

    @PostMapping("/getdocumentocomitecomercialreglas")
        @ResponseBody
    public void getDocumentoConsejoAdm(@RequestParam("year") String year, @RequestParam("documento") String documento) throws IOException {
        service.getDocumentosAnio(documento, year);
    }
}
