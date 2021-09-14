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

import javassist.NotFoundException;

@RestController
@RequestMapping("/trasferimentirisparmi")
public class TrasferimentiRisparmiController {
    @Autowired
    TrasferimentoRisparmiService trasferimentoRisparmiService;

    // DELETE
    @DeleteMapping(value = "/deleteAllDividendiEntities")
    public void deleteAll() {
        trasferimentoRisparmiService.deleteAll();
    }

    @DeleteMapping(value = "/deleteOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody TrasferimentoRisparmiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.delete(entity);
    }

    @DeleteMapping(value = "/deleteSomeDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<TrasferimentoRisparmiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteOneDividendiEntityById")
    public void deleteOneDividendiEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteSomeDividendiEntitiesByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeDividendiEntitiesByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        trasferimentoRisparmiService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/saveOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrasferimentoRisparmiEntity addOneEntity(@RequestBody TrasferimentoRisparmiEntity entity) {
        return trasferimentoRisparmiService.save(entity);
    }

    @PutMapping(value = "/saveMoreDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TrasferimentoRisparmiEntity> addMoreEntity(
            @RequestBody Iterable<TrasferimentoRisparmiEntity> entities) {
        return trasferimentoRisparmiService.saveAll(entities);
    }
}
