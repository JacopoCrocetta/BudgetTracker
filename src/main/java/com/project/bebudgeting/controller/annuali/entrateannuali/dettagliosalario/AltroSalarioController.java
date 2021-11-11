package com.project.bebudgeting.controller.annuali.entrateannuali.dettagliosalario;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.AltroSalarioService;

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

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody AltroSalarioEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<AltroSalarioEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.deleteAll(entities);
    }

    /**
     * @param id
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.deleteById(id);
    }

    /**
     * @param entitiesId
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        altroSalarioService.deleteAllById(entitiesId);
    }

    /**
     * @param entity
     * @return AltroSalarioEntity
     */
    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroSalarioEntity addOneEntity(@RequestBody AltroSalarioEntity entity) {
        return altroSalarioService.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroSalarioEntity>
     */
    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroSalarioEntity> addMoreEntity(@RequestBody Iterable<AltroSalarioEntity> entities) {
        return altroSalarioService.saveAll(entities);
    }
}
