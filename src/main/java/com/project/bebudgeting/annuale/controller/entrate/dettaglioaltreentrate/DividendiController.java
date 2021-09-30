package com.project.bebudgeting.annuale.controller.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice.DividendiService;

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

@Api(value = "Dividendi", tags = "Dividendi", description = "REST APIs related to Dividendi Entity")
@RestController
@RequestMapping("/dividendi")
public class DividendiController {
        @Autowired
        DividendiService dividendiService;

        // DELETE
        @DeleteMapping(value = "/deleteAllDividendiEntities")
        public void deleteAll() {
                dividendiService.deleteAll();
        }

        @DeleteMapping(value = "/deleteOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteOneEntity(@RequestBody DividendiEntity entity)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.delete(entity);
        }

        @DeleteMapping(value = "/deleteSomeDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteSomeEntity(@RequestBody Iterable<DividendiEntity> entities)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.deleteAll(entities);
        }

        @DeleteMapping(value = "/deleteOneDividendiEntityById")
        public void deleteOneDividendiEntityById(@RequestParam int id)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.deleteById(id);
        }

        @DeleteMapping(value = "/deleteSomeDividendiEntitiesByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteSomeDividendiEntitiesByIds(@RequestBody Iterable<Integer> entitiesId)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.deleteAllById(entitiesId);
        }

        // SAVE
        @PutMapping(value = "/saveOneDividendiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public DividendiEntity addOneEntity(@RequestBody DividendiEntity entity) {
                return dividendiService.save(entity);
        }

        @PutMapping(value = "/saveMoreDividendiEntities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public Iterable<DividendiEntity> addMoreEntity(@RequestBody Iterable<DividendiEntity> entities) {
                return dividendiService.saveAll(entities);
        }
}
