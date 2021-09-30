package com.project.bebudgeting.annuale.controller.entrate.dettagliosalario;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.BustaPagaService;

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

@Api(value = "Busta paga", tags = "Busta paga", description = "REST APIs related to Busta Paga Entity")
@RestController
@RequestMapping("/bustapaga")
public class BustaPagaController {
    @Autowired
    BustaPagaService bustaPagaService;

    // DELETE
    @DeleteMapping(value = "/deleteAllDividendiEntities")
    public void deleteAll() {
        bustaPagaService.deleteAll();
    }

    @DeleteMapping(value = "/deleteOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody BustaPagaEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bustaPagaService.delete(entity);
    }

    @DeleteMapping(value = "/deleteSomeDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<BustaPagaEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bustaPagaService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteOneDividendiEntityById")
    public void deleteOneDividendiEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bustaPagaService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteSomeDividendiEntitiesByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeDividendiEntitiesByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bustaPagaService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/saveOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BustaPagaEntity addOneEntity(@RequestBody BustaPagaEntity entity) {
        return bustaPagaService.save(entity);
    }

    @PutMapping(value = "/saveMoreDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BustaPagaEntity> addMoreEntity(@RequestBody Iterable<BustaPagaEntity> entities) {
        return bustaPagaService.saveAll(entities);
    }
}
