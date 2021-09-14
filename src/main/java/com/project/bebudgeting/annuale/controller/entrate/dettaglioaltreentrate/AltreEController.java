package com.project.bebudgeting.annuale.controller.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice.AltroEService;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/altroaltreentrate")
public class AltreEController {
    @Autowired
    AltroEService altroEService;

    // DELETE
    @DeleteMapping(value = "/deleteAllAltroAltreEntrateEntities")
    public void deleteAll() {
        altroEService.deleteAll();
    }

    @DeleteMapping(value = "/deleteOneAltroAltreEntrateEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody AltroAltreEntrateEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroEService.delete(entity);
    }

    @DeleteMapping(value = "/deleteSomeAltroAltreEntrateEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<AltroAltreEntrateEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroEService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteAltroAltreEntrateEntityById")
    public void getFilteredSumEstimatedRevenueByDate(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroEService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteSomeAltroAltreEntrateEntityByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroEService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/saveOneAltroAltreEntrateEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroAltreEntrateEntity addOneEntity(@RequestBody AltroAltreEntrateEntity entity) {
        return altroEService.save(entity);
    }

    @PutMapping(value = "/saveMoreAltroAltreEntrateEntities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroAltreEntrateEntity> addMoreEntity(@RequestBody Iterable<AltroAltreEntrateEntity> entities) {
        return altroEService.saveAll(entities);
    }
}
