package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.IstruzioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LibriIstruzioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.RetteEntity;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.AltroIstruzioneService;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.LezioniIndipendentiService;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.LibriIstruzioneService;
import com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice.RetteService;

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

    /**
     * @return Iterable<AltroIstruzioneEntity>
     */
    // FIND ALL
    @GetMapping(value = "/get-all-altro-istruzione-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroIstruzioneEntity> getAllAltroIstruzioneEntities() {
        return altroIstruzioneService.findAll();
    }

    /**
     * @return Iterable<LezioniIndipendentiEntity>
     */
    @GetMapping(value = "/get-all-lezioni-indipendenti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LezioniIndipendentiEntity> getAllLezioniIndipedentiEntities() {
        return lezioniIndipendentiService.findAll();
    }

    /**
     * @return Iterable<LibriIstruzioneEntity>
     */
    @GetMapping(value = "/get-all-libri-istruzione-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LibriIstruzioneEntity> getAllLibriIstruzioneEntities() {
        return libriIstruzioneService.findAll();
    }

    /**
     * @return Iterable<RetteEntity>
     */
    @GetMapping(value = "/get-all-rette-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RetteEntity> getAllRetteEntities() {
        return retteService.findAll();
    }

    /**
     * @param ids
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-altro-istruzione-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroIstruzioneEntities(@RequestBody Iterable<Integer> ids) {
        altroIstruzioneService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-lezioni-indipendenti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllLezioniIndipendentiEntities(@RequestBody Iterable<Integer> ids) {
        lezioniIndipendentiService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-libri-istruzione-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllLibriIstruzioneEntities(@RequestBody Iterable<Integer> ids) {
        libriIstruzioneService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-rette-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllRetteEntities(@RequestBody Iterable<Integer> ids) {
        retteService.deleteAllById(ids);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-altro-istruzione-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedAltroIstruzioneEntity(@RequestBody AltroIstruzioneEntity entity)
            throws NotFoundException {
        altroIstruzioneService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-lezione-indipendenti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedLezioneIndipendenteEntity(@RequestBody LezioniIndipendentiEntity entity)
            throws NotFoundException {
        lezioniIndipendentiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-libri-istruzione-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedLibriIstruzioneEntity(@RequestBody LibriIstruzioneEntity entity)
            throws NotFoundException {
        libriIstruzioneService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-rette-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedRetteEntity(@RequestBody RetteEntity entity) throws NotFoundException {
        retteService.delete(entity);
    }

    /**
     * @param entity
     */
    @DeleteMapping(value = "/delete-one-istruzione-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneIstruzioneEntity(@RequestBody IstruzioneEntity entity) {
        if (!entity.getAltroEntities().isEmpty()) {
            altroIstruzioneService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getLezioniIndipendentiEntities().isEmpty()) {
            lezioniIndipendentiService.deleteAll(entity.getLezioniIndipendentiEntities());
        }
        if (!entity.getLibriEntities().isEmpty()) {
            libriIstruzioneService.deleteAll(entity.getLibriEntities());
        }
        if (!entity.getRetteEntities().isEmpty()) {
            retteService.deleteAll(entity.getRetteEntities());
        }
    }

    /**
     * @param entity
     * @return AltroIstruzioneEntity
     */
    // SAVE ONE
    @PutMapping(value = "/save-one-altro-istruzione-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroIstruzioneEntity saveOneAltroIstruzioneEntity(@RequestBody AltroIstruzioneEntity entity) {
        return altroIstruzioneService.save(entity);
    }

    /**
     * @param entity
     * @return LezioniIndipendentiEntity
     */
    @PutMapping(value = "/save-one-lezione-indipendenti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LezioniIndipendentiEntity saveOneLezioniIndipendentiEntity(@RequestBody LezioniIndipendentiEntity entity) {
        return lezioniIndipendentiService.save(entity);
    }

    /**
     * @param entity
     * @return LibriIstruzioneEntity
     */
    @PutMapping(value = "/save-one-libri-istruzione-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LibriIstruzioneEntity saveOneLibriIstruzioneEntity(@RequestBody LibriIstruzioneEntity entity) {
        return libriIstruzioneService.save(entity);
    }

    /**
     * @param entity
     * @return RetteEntity
     */
    @PutMapping(value = "/save-one-rette-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RetteEntity saveOneRetteEntity(@RequestBody RetteEntity entity) {
        return retteService.save(entity);
    }

    /**
     * @param entity
     * @return IstruzioneEntity
     */
    @PutMapping(value = "/save-one-istruzione-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public IstruzioneEntity saveOneIstruzioneEntity(@RequestBody IstruzioneEntity entity) {
        altroIstruzioneService.saveAll(entity.getAltroEntities());
        lezioniIndipendentiService.saveAll(entity.getLezioniIndipendentiEntities());
        libriIstruzioneService.saveAll(entity.getLibriEntities());
        retteService.saveAll(entity.getRetteEntities());

        return entity;
    }
}
