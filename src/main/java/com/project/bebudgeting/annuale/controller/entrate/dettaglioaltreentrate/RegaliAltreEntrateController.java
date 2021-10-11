package com.project.bebudgeting.annuale.controller.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice.RegaliAltreEntrateService;

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

    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody RegaliAltreEntrateEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        regaliAltreEntrateService.delete(entity);
    }

    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<RegaliAltreEntrateEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        regaliAltreEntrateService.deleteAll(entities);
    }

    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        regaliAltreEntrateService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        regaliAltreEntrateService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegaliAltreEntrateEntity addOneEntity(@RequestBody RegaliAltreEntrateEntity entity) {
        return regaliAltreEntrateService.save(entity);
    }

    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RegaliAltreEntrateEntity> addMoreEntity(@RequestBody Iterable<RegaliAltreEntrateEntity> entities) {
        return regaliAltreEntrateService.saveAll(entities);
    }
}
