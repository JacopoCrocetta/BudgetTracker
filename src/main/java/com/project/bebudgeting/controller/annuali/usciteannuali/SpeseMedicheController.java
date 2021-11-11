package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.SpeseMedicheEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.AltroSpeseMedicheEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.CureSpecialisticheEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.FarmaciEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.AltreSpeseMedicheService;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.CureSpecialisticheService;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.DottoriService;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.EmergenzeService;
import com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice.FarmaciService;

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

@Api(value = "Spese Mediche", tags = "Spese Mediche", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/spese-mediche")
public class SpeseMedicheController {
    @Autowired
    AltreSpeseMedicheService altreSpeseMedicheService;

    @Autowired
    CureSpecialisticheService cureSpecialisticheService;

    @Autowired
    DottoriService dottoriService;

    @Autowired
    EmergenzeService emergenzeService;

    @Autowired
    FarmaciService farmaciService;

    /**
     * @return Iterable<AltroSpeseMedicheEntity>
     */
    // FIND ALL
    @GetMapping(value = "/get-all-altre-spese-mediche-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroSpeseMedicheEntity> getAllAltreSpeseMedicheEntities() {
        return altreSpeseMedicheService.findAll();
    }

    /**
     * @return Iterable<CureSpecialisticheEntity>
     */
    @GetMapping(value = "/get-all-cure-specialistiche-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CureSpecialisticheEntity> getAllCureSpecialisticheEntities() {
        return cureSpecialisticheService.findAll();
    }

    /**
     * @return Iterable<DottoriEntity>
     */
    @GetMapping(value = "/get-all-dottori-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DottoriEntity> getAllDottoriEntities() {
        return dottoriService.findAll();
    }

    /**
     * @return Iterable<EmergenzeEntity>
     */
    @GetMapping(value = "/get-all-emergenze-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EmergenzeEntity> getAllEmergenzeEntities() {
        return emergenzeService.findAll();
    }

    /**
     * @return Iterable<FarmaciEntity>
     */
    @GetMapping(value = "/get-all-farmaci-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FarmaciEntity> getAllFarmaciEntities() {
        return farmaciService.findAll();
    }

    /**
     * @param ids
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-altre-spese-mediche-istruzione-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltreSpeseMedicheEntities(@RequestBody Iterable<Integer> ids) {
        altreSpeseMedicheService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-cure-specialostiche-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllCureSpecialisticheEntities(@RequestBody Iterable<Integer> ids) {
        cureSpecialisticheService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-dottori-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllDottoriEntities(@RequestBody Iterable<Integer> ids) {
        dottoriService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-emergenze-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllEmergenzeEntities(@RequestBody Iterable<Integer> ids) {
        emergenzeService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-farmaci-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFarmaciEntities(@RequestBody Iterable<Integer> ids) {
        farmaciService.deleteAllById(ids);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-altro-spese-mediche-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedAltroSpeseMedicheEntity(@RequestBody AltroSpeseMedicheEntity entity)
            throws NotFoundException {
        altreSpeseMedicheService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-lezione-indipendenti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedCureSpecilisticheEntity(@RequestBody CureSpecialisticheEntity entity)
            throws NotFoundException {
        cureSpecialisticheService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-dottori-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedDottotiEntity(@RequestBody DottoriEntity entity) throws NotFoundException {
        dottoriService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-emergenze-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedEmergenzeEntity(@RequestBody EmergenzeEntity entity) throws NotFoundException {
        emergenzeService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-farmaci-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedFarmaciEntity(@RequestBody FarmaciEntity entity) throws NotFoundException {
        farmaciService.delete(entity);
    }

    /**
     * @param entity
     */
    @DeleteMapping(value = "/delete-one-spese-mediche-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSpeseMedicheEntity(@RequestBody SpeseMedicheEntity entity) {
        if (!entity.getAltroEntities().isEmpty()) {
            altreSpeseMedicheService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getCureSpecialisticheEntities().isEmpty()) {
            cureSpecialisticheService.deleteAll(entity.getCureSpecialisticheEntities());
        }
        if (!entity.getDottoriEntities().isEmpty()) {
            dottoriService.deleteAll(entity.getDottoriEntities());
        }
        if (!entity.getEmergenzeEntities().isEmpty()) {
            emergenzeService.deleteAll(entity.getEmergenzeEntities());
        }
        if (!entity.getFarmaciEntities().isEmpty()) {
            farmaciService.deleteAll(entity.getFarmaciEntities());
        }
    }

    /**
     * @param entity
     * @return AltroSpeseMedicheEntity
     */
    // SAVE ONE
    @PutMapping(value = "/save-one-altro-spese-mediche-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroSpeseMedicheEntity saveOneAltroSpeseMedicheEntity(@RequestBody AltroSpeseMedicheEntity entity) {
        return altreSpeseMedicheService.save(entity);
    }

    /**
     * @param entity
     * @return CureSpecialisticheEntity
     */
    @PutMapping(value = "/save-one-cure-specialistiche-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CureSpecialisticheEntity saveOneLezioniIndipendentiEntity(@RequestBody CureSpecialisticheEntity entity) {
        return cureSpecialisticheService.save(entity);
    }

    /**
     * @param entity
     * @return DottoriEntity
     */
    @PutMapping(value = "/save-one-dottori-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DottoriEntity saveOneLibriIstruzioneEntity(@RequestBody DottoriEntity entity) {
        return dottoriService.save(entity);
    }

    /**
     * @param entity
     * @return EmergenzeEntity
     */
    @PutMapping(value = "/save-one-emergenze-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmergenzeEntity saveOneEmergenzeEntity(@RequestBody EmergenzeEntity entity) {
        return emergenzeService.save(entity);
    }

    /**
     * @param entity
     * @return SpeseMedicheEntity
     */
    @PutMapping(value = "/save-one-spese-mediche-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SpeseMedicheEntity saveOneIstruzioneEntity(@RequestBody SpeseMedicheEntity entity) {
        altreSpeseMedicheService.saveAll(entity.getAltroEntities());
        cureSpecialisticheService.saveAll(entity.getCureSpecialisticheEntities());
        dottoriService.saveAll(entity.getDottoriEntities());
        emergenzeService.saveAll(entity.getEmergenzeEntities());
        farmaciService.saveAll(entity.getFarmaciEntities());

        return entity;
    }
}
