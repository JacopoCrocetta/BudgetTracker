package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.RegaliUsciteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.AltroRegaliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.RegaliDBEntity;
import com.project.bebudgeting.service.annuali.usciteservice.regaliservice.AltroRegaliService;
import com.project.bebudgeting.service.annuali.usciteservice.regaliservice.DonazioniBeneficienzaService;
import com.project.bebudgeting.service.annuali.usciteservice.regaliservice.RegaliDBService;

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

    // FIND ALL
    @GetMapping(value = "/get-all-altro-regali-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroRegaliEntity> getAllAltroRegaliEntities() {
        return altroRegaliService.findAll();
    }

    @GetMapping(value = "/get-all-donazioni-beneficienza-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DonazioniBeneficenzaEntity> getAllDonazioniBeneficienzaEntities() {
        return donazioniBeneficienzaService.findAll();
    }

    @GetMapping(value = "/get-all-libri-istruzione-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RegaliDBEntity> getAllLibriIstruzioneEntities() {
        return regaliDBService.findAll();
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-altro-istruzione-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroIstruzioneEntities(@RequestBody Iterable<Integer> ids) {
        altroRegaliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-lezioni-indipendenti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllLezioniIndipendentiEntities(@RequestBody Iterable<Integer> ids) {
        donazioniBeneficienzaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-libri-istruzione-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllLibriIstruzioneEntities(@RequestBody Iterable<Integer> ids) {
        regaliDBService.deleteAllById(ids);
    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-altro-regali-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedAltroRegaliEntity(@RequestBody AltroRegaliEntity entity) throws NotFoundException {
        altroRegaliService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-lezione-indipendenti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedDonazioniBeneficienzaEntity(@RequestBody DonazioniBeneficenzaEntity entity)
            throws NotFoundException {
        donazioniBeneficienzaService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-libri-istruzione-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedREgaliDBEntity(@RequestBody RegaliDBEntity entity) throws NotFoundException {
        regaliDBService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-istruzione-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneRegaliEntity(@RequestBody RegaliUsciteEntity entity) {
        if (!entity.getAltroEntities().isEmpty()) {
            altroRegaliService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getDonazioniBeneficenzaEntities().isEmpty()) {
            donazioniBeneficienzaService.deleteAll(entity.getDonazioniBeneficenzaEntities());
        }
        if (!entity.getRegaliDBEntities().isEmpty()) {
            regaliDBService.deleteAll(entity.getRegaliDBEntities());
        }
    }

    // SAVE ONE
    @PutMapping(value = "/save-one-altro-regali-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroRegaliEntity saveOneAltroRegaliEntity(@RequestBody AltroRegaliEntity entity) {
        return altroRegaliService.save(entity);
    }

    @PutMapping(value = "/save-one-lezione-indipendenti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DonazioniBeneficenzaEntity saveOneDonazioniBeneficienzaEntity(
            @RequestBody DonazioniBeneficenzaEntity entity) {
        return donazioniBeneficienzaService.save(entity);
    }

    @PutMapping(value = "/save-one-libri-istruzione-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegaliDBEntity saveOneLibriIstruzioneEntity(@RequestBody RegaliDBEntity entity) {
        return regaliDBService.save(entity);
    }

    @PutMapping(value = "/save-one-istruzione-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegaliUsciteEntity saveOneIstruzioneEntity(@RequestBody RegaliUsciteEntity entity) {
        altroRegaliService.saveAll(entity.getAltroEntities());
        donazioniBeneficienzaService.saveAll(entity.getDonazioniBeneficenzaEntities());
        regaliDBService.saveAll(entity.getRegaliDBEntities());

        return entity;
    }
}
