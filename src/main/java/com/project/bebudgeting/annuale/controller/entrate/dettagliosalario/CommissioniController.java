package com.project.bebudgeting.annuale.controller.entrate.dettagliosalario;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.CommissioniService;

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

@Api(value = "Commissioni", tags = "Commissioni", description = "REST APIs related to Commissioni Entity")
@RestController
@RequestMapping("/commissioni")
public class CommissioniController {
    @Autowired
    CommissioniService commissioniService;

    // DELETE
    @DeleteMapping(value = "/deleteAllDividendiEntities")
    public void deleteAll() {
        commissioniService.deleteAll();
    }

    @DeleteMapping(value = "/deleteOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody CommissioniEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        commissioniService.delete(entity);
    }

    @DeleteMapping(value = "/deleteSomeDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<CommissioniEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        commissioniService.deleteAll(entities);
    }

    @DeleteMapping(value = "/deleteOneDividendiEntityById")
    public void deleteOneDividendiEntityById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        commissioniService.deleteById(id);
    }

    @DeleteMapping(value = "/deleteSomeDividendiEntitiesByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeDividendiEntitiesByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        commissioniService.deleteAllById(entitiesId);
    }

    // SAVE
    @PutMapping(value = "/saveOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommissioniEntity addOneEntity(@RequestBody CommissioniEntity entity) {
        return commissioniService.save(entity);
    }

    @PutMapping(value = "/saveMoreDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CommissioniEntity> addMoreEntity(@RequestBody Iterable<CommissioniEntity> entities) {
        return commissioniService.saveAll(entities);
    }
}
