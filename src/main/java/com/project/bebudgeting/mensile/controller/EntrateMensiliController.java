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

    // FIND
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
    @DeleteMapping(value = "/deleteallentrateeffettive")
    public void deleteAllEntarteEffettve() {
        entrateEffettiveService.deleteAll();
    }

    @DeleteMapping(value = "/deleteoneentrateeffettiveentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody EntrateEffettiveEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.delete(entity);
    }

    @DeleteMapping(value = "/deletesomeeffettiveentityentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<EntrateEffettiveEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteeffettiveentityentitybyid")
    public void getFilteredSumEstimatedRevenueByDate(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteById(id);
    }

    @DeleteMapping(value = "/deletesomeeffettiveentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteAllById(entitiesId);
    }
}
