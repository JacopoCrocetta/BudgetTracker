package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.SpeseQuotidianeEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AbbonamentiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AltroSpeseQuotidianeEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.LavanderiaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.ParrucchiereEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.RistorantiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.SupermercatoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.AbbonamentiService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.AltreSpeseQuotidianeService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.IgienePersonaleService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.LavanderiaService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.ParrucchiereService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.RistorantiService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.SupermercatoService;
import com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice.VestitiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

@Api(value = "Spese Quotidiane", tags = "Spese Quotidiane", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/spese-quotidiane")
public class SpeseQuotidianeController {
    @Autowired
    AbbonamentiService abbonamentiService;

    @Autowired
    AltreSpeseQuotidianeService altreSpeseQuotidianeService;

    @Autowired
    IgienePersonaleService igienePersonaleService;

    @Autowired
    LavanderiaService lavanderiaService;

    @Autowired
    ParrucchiereService parrucchiereService;

    @Autowired
    RistorantiService ristorantiService;

    @Autowired
    SupermercatoService supermercatoService;

    @Autowired
    VestitiService vestitiService;

    /**
     * @return Iterable<AbbonamentiEntity>
     */
    // FIND ALL
    @GetMapping(value = "/get-all-abbonamenti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AbbonamentiEntity> getAllAbbonamentiEntities() {
        return abbonamentiService.findAll();
    }

    /**
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    @GetMapping(value = "/get-all-altre-spese-quotidiane-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroSpeseQuotidianeEntity> getAllAltreSpeseQuotidianeEntities() {
        return altreSpeseQuotidianeService.findAll();
    }

    /**
     * @return Iterable<IgienePersonaleEntity>
     */
    @GetMapping(value = "/get-all-igiene-personale-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<IgienePersonaleEntity> getAllIgienePersonaleEntities() {
        return igienePersonaleService.findAll();
    }

    /**
     * @return Iterable<LavanderiaEntity>
     */
    @GetMapping(value = "/get-all-lavanderia-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LavanderiaEntity> getAllLavanderiaEntities() {
        return lavanderiaService.findAll();
    }

    /**
     * @return Iterable<ParrucchiereEntity>
     */
    @GetMapping(value = "/get-all-parrucchiere-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ParrucchiereEntity> getAllParrucchiereEntities() {
        return parrucchiereService.findAll();
    }

    /**
     * @return Iterable<RistorantiEntity>
     */
    @GetMapping(value = "/get-all-ristoranti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RistorantiEntity> getAllRistorantiEntities() {
        return ristorantiService.findAll();
    }

    /**
     * @return Iterable<SupermercatoEntity>
     */
    @GetMapping(value = "/get-all-supermercato-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SupermercatoEntity> getAllSupermercatoEntities() {
        return supermercatoService.findAll();
    }

    /**
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    @GetMapping(value = "/get-all-vestiti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<VestitiSpeseQuotidianeEntity> getAllVestitiSpeseQuotidianeEntities() {
        return vestitiService.findAll();
    }

    /**
     * @param ids
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-abbonamenti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAbbonamentiEntities(@RequestBody Iterable<Integer> ids) {
        abbonamentiService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-altre-spese-quotidiane-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltreSpeseQuotidianeEntities(@RequestBody Iterable<Integer> ids) {
        altreSpeseQuotidianeService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-igiene-personale-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllIgienePersonaleEntities(@RequestBody Iterable<Integer> ids) {
        igienePersonaleService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-lavanderia-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllLavanderiaEntities(@RequestBody Iterable<Integer> ids) {
        lavanderiaService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-parrucchiera-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllParrucchieraEntities(@RequestBody Iterable<Integer> ids) {
        parrucchiereService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-ristoranti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllRistorantiEntities(@RequestBody Iterable<Integer> ids) {
        ristorantiService.deleteAllById(ids);
    }

    /**
     * @param ids
     * @return Iterable<SupermercatoEntity>
     */
    @DeleteMapping(value = "/delete-all-supermercato-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SupermercatoEntity> deleteAllSupermercatoEntities(@RequestBody Iterable<Integer> ids) {
        return supermercatoService.findAll();
    }

    /**
     * @param deleteAllVestitiSpeseQuotidianeEntities(
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    @DeleteMapping(value = "/delete-all-vestiti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<VestitiSpeseQuotidianeEntity> deleteAllVestitiSpeseQuotidianeEntities(
            @RequestBody Iterable<Integer> ids) {
        return vestitiService.findAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-all-selected-altre-spese-mediche-istruzione-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltreSpeseMedicheEntities(@RequestBody AbbonamentiEntity entity) throws NotFoundException {
        abbonamentiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-altro-spese-quotidiane-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedAltroSpeseQuotidianeEntity(@RequestBody AltroSpeseQuotidianeEntity entity)
            throws NotFoundException {
        altreSpeseQuotidianeService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-lezione-indipendenti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedIgienePersonaleEntity(@RequestBody IgienePersonaleEntity entity)
            throws NotFoundException {
        igienePersonaleService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-lavanderia-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedLavanderiaEntity(@RequestBody LavanderiaEntity entity) throws NotFoundException {
        lavanderiaService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-parrucchiere-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedParrucchiereEntity(@RequestBody ParrucchiereEntity entity) throws NotFoundException {
        parrucchiereService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-ristoranti-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedRistorantiEntity(@RequestBody RistorantiEntity entity) throws NotFoundException {
        ristorantiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-supermercato-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSelectedSupermecatoEntity(@RequestBody SupermercatoEntity entity) throws NotFoundException {
        supermercatoService.delete(entity);
    }

    /**
     * @param entity
     */
    @DeleteMapping(value = "/delete-one-spese-mediche-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSpeseMedicheEntity(@RequestBody SpeseQuotidianeEntity entity) {
        if (!entity.getAbbonamentiEntities().isEmpty()) {
            abbonamentiService.deleteAll(entity.getAbbonamentiEntities());
        }
        if (!entity.getAltroEntities().isEmpty()) {
            altreSpeseQuotidianeService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getIgienePersonaleEntities().isEmpty()) {
            igienePersonaleService.deleteAll(entity.getIgienePersonaleEntities());
        }
        if (!entity.getLavanderiaEntities().isEmpty()) {
            lavanderiaService.deleteAll(entity.getLavanderiaEntities());
        }
        if (!entity.getParrucchiereEntities().isEmpty()) {
            parrucchiereService.deleteAll(entity.getParrucchiereEntities());
        }
        if (!entity.getRistorantiEntities().isEmpty()) {
            ristorantiService.deleteAll(entity.getRistorantiEntities());
        }
        if (!entity.getSupermercatoEntities().isEmpty()) {
            supermercatoService.deleteAll(entity.getSupermercatoEntities());
        }
        if (!entity.getVestitiEntities().isEmpty()) {
            vestitiService.deleteAll(entity.getVestitiEntities());
        }
    }

    /**
     * @param entity
     * @return AbbonamentiEntity
     */
    // SAVE ONE
    @PutMapping
    public AbbonamentiEntity saveOneAbbonamentoEntity(@RequestBody AbbonamentiEntity entity) {
        return abbonamentiService.save(entity);
    }

    /**
     * @param entity
     * @return AltroSpeseQuotidianeEntity
     */
    @PutMapping(value = "/save-one-altro-spese-mediche-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroSpeseQuotidianeEntity saveOneAltroSpeseMedicheEntity(@RequestBody AltroSpeseQuotidianeEntity entity) {
        return altreSpeseQuotidianeService.save(entity);
    }

    /**
     * @param entity
     * @return IgienePersonaleEntity
     */
    @PutMapping(value = "/save-one-igiene-personale-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public IgienePersonaleEntity saveOneIgienePersonaleEntity(@RequestBody IgienePersonaleEntity entity) {
        return igienePersonaleService.save(entity);
    }

    /**
     * @param entity
     * @return LavanderiaEntity
     */
    @PutMapping(value = "/save-one-lavanderia-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LavanderiaEntity saveOneLavanderiaIstruzioneEntity(@RequestBody LavanderiaEntity entity) {
        return lavanderiaService.save(entity);
    }

    /**
     * @param entity
     * @return ParrucchiereEntity
     */
    @PutMapping(value = "/save-one-parrucchiere-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ParrucchiereEntity saveOneParrucchiereEntity(@RequestBody ParrucchiereEntity entity) {
        return parrucchiereService.save(entity);
    }

    /**
     * @param entity
     * @return RistorantiEntity
     */
    @PutMapping(value = "/save-one-ristoranti-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RistorantiEntity saveOneRistoranteEntity(@RequestBody RistorantiEntity entity) {
        return ristorantiService.save(entity);
    }

    /**
     * @param entity
     * @return SupermercatoEntity
     */
    @PutMapping(value = "/save-one-supermercato-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupermercatoEntity saveOneSupermercatoEntity(@RequestBody SupermercatoEntity entity) {
        return supermercatoService.save(entity);
    }

    /**
     * @param saveOneVestitiSpeseQuotidianeEntity(
     * @return VestitiSpeseQuotidianeEntity
     */
    @PutMapping(value = "/save-one-vestiti-spese-quotidiane-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public VestitiSpeseQuotidianeEntity saveOneVestitiSpeseQuotidianeEntity(
            @RequestBody VestitiSpeseQuotidianeEntity entity) {
        return vestitiService.save(entity);
    }

    /**
     * @param entity
     * @return SpeseQuotidianeEntity
     */
    @PutMapping(value = "/save-one-spese-quotidiane-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SpeseQuotidianeEntity saveOneIstruzioneEntity(@RequestBody SpeseQuotidianeEntity entity) {
        abbonamentiService.deleteAll(entity.getAbbonamentiEntities());
        altreSpeseQuotidianeService.deleteAll(entity.getAltroEntities());
        igienePersonaleService.deleteAll(entity.getIgienePersonaleEntities());
        lavanderiaService.deleteAll(entity.getLavanderiaEntities());
        parrucchiereService.deleteAll(entity.getParrucchiereEntities());
        ristorantiService.deleteAll(entity.getRistorantiEntities());
        supermercatoService.deleteAll(entity.getSupermercatoEntities());
        vestitiService.deleteAll(entity.getVestitiEntities());

        return entity;
    }
}
