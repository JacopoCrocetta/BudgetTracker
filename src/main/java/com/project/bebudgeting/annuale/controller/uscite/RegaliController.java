package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.AltroRegaliService;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.DonazioniBeneficienzaService;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.RegaliDBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Regali", tags = "Regali", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/regali")
public class RegaliController {
    @Autowired
    AltroRegaliService altroRegaliService;

    @Autowired
    DonazioniBeneficienzaService donazioniBeneficienzaService;

    @Autowired
    RegaliDBService regaliDBService;
}
