package com.company.sgd.controller;

import com.company.sgd.service.OrganigramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Qualtop
 */
@Controller
public class OrganigramaController {

    OrganigramaService service;

    @Autowired
    public OrganigramaController(OrganigramaService organigramaService) {
        this.service = organigramaService;
    }

    @GetMapping("/downorganigrama")
    @ResponseBody
    public void org() {
        service.organigrama();
    }
}
