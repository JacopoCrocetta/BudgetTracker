package com.project.bebudgeting.controller.annuali.entrateannuali.dettagliosalario;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.BustaPagaService;

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
@RequestMapping("/busta-paga")
public class BustaPagaController {
    @Autowired
    BustaPagaService bustaPagaService;

    // DELETE
    @DeleteMapping(value = "/delete-all")
    public void deleteAll() {
        bustaPagaService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody BustaPagaEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bustaPagaService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<BustaPagaEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bustaPagaService.deleteAll(entities);
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
        bustaPagaService.deleteById(id);
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
        bustaPagaService.deleteAllById(entitiesId);
    }

    /**
     * @param entity
     * @return BustaPagaEntity
     */
    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BustaPagaEntity addOneEntity(@RequestBody BustaPagaEntity entity) {
        return bustaPagaService.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BustaPagaEntity>
     */
    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BustaPagaEntity> addMoreEntity(@RequestBody Iterable<BustaPagaEntity> entities) {
        return bustaPagaService.saveAll(entities);
    }
}
