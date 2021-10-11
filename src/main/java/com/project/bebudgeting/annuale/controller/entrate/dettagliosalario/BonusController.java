package com.project.bebudgeting.annuale.controller.entrate.dettagliosalario;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.BonusService;

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

@Api(value = "Bonus", tags = "Bonus", description = "REST APIs related to Bonus Entity")
@RestController
@RequestMapping("/bonus")
public class BonusController {
    @Autowired
    BonusService bonusService;

    // DELETE
    @DeleteMapping(value = "/delete-all")
    public void deleteAll() {
        bonusService.deleteAll();
    }

    @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody BonusEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bonusService.delete(entity);
    }

    @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<BonusEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bonusService.deleteAll(entities);
    }

    @DeleteMapping(value = "/delete-one-entity-by-Id")
    public void deleteOneEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bonusService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        bonusService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BonusEntity addOneEntity(@RequestBody BonusEntity entity) {
        return bonusService.save(entity);
    }

    @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BonusEntity> addMoreEntity(@RequestBody Iterable<BonusEntity> entities) {
        return bonusService.saveAll(entities);
    }
}
