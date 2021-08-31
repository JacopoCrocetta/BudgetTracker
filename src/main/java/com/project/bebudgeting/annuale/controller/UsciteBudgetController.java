package com.project.bebudgeting.annuale.controller;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;
import com.project.bebudgeting.annuale.service.UsciteAnnualiService;

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
@RequestMapping("/usciteAnnuali")
public class UsciteBudgetController {
    @Autowired
    UsciteAnnualiService usciteAnnualiService;

    // FIND
    @GetMapping(value = "/getAllUsciteAnnualiEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UsciteAnnualiEntity> findAll() {
        return usciteAnnualiService.findAll();
    }

    @GetMapping(value = "/getAllUsciteAnnualiEntityById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UsciteAnnualiEntity> findAll(@RequestBody Iterable<Integer> ids) {
        return usciteAnnualiService.findAllById(ids);
    }

    @GetMapping(value = "/getUsciteAnnualiEntityById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<UsciteAnnualiEntity> findById(@RequestParam int id) {
        return usciteAnnualiService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "/deleteAllUsciteAnnualiEntity")
    public void deleteAll() {
        usciteAnnualiService.deleteAll();
    }

    @DeleteMapping(value = "/deleteOneUsciteAnnualiEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody UsciteAnnualiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteAnnualiService.delete(entity);
    }

    @DeleteMapping(value = "/deleteSomeUsciteAnnualiEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<UsciteAnnualiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteAnnualiService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteUsciteAnnualiEntityById")
    public void getFilteredSumEstimatedRevenueByDate(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteAnnualiService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteSomeUsciteAnnualiEntityByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteAnnualiService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/saveOneUsciteAnnualiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsciteAnnualiEntity addOneEntity(@RequestBody UsciteAnnualiEntity entity) {
        return usciteAnnualiService.save(entity);
    }

    @PutMapping(value = "/saveMoreUsciteAnnualiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UsciteAnnualiEntity> addMoreEntity(@RequestBody Iterable<UsciteAnnualiEntity> entities) {
        return usciteAnnualiService.saveAll(entities);
    }
}
