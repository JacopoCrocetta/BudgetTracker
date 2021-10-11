package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AltreAssicurazioniService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneAutoService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneSaluteService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneVitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

    // FIND ALL
    @GetMapping(value = "/get-all-altre-assicuraioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltreAssicurazioniEntity> getAllAltreAssicuraioniEntity() {
        return altreAssicurazioniService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-auto-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneAutoEntity> getAllAssicuraioniAutoEntity() {
        return assicurazioneAutoService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-casa-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneCasaEntity> getAllAssicurazioniCasaEntity() {
        return assicurazioneCasaService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-salute-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneSaluteEntity> getAllAssicurazioneSaluteEntity() {
        return assicurazioneSaluteService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-vita-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneVitaEntity> getAllAssicurazioneVitaEntity() {
        return assicurazioneVitaService.findAll();
    }

    @GetMapping(value = "/get-all-assicurazioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneEntity> getAllAssicurazioniEntity() {
        return null;
    }
}
