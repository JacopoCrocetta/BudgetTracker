package com.project.bebudgeting.controller.mensili;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.UsciteEffettiveEntity;
import com.project.bebudgeting.entity.mensili.previsti.UscitePrevisteEntity;
import com.project.bebudgeting.service.mensili.effettivi.UsciteEffettiveService;
import com.project.bebudgeting.service.mensili.previsti.UscitePrevisteService;

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
@RequestMapping("/uscitemensili")
public class UsciteMensiliController {
    @Autowired
    UsciteEffettiveService usciteEffettiveService;

    @Autowired
    UscitePrevisteService uscitePrevisteService;

    /**
     * @return long
     */
    // COUNT
    // Uscite Effettive
    @GetMapping(value = "/getcountusciteeffettive", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCountUsciteEffettive() {
        return usciteEffettiveService.count();
    }

    /**
     * @return long
     */
    // Uscite Previste
    @GetMapping(value = "/getcountuscitepreviste", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCountUscitePreviste() {
        return uscitePrevisteService.count();
    }

    /**
     * @return Iterable<UsciteEffettiveEntity>
     */
    // FIND
    // Uscite Effettive
    @GetMapping(value = "/getallusciteeffettive", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UsciteEffettiveEntity> findAllUsciteEffettive() {
        return usciteEffettiveService.findAll();
    }

    /**
     * @param ids
     * @return Iterable<UsciteEffettiveEntity>
     */
    @GetMapping(value = "/getallentrateeffettivebyids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UsciteEffettiveEntity> findAllUsciteEffettiveByIds(@RequestBody Iterable<Integer> ids) {
        return usciteEffettiveService.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<UsciteEffettiveEntity>
     */
    @GetMapping(value = "/getentrateeffettivebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<UsciteEffettiveEntity> findUsciteEffettiveById(@RequestParam int id) {
        return usciteEffettiveService.findById(id);
    }

    /**
     * @return Iterable<UscitePrevisteEntity>
     */
    // Uscite Previste
    @GetMapping(value = "/getallentratepreviste", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UscitePrevisteEntity> findAllUscitePreviste() {
        return uscitePrevisteService.findAll();
    }

    /**
     * @param ids
     * @return Iterable<UscitePrevisteEntity>
     */
    @GetMapping(value = "/getallentrateprevistebyids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UscitePrevisteEntity> findAllUscitePrevisteByIds(@RequestBody Iterable<Integer> ids) {
        return uscitePrevisteService.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<UscitePrevisteEntity>
     */
    @GetMapping(value = "/getentrateprevistebyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<UscitePrevisteEntity> findUscitePrevisteById(@RequestParam int id) {
        return uscitePrevisteService.findById(id);
    }

    // DELETE
    // Uscite Effettive
    @DeleteMapping(value = "/deleteallentrateeffettive")
    public void deleteAllUsciteEffettve() {
        usciteEffettiveService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteoneentrateeffettiveentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneUsciteEffettiva(@RequestBody UsciteEffettiveEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteEffettiveService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deletesomeeffettiveentityentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeUsciteEffettive(@RequestBody Iterable<UsciteEffettiveEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteEffettiveService.deleteAll(entities);
    }

    /**
     * @param id
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteeffettiveentityentitybyid")
    public void deleteOneUsciteEffettivaById(@RequestParam int id)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteEffettiveService.deleteById(id);
    }

    /**
     * @param entitiesId
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deletesomeeffettiveentitybyids", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeUsciteEffettiveByIds(@RequestBody Iterable<Integer> entitiesId)
            throws NotFoundException, NullPointerException, NotImplementedException {
        usciteEffettiveService.deleteAllById(entitiesId);
    }

    // Entrate Previste
    @DeleteMapping(value = "/deleteallentratepreviste")
    public void deleteAllUscitePreviste() {
        uscitePrevisteService.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deleteoneentrataprevistaentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneUscitePrevistaEntity(@RequestBody UscitePrevisteEntity entity)
            throws NotFoundException, NullPointerException, NotImplementedException {
        uscitePrevisteService.delete(entity);
    }

    /**
     * @param entities
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    @DeleteMapping(value = "/deletesomeprevisteentity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSomeEntity(@RequestBody Iterable<UscitePrevisteEntity> entities)
            throws NotFoundException, NullPointerException, NotImplementedException {
        uscitePrevisteService.deleteAll(entities);
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
        uscitePrevisteService.deleteById(id);
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
        uscitePrevisteService.deleteAllById(entitiesId);
    }

    /**
     * @param entityToSave
     * @return UsciteEffettiveEntity
     */
    // SAVE
    // Entrate Effettive
    @PutMapping(value = "/saveoneentrataeffettiva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsciteEffettiveEntity saveOneUsciteEffettivaEntity(@RequestBody UsciteEffettiveEntity entityToSave) {
        return usciteEffettiveService.save(entityToSave);
    }

    /**
     * @param saveSomeUsciteEffettiveEntities(
     * @return Iterable<UsciteEffettiveEntity>
     */
    @PutMapping(value = "/savesomeentrateeffettive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UsciteEffettiveEntity> saveSomeUsciteEffettiveEntities(
            @RequestBody Iterable<UsciteEffettiveEntity> entitiesToSave) {
        return usciteEffettiveService.saveAll(entitiesToSave);
    }

    /**
     * @param entityToSave
     * @return UscitePrevisteEntity
     */
    // Entrate Previste
    @PutMapping(value = "/saveoneentratapreviste", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UscitePrevisteEntity saveOneUscitePrevistaEntity(@RequestBody UscitePrevisteEntity entityToSave) {
        return uscitePrevisteService.save(entityToSave);
    }

    /**
     * @param saveSomeUscitePrevisteEntities(
     * @return Iterable<UscitePrevisteEntity>
     */
    @PutMapping(value = "/savesomeentratepreviste", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UscitePrevisteEntity> saveSomeUscitePrevisteEntities(
            @RequestBody Iterable<UscitePrevisteEntity> entitiesToSave) {
        return uscitePrevisteService.saveAll(entitiesToSave);
    }
}
