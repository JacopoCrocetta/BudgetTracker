package com.project.bebudgeting.controller.mensili;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.EntrateEffettiveEntity;
import com.project.bebudgeting.entity.mensili.previsti.EntratePrevisteEntity;
import com.project.bebudgeting.service.mensili.effettivi.EntrateEffettiveService;
import com.project.bebudgeting.service.mensili.previsti.EntratePrevisteService;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/entratemensili")
public class EntrateMensiliController {
    @Autowired
    EntrateEffettiveService entrateEffettiveService;

    @Autowired
    EntratePrevisteService entratePrevisteService;

    /**
     * @return long
     */
    // COUNT
    // Entrate Effettive
    @GetMapping(value = "/getcountentrateeffettiveservice", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCountEntrateEffettiveService() {
        return entrateEffettiveService.count();
    }

    /**
     * @return long
     */
    // Entrate Previste
    @GetMapping(value = "/getcountentrateprevisteservice", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCountEntratePrevisteService() {
        return entratePrevisteService.count();
    }

    /**
     * @return Iterable<EntrateEffettiveEntity>
     */
    // FIND
    // Entrate Effettive
    @GetMapping(value = "/getallentrateeffettive", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateEffettiveEntity> findAllEntrateEffettive() {
        return entrateEffettiveService.findAll();
    }

    /**
     * @param ids
     * @return Iterable<EntrateEffettiveEntity>
     */
    @GetMapping(value = "/getallentrateeffettivebyids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateEffettiveEntity> findAllEntrateEffettiveByIds(@RequestBody Iterable<Integer> ids) {
        return entrateEffettiveService.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<EntrateEffettiveEntity>
     */
    @GetMapping(value = "/getentrateeffettivebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EntrateEffettiveEntity> findEntrateEffettiveById(@RequestParam int id) {
        return entrateEffettiveService.findById(id);
    }

    /**
     * @return Iterable<EntratePrevisteEntity>
     */
    // Entrate Previste
    @GetMapping(value = "/getallentratepreviste", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntratePrevisteEntity> findAllEntratePreviste() {
        return entratePrevisteService.findAll();
    }

    /**
     * @param ids
     * @return Iterable<EntratePrevisteEntity>
     */
    @GetMapping(value = "/getallentrateprevistebyids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntratePrevisteEntity> findAllEntratePrevisteByIds(@RequestBody Iterable<Integer> ids) {
        return entratePrevisteService.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<EntratePrevisteEntity>
     */
    @GetMapping(value = "/getentrateprevistebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EntratePrevisteEntity> findEntratePrevisteById(@RequestParam int id) {
        return entratePrevisteService.findById(id);
    }

    // DELETE
    // Entrate Effettive
    @DeleteMapping(value = "/deleteallentrateeffettive")
    public void deleteAllEntarteEffettve() {
        entrateEffettiveService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteoneentrateeffettiveentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntrataEffettiva(@RequestBody EntrateEffettiveEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deletesomeeffettiveentityentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntrateEffettive(@RequestBody Iterable<EntrateEffettiveEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteAll(entities);
    }

    /**
     * @param id
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteeffettiveentityentitybyid")
    public void deleteOneEntrataEffettivaById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteById(id);
    }

    /**
     * @param entitiesId
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deletesomeeffettiveentitybyids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntrateEffettiveByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteAllById(entitiesId);
    }

    // Entrate Previste
    @DeleteMapping(value = "/deleteallentratepreviste")
    public void deleteAllEntartePreviste() {
        entratePrevisteService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteoneentrataprevistaentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntrataPrevistaEntity(@RequestBody EntratePrevisteEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deletesomeprevisteentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<EntratePrevisteEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteAll(entities);
    }

    /**
     * @param id
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteentrateprevisteentityentitybyid")
    public void getFilteredSumEstimatedRevenueByDate(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteById(id);
    }

    /**
     * @param entitiesId
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteentrateprevisteentityentitybyids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntityById(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteAllById(entitiesId);
    }

    /**
     * @param entityToSave
     * @return EntrateEffettiveEntity
     */
    // SAVE
    // Entrate Effettive
    @PutMapping(value = "/saveoneentrataeffettiva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity saveOneEntrataEffettivaEntity(@RequestBody EntrateEffettiveEntity entityToSave) {
        return entrateEffettiveService.save(entityToSave);
    }

    /**
     * @param saveSomeEntrateEffettiveEntities(
     * @return Iterable<EntrateEffettiveEntity>
     */
    @PutMapping(value = "/savesomeentrateeffettive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateEffettiveEntity> saveSomeEntrateEffettiveEntities(
            @RequestBody Iterable<EntrateEffettiveEntity> entitiesToSave) {
        return entrateEffettiveService.saveAll(entitiesToSave);
    }

    /**
     * @param entityToSave
     * @return EntratePrevisteEntity
     */
    // Entrate Previste
    @PutMapping(value = "/saveoneentrataprevista", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity saveOneEntrataPrevistaEntity(@RequestBody EntratePrevisteEntity entityToSave) {
        return entratePrevisteService.save(entityToSave);
    }

    /**
     * @param saveSomeEntratePrevisteEntities(
     * @return Iterable<EntratePrevisteEntity>
     */
    @PutMapping(value = "/savesomeentrateprevista", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntratePrevisteEntity> saveSomeEntratePrevisteEntities(
            @RequestBody Iterable<EntratePrevisteEntity> entitiesToSave) {
        return entratePrevisteService.saveAll(entitiesToSave);
    }
}
