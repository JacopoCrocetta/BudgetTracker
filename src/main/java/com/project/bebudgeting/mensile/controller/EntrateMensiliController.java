package com.project.bebudgeting.mensile.controller;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.EntrateEffettiveEntity;
import com.project.bebudgeting.mensile.entity.previsti.EntratePrevisteEntity;
import com.project.bebudgeting.mensile.service.effettivi.EntrateEffettiveService;
import com.project.bebudgeting.mensile.service.previsti.EntratePrevisteService;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/entratemensili")
public class EntrateMensiliController {
    @Autowired
    EntrateEffettiveService entrateEffettiveService;

    @Autowired
    EntratePrevisteService entratePrevisteService;

    // COUNT
    // Entrate Effettive
    @GetMapping(value = "/getcountentrateeffettiveservice", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCountEntrateEffettiveService() {
        return entrateEffettiveService.count();
    }

    // Entrate Previste
    @GetMapping(value = "/getcountentrateprevisteservice", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCountEntratePrevisteService() {
        return entratePrevisteService.count();
    }

    // FIND
    // Entrate Effettive
    @GetMapping(value = "/getallentrateeffettive", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateEffettiveEntity> findAllEntrateEffettive() {
        return entrateEffettiveService.findAll();
    }

    @GetMapping(value = "/getallentrateeffettivebyids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateEffettiveEntity> findAllEntrateEffettiveByIds(@RequestBody Iterable<Integer> ids) {
        return entrateEffettiveService.findAllById(ids);
    }

    @GetMapping(value = "/getentrateeffettivebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EntrateEffettiveEntity> findEntrateEffettiveById(@RequestParam int id) {
        return entrateEffettiveService.findById(id);
    }

    // Entrate Previste
    @GetMapping(value = "/getallentratepreviste", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntratePrevisteEntity> findAllEntratePreviste() {
        return entratePrevisteService.findAll();
    }

    @GetMapping(value = "/getallentrateprevistebyids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntratePrevisteEntity> findAllEntratePrevisteByIds(@RequestBody Iterable<Integer> ids) {
        return entratePrevisteService.findAllById(ids);
    }

    @GetMapping(value = "/getentrateprevistebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EntratePrevisteEntity> findEntratePrevisteById(@RequestParam int id) {
        return entratePrevisteService.findById(id);
    }

    // DELETE
    // Entrate Effettive
    @DeleteMapping(value = "/deleteallentrateeffettive")
    public void deleteAllEntarteEffettve() {
        entrateEffettiveService.deleteAll();
    }

    @DeleteMapping(value = "/deleteoneentrateeffettiveentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntrataEffettiva(@RequestBody EntrateEffettiveEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.delete(entity);
    }

    @DeleteMapping(value = "/deletesomeeffettiveentityentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntrateEffettive(@RequestBody Iterable<EntrateEffettiveEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteeffettiveentityentitybyid")
    public void deleteOneEntrataEffettivaById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteById(id);
    }

    @DeleteMapping(value = "/deletesomeeffettiveentitybyids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntrateEffettiveByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteAllById(entitiesId);
    }

    // Entrate Previste
    @DeleteMapping(value = "/deleteallentratepreviste")
    public void deleteAllEntartePreviste() {
        entratePrevisteService.deleteAll();
    }

    @DeleteMapping(value = "/deleteoneentrataprevistaentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntrataPrevistaEntity(@RequestBody EntratePrevisteEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.delete(entity);
    }

    @DeleteMapping(value = "/deletesomeprevisteentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<EntratePrevisteEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteentrateprevisteentityentitybyid")
    public void getFilteredSumEstimatedRevenueByDate(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteentrateprevisteentityentitybyids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteAllById(entitiesId);
    }

    // SAVE
    // Entrate Effettive
    @PutMapping(value = "/saveoneentrataeffettiva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity saveOneEntrataEffettivaEntity(@RequestBody EntrateEffettiveEntity entityToSave) {
        return entrateEffettiveService.save(entityToSave);
    }

    @PutMapping(value = "/savesomeentrateeffettive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateEffettiveEntity> saveSomeEntrateEffettiveEntities(
            @RequestBody Iterable<EntrateEffettiveEntity> entitiesToSave) {
        return entrateEffettiveService.saveAll(entitiesToSave);
    }

    // Entrate Previste
    @PutMapping(value = "/saveoneentrataeffettiva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity saveOneEntrataPrevistaEntity(@RequestBody EntratePrevisteEntity entityToSave) {
        return entratePrevisteService.save(entityToSave);
    }

    @PutMapping(value = "/savesomeentrateeffettive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntratePrevisteEntity> saveSomeEntratePrevisteEntities(
            @RequestBody Iterable<EntratePrevisteEntity> entitiesToSave) {
        return entratePrevisteService.saveAll(entitiesToSave);
    }
}
