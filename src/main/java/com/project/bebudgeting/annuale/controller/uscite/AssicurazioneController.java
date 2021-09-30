package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AltreAssicurazioniService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneAutoService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneSaluteService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneVitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Assicurazione", tags = "Assicurazione", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/assicurazione")
public class AssicurazioneController {
    @Autowired
    AltreAssicurazioniService altreAssicurazioniService;

    @Autowired
    AssicurazioneAutoService assicurazioneAutoService;

    @Autowired
    AssicurazioneCasaService assicurazioneCasaService;

    @Autowired
    AssicurazioneSaluteService assicurazioneSaluteService;

    @Autowired
    AssicurazioneVitaService assicurazioneVitaService;
}
