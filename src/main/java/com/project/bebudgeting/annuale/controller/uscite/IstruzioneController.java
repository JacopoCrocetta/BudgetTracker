package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.AltroIstruzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.LezioniIndipendentiService;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.LibriIstruzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.RetteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Istruzione", tags = "Istruzione", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/istruzione")
public class IstruzioneController {
    @Autowired
    AltroIstruzioneService altroIstruzioneService;

    @Autowired
    LezioniIndipendentiService lezioniIndipendentiService;

    @Autowired
    LibriIstruzioneService libriIstruzioneService;

    @Autowired
    RetteService retteService;
}
