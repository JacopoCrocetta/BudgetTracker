package com.project.bebudgeting.controller.annuali.entrateannuali.dettaglioaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.RegaliAltreEntrateService;

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

@Api(value = "Regali altre entrate", tags = "Regali altre entrate", description = "REST APIs related to Regali Altre Entrate Entity")
@RestController
@RequestMapping("/regali-altre-entrate")
public class RegaliAltreEntrateController {
    @Autowired
    RegaliAltreEntrateService regaliAltreEntrateService;

    // DELETE
    @DeleteMapping(value = "/delete-all")
    public void deleteAll() {
        regaliAltreEntrateService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody RegaliAltreEntrateEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        regaliAltreEntrateService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<RegaliAltreEntrateEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        regaliAltreEntrateService.deleteAll(entities);
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
        regaliAltreEntrateService.deleteById(id);
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
        regaliAltreEntrateService.deleteAllById(entitiesId);
    }

    /**
     * @param entity
     * @return RegaliAltreEntrateEntity
     */
    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegaliAltreEntrateEntity addOneEntity(@RequestBody RegaliAltreEntrateEntity entity) {
        return regaliAltreEntrateService.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RegaliAltreEntrateEntity>
     */
    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RegaliAltreEntrateEntity> addMoreEntity(@RequestBody Iterable<RegaliAltreEntrateEntity> entities) {
        return regaliAltreEntrateService.saveAll(entities);
    }
}
