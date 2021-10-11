package com.project.bebudgeting.annuale.controller.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice.TrasferimentoRisparmiService;

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

@Api(value = "Trasferimento risparmi", tags = "Trasferimento risparmi", description = "REST APIs related to Trasferimento Risparmi Entity")
@RestController
@RequestMapping("/trasferimento-risparmi")
public class TrasferimentiRisparmiController {
    @Autowired
    TrasferimentoRisparmiService trasferimentoRisparmiService;

    // DELETE
    @DeleteMapping(value = "/delete-all-entities")
    public void deleteAll() {
        trasferimentoRisparmiService.deleteAll();
    }

    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody TrasferimentoRisparmiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<TrasferimentoRisparmiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.deleteAll(entities);
    }

    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrasferimentoRisparmiEntity addOneEntity(@RequestBody TrasferimentoRisparmiEntity entity) {
        return trasferimentoRisparmiService.save(entity);
    }

    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TrasferimentoRisparmiEntity> addMoreEntity(
            @RequestBody Iterable<TrasferimentoRisparmiEntity> entities) {
        return trasferimentoRisparmiService.saveAll(entities);
    }
}
