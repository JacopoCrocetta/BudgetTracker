package com.project.bebudgeting.annuale.controller.entrate.dettagliosalario;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.AltroSalarioService;

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

@Api(value = "Altro salario", tags = "Altro salario", description = "REST APIs related to Altro Salario Entity")
@RestController
@RequestMapping("/altro-salario")
public class AltroSalarioController {
    @Autowired
    AltroSalarioService altroSalarioService;

    // DELETE
    @DeleteMapping(value = "/delete-all")
    public void deleteAll() {
        altroSalarioService.deleteAll();
    }

    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody AltroSalarioEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.delete(entity);
    }

    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<AltroSalarioEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.deleteAll(entities);
    }

    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroSalarioEntity addOneEntity(@RequestBody AltroSalarioEntity entity) {
        return altroSalarioService.save(entity);
    }

    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroSalarioEntity> addMoreEntity(@RequestBody Iterable<AltroSalarioEntity> entities) {
        return altroSalarioService.saveAll(entities);
    }
}
