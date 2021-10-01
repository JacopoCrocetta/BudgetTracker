package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.AbbonamentiService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.AltreSpeseQuotidianeService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.IgienePersonaleService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.LavanderiaService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.ParrucchiereService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.SupermercatoService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.VestitiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Spese Quotidiane", tags = "Spese Quotidiane", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/spese-quotidiane")
public class SpeseQuotidianeController {
    @Autowired
    AbbonamentiService abbonamentiService;

    @Autowired
    AltreSpeseQuotidianeService altreSpeseQuotidianeService;

    @Autowired
    IgienePersonaleService igienePersonaleService;

    @Autowired
    LavanderiaService lavanderiaService;

    @Autowired
    ParrucchiereService parrucchiereService;

    @Autowired
    SupermercatoService supermercatoService;

    @Autowired
    VestitiService vestitiService;
}
