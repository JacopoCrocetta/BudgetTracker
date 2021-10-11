package com.project.bebudgeting.annuale.controller.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice.RimborsiService;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

@Api(value = "Rimborsi", tags = "Rimborsi", description = "REST APIs related to Rimborsi Entity")
@RestController
@RequestMapping("/rimborsi")
public class RimborsiController {
    @Autowired
    RimborsiService rimborsiService;

    // DELETE
    @DeleteMapping(value = "/delete-all-entities")
    public void deleteAll() {
        rimborsiService.deleteAll();
    }

    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody RimborsiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<RimborsiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.deleteAll(entities);
    }

    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RimborsiEntity addOneEntity(@RequestBody RimborsiEntity entity) {
        return rimborsiService.save(entity);
    }

    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RimborsiEntity> addMoreEntity(@RequestBody Iterable<RimborsiEntity> entities) {
        return rimborsiService.saveAll(entities);
    }
}
