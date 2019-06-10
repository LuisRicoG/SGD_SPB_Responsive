package com.company.sgd.controller;

import com.company.sgd.service.ReporteVentasService.ReporteVentasService;
import com.company.sgd.util.LOVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReporteVentasController {

    ReporteVentasService service;
    
    @Autowired
    LOVUtil lovu;

    @Autowired
    public ReporteVentasController(ReporteVentasService reporteService) {
        this.service = reporteService;
    }

    @GetMapping("/reporteventas")
    public ModelAndView getEdosFinancieros() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("lista", lovu.getLov("anio"));
        mv.setViewName("reporteventas");
        return mv;
    }

    @PostMapping("/getReporte")
    @ResponseBody
    public void getDocument(@RequestParam("year") String year, @RequestParam("month") String month) {
        service.getReporteVentas(year, month);
    }
}
