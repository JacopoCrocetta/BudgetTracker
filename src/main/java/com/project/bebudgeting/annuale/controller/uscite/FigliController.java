package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.figliservice.AltroFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.AsiloService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.AttivitaFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.GiocattoliFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.PaghettaFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.ScuolaFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.SpeseMedicheFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.VestitiFigliService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Figli", tags = "Figli", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/figli")
public class FigliController {
    @Autowired
    AltroFigliService altroFigliService;

    @Autowired
    AsiloService asiloService;

    @Autowired
    AttivitaFigliService attivitaFigliService;

    @Autowired
    GiocattoliFigliService giocattoliFigliService;

    @Autowired
    PaghettaFigliService paghettaFigliService;

    @Autowired
    ScuolaFigliService scuolaFigliService;

    @Autowired
    SpeseMedicheFigliService speseMedicheFigliService;

    @Autowired
    VestitiFigliService vestitiFigliService;
}
