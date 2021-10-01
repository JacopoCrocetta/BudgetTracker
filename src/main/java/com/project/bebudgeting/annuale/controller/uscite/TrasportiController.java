package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.AltroTrasportiService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.BolloService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.CarburanteService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.FornitureTrasportiService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.PrestitoAutoService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.RiparazioniService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.TrasportoPubblicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Trasporti", tags = "Trasporti", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/trasporti")
public class TrasportiController {
    @Autowired
    AltroTrasportiService altroTrasportiService;

    @Autowired
    BolloService bolloService;

    @Autowired
    CarburanteService carburanteService;

    @Autowired
    FornitureTrasportiService fornitureTrasportiService;

    @Autowired
    PrestitoAutoService prestitoAutoService;

    @Autowired
    RiparazioniService riparazioniService;

    @Autowired
    TrasportoPubblicoService trasportoPubblicoService;
}
