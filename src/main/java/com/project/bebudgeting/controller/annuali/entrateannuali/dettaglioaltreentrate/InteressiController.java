package com.project.bebudgeting.controller.annuali.entrateannuali.dettaglioaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.InteressiService;

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

@Api(value = "Interessi", tags = "Interessi", description = "REST APIs related to Interessi Entity")
@RestController
@RequestMapping("/interessi")
public class InteressiController {
    @Autowired
    InteressiService interessiService;

    // DELETE
    @DeleteMapping(value = "/delete-all-entities")
    public void deleteAll() {
        interessiService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody InteressiEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        interessiService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<InteressiEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        interessiService.deleteAll(entities);
    }

    /**
     * @param id
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneDividendiEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        interessiService.deleteById(id);
    }

    /**
     * @param entitiesId
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeDividendiEntitiesByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        interessiService.deleteAllById(entitiesId);
    }

    /**
     * @param entity
     * @return InteressiEntity
     */
    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InteressiEntity addOneEntity(@RequestBody InteressiEntity entity) {
        return interessiService.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<InteressiEntity>
     */
    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<InteressiEntity> addMoreEntity(@RequestBody Iterable<InteressiEntity> entities) {
        return interessiService.saveAll(entities);
    }
}
