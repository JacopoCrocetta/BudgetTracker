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
        @DeleteMapping(value = "/delete-all")
        public void deleteAll() {
                dividendiService.deleteAll();
        }

        @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteOneEntity(@RequestBody DividendiEntity entity)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.delete(entity);
        }

        @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteSomeEntity(@RequestBody Iterable<DividendiEntity> entities)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.deleteAll(entities);
        }

        @DeleteMapping(value = "/delete-one-entity-by-Id")
        public void deleteOneEntityById(@RequestParam int id)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.deleteById(id);
        }

        @DeleteMapping(value = "/elete-some-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteSomeEntityByIds(@RequestBody Iterable<Integer> entitiesId)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                dividendiService.deleteAllById(entitiesId);
        }

        // SAVE
        @PutMapping(value = "/save-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public DividendiEntity addOneEntity(@RequestBody DividendiEntity entity) {
                return dividendiService.save(entity);
        }

        @PutMapping(value = "/save-more-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public Iterable<DividendiEntity> addMoreEntity(@RequestBody Iterable<DividendiEntity> entities) {
                return dividendiService.saveAll(entities);
        }
}
