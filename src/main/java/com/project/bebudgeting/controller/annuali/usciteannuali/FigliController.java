package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.FigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AltroFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AsiloFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AttivitaFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.PaghettaFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.ScuolaFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.VestitiFigliEntity;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.AltroFigliService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.AsiloService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.AttivitaFigliService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.GiocattoliFigliService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.PaghettaFigliService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.ScuolaFigliService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.SpeseMedicheFigliService;
import com.project.bebudgeting.service.annuali.usciteservice.figliservice.VestitiFigliService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

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

    // FIND ALL
    @GetMapping(value = "/get-all-altro-figli-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroFigliEntity> getAllAltroFigliEntities() {
        return altroFigliService.findAll();
    }

    @GetMapping(value = "/get-all-asilo-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AsiloFigliEntity> getAllAsiloEntities() {
        return asiloService.findAll();
    }

    @GetMapping(value = "/get-all-attivita-figli-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AttivitaFigliEntity> getAllAttivitaFigliEntities() {
        return attivitaFigliService.findAll();
    }

    @GetMapping(value = "/get-all-giocattoli-figli-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GiocattoliFigliEntity> getAllGiocattoliFigliEntity() {
        return giocattoliFigliService.findAll();
    }

    @GetMapping(value = "/get-all-paghetta-figli-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PaghettaFigliEntity> getAllPaghettaFigliEntities() {
        return paghettaFigliService.findAll();
    }

    @GetMapping(value = "/get-all-scuola-figli-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ScuolaFigliEntity> getAllScuolaFigliEntities() {
        return scuolaFigliService.findAll();
    }

    @GetMapping(value = "/get-all-libri-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SpeseMedicheFigliEntity> getAllSpeseMedicheFigliEntities() {
        return speseMedicheFigliService.findAll();
    }

    @GetMapping(value = "/get-all-vestiti-figli-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<VestitiFigliEntity> getAllVestitiFigliEntity() {
        return vestitiFigliService.findAll();
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-altro-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroFigliEntities(@RequestBody Iterable<Integer> ids) {
        altroFigliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-asilo-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAsiloEntities(@RequestBody Iterable<Integer> ids) {
        asiloService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-attivita-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAttivitaFigliEntities(@RequestBody Iterable<Integer> ids) {
        attivitaFigliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-giocattoli-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllGiocattoliFigliEntity(@RequestBody Iterable<Integer> ids) {
        giocattoliFigliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-paghetta-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllPaghettaFigliEntities(@RequestBody Iterable<Integer> ids) {
        paghettaFigliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-scuola-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllScuolaFigliEntities(@RequestBody Iterable<Integer> ids) {
        scuolaFigliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-libri-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllSpeseMedicheFigliEntities(@RequestBody Iterable<Integer> ids) {
        speseMedicheFigliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-vestiti-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllVestitiFigliEntity(@RequestBody Iterable<Integer> ids) {
        vestitiFigliService.deleteAllById(ids);
    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-selected-altro-figli-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroFigliEntity(@RequestBody AltroFigliEntity entity) throws NotFoundException {
        altroFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-asilo-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAsiloEntities(@RequestBody AsiloFigliEntity entity) throws NotFoundException {
        asiloService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-attivita-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAttivitaFigliEntities(@RequestBody AttivitaFigliEntity entity) throws NotFoundException {
        attivitaFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-giocattoli-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneGiocattoliFigliEntity(@RequestBody GiocattoliFigliEntity entity) throws NotFoundException {
        giocattoliFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-paghetta-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOnePaghettaFigliEntities(@RequestBody PaghettaFigliEntity entity) throws NotFoundException {
        paghettaFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-scuola-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneScuolaFigliEntities(@RequestBody ScuolaFigliEntity entity) throws NotFoundException {
        scuolaFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-libri-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSpeseMedicheFigliEntities(@RequestBody SpeseMedicheFigliEntity entity)
            throws NotFoundException {
        speseMedicheFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-vestiti-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneVestitiFigliEntity(@RequestBody VestitiFigliEntity entity) throws NotFoundException {
        vestitiFigliService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneVestitiFigliEntity(@RequestBody FigliEntity entity) throws NotFoundException {
        if (!entity.getAltroFigliEntities().isEmpty()) {
            altroFigliService.deleteAll(entity.getAltroFigliEntities());
        }
        if (!entity.getAsiloEntities().isEmpty()) {
            asiloService.deleteAll(entity.getAsiloEntities());
        }
        if (!entity.getAttivitaEntities().isEmpty()) {
            attivitaFigliService.deleteAll(entity.getAttivitaEntities());
        }
        if (!entity.getGiocattoliEntities().isEmpty()) {
            giocattoliFigliService.deleteAll(entity.getGiocattoliEntities());
        }
        if (!entity.getPaghettaEntities().isEmpty()) {
            paghettaFigliService.deleteAll(entity.getPaghettaEntities());
        }
        if (!entity.getScuolaEntities().isEmpty()) {
            scuolaFigliService.deleteAll(entity.getScuolaEntities());
        }
        if (!entity.getSpeseMedicheFigliEntities().isEmpty()) {
            speseMedicheFigliService.deleteAll(entity.getSpeseMedicheFigliEntities());
        }
        if (!entity.getVestitiEntities().isEmpty()) {
            vestitiFigliService.deleteAll(entity.getVestitiEntities());
        }
    }

    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altro-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroFigliEntity saveOneAltroFigliEntity(@RequestBody AltroFigliEntity entity) {
        return altroFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-asilo-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AsiloFigliEntity saveOneAsiloFigliEntity(@RequestBody AsiloFigliEntity entity) {
        return asiloService.save(entity);
    }

    @PutMapping(value = "/save-one-attivita-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttivitaFigliEntity saveOneAttivitaFigliEntity(@RequestBody AttivitaFigliEntity entity) {
        return attivitaFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-giocattoli-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GiocattoliFigliEntity saveOneGiocattoliFigliEntity(@RequestBody GiocattoliFigliEntity entity) {
        return giocattoliFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-paghetta-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaghettaFigliEntity saveOnePaghettaFigliEntity(@RequestBody PaghettaFigliEntity entity) {
        return paghettaFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-scuola-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScuolaFigliEntity saveOneScuolaFigliEntity(@RequestBody ScuolaFigliEntity entity) {
        return scuolaFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-spese-mediche-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpeseMedicheFigliEntity saveOneSpeseMedicheFigliEntity(@RequestBody SpeseMedicheFigliEntity entity) {
        return speseMedicheFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-vestiti-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VestitiFigliEntity saveOneVestitiFigliEntity(@RequestBody VestitiFigliEntity entity) {
        return vestitiFigliService.save(entity);
    }

    @PutMapping(value = "/save-one-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FigliEntity saveOneFigliEntity(@RequestBody FigliEntity entity) {
        altroFigliService.saveAll(entity.getAltroFigliEntities());
        asiloService.saveAll(entity.getAsiloEntities());
        attivitaFigliService.saveAll(entity.getAttivitaEntities());
        giocattoliFigliService.saveAll(entity.getGiocattoliEntities());
        paghettaFigliService.saveAll(entity.getPaghettaEntities());
        scuolaFigliService.saveAll(entity.getScuolaEntities());
        speseMedicheFigliService.saveAll(entity.getSpeseMedicheFigliEntities());
        vestitiFigliService.saveAll(entity.getVestitiEntities());

        return entity;
    }
}
