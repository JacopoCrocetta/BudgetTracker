package com.project.bebudgeting.controller.annuali.entrateannuali.dettagliosalario;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.ManceEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.ManceService;

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

@Api(value = "Mance", tags = "Mance", description = "REST APIs related to Mance Entity")
@RestController
@RequestMapping("/mance")
public class ManceController {
    @Autowired
    ManceService manceService;

    // DELETE
    @DeleteMapping(value = "/delete-all")
    public void deleteAll() {
        manceService.deleteAll();
    }

    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody ManceEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        manceService.delete(entity);
    }

    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<ManceEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        manceService.deleteAll(entities);
    }

    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        manceService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        manceService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManceEntity addOneEntity(@RequestBody ManceEntity entity) {
        return manceService.save(entity);
    }

    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ManceEntity> addMoreEntity(@RequestBody Iterable<ManceEntity> entities) {
        return manceService.saveAll(entities);
    }
}
