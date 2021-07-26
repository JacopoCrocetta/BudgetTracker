package com.project.bebudgeting.annuale.controller;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.service.EntrateAnnualiService;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javassist.NotFoundException;

import java.util.Optional;

@RestController
@RequestMapping("/entrateAnnuali")
public class EntrateBudgetController {
    @Autowired
    EntrateAnnualiService entrateAnnualiService;

    // FIND
    @GetMapping(value = "/getAllEntrate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateAnnualiEntity> findAll() {
        return entrateAnnualiService.findAll();
    }

    @GetMapping(value = "/getAllEntrateById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateAnnualiEntity> findAll(@RequestBody Iterable<Integer> ids) {
        return entrateAnnualiService.findAllById(ids);
    }

    @GetMapping(value = "/getEntrateById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EntrateAnnualiEntity> findById(@RequestParam int id) {
        return entrateAnnualiService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        entrateAnnualiService.deleteAll();
    }

    @DeleteMapping(value = "/deleteOneEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody EntrateAnnualiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateAnnualiService.delete(entity);
    }

    @DeleteMapping(value = "/deleteSomeEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<EntrateAnnualiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateAnnualiService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteById")
    public void getFilteredSumEstimatedRevenueByDate(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateAnnualiService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteSomeEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateAnnualiService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/saveOneEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateAnnualiEntity addOneEntity(@RequestBody EntrateAnnualiEntity entity) {
        return entrateAnnualiService.save(entity);
    }

    @PutMapping(value = "/saveMoreEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateAnnualiEntity> addMoreEntity(@RequestBody Iterable<EntrateAnnualiEntity> entities) {
        return entrateAnnualiService.saveAll(entities);
    }
}
