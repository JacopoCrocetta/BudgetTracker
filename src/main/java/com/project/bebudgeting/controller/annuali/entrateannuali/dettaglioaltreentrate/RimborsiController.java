package com.project.bebudgeting.controller.annuali.entrateannuali.dettaglioaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.RimborsiService;

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

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody RimborsiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<RimborsiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.deleteAll(entities);
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
        rimborsiService.deleteById(id);
    }

    /**
     * @param entitiesId
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        rimborsiService.deleteAllById(entitiesId);
    }

    /**
     * @param entity
     * @return RimborsiEntity
     */
    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RimborsiEntity addOneEntity(@RequestBody RimborsiEntity entity) {
        return rimborsiService.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RimborsiEntity>
     */
    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RimborsiEntity> addMoreEntity(@RequestBody Iterable<RimborsiEntity> entities) {
        return rimborsiService.saveAll(entities);
    }
}
