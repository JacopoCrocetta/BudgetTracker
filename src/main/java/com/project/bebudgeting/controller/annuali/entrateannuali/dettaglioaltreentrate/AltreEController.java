package com.project.bebudgeting.controller.annuali.entrateannuali.dettaglioaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.AltroEService;

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

@Api(value = "Altro Altre Entrate", tags = "Altro Altre Entrate", description = "REST APIs related to Altre Entrate Entity")
@RestController
@RequestMapping("/altro-altre-entrate")
public class AltreEController {
        @Autowired
        AltroEService altroEService;

        // DELETE
        @DeleteMapping(value = "/delete-all")
        public void deleteAll() {
                altroEService.deleteAll();
        }

        @DeleteMapping(value = "/delete-one-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteOneEntity(@RequestBody AltroAltreEntrateEntity entity)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                altroEService.delete(entity);
        }

        @DeleteMapping(value = "/delete-some-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteSomeEntity(@RequestBody Iterable<AltroAltreEntrateEntity> entities)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                altroEService.deleteAll(entities);
        }

        @DeleteMapping(value = "/delete-one-altro-altre-entrate-entity-by-id")
        public void deleteAltroAltreEntrateEntityById(@RequestParam int id)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                altroEService.deleteById(id);
        }

        @DeleteMapping(value = "/delete-some-altro-altre-entrate-entity-by-ids", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
                        throws NotFoundException, NullPointerException, NotImplementedException {
                altroEService.deleteAllById(entitiesId);
        }

        // SAVE
        @PutMapping(value = "/save-one-altro-altre-entrate-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public AltroAltreEntrateEntity addOneEntity(@RequestBody AltroAltreEntrateEntity entity) {
                return altroEService.save(entity);
        }

        @PutMapping(value = "/save-MoreAltroAltreEntrateEntities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public Iterable<AltroAltreEntrateEntity> addMoreEntity(
                        @RequestBody Iterable<AltroAltreEntrateEntity> entities) {
                return altroEService.saveAll(entities);
        }
}
