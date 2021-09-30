package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.AltreBolletteService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteAcquaService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteElettricitaService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteGASService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteInternetService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteRifiutiService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteTelefonoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Bollette", tags = "Bollette", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/bollette")
public class BolletteController {
    @Autowired
    AltreBolletteService altreBolletteService;

    @Autowired
    BolletteAcquaService bolletteAcquaService;

    @Autowired
    BolletteElettricitaService bolletteElettricitaService;

    @Autowired
    BolletteGASService bolletteGASService;

    @Autowired
    BolletteInternetService bolletteInternetService;

    @Autowired
    BolletteRifiutiService bolletteRifiutiService;

    @Autowired
    BolletteTelefonoService bolletteTelefonoService;
}
