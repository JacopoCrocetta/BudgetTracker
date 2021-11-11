package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.TrasportiUsciteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.AltroTrasportiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.FornitureTrasportiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.TrasportoPubblicoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.AltroTrasportiService;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.BolloService;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.CarburanteService;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.FornitureTrasportiService;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.PrestitoAutoService;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.RiparazioniService;
import com.project.bebudgeting.service.annuali.usciteservice.trasportiservice.TrasportoPubblicoService;

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

@Api(value = "Trasporti", tags = "Trasporti", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/trasporti")
public class TrasportiController {
    @Autowired
    AltroTrasportiService altroTrasportiService;

    @Autowired
    BolloService bolloService;

    @Autowired
    CarburanteService carburanteService;

    @Autowired
    FornitureTrasportiService fornitureTrasportiService;

    @Autowired
    PrestitoAutoService prestitoAutoService;

    @Autowired
    RiparazioniService riparazioniService;

    @Autowired
    TrasportoPubblicoService trasportoPubblicoService;

    /**
     * @return Iterable<AltroTrasportiEntity>
     */
    // FIND ALL
    @GetMapping(value = "/get-all-altro-trasporti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroTrasportiEntity> getAllAltroTrasportiEntities() {
        return altroTrasportiService.findAll();
    }

    /**
     * @return Iterable<BolloEntity>
     */
    @GetMapping(value = "/get-all-bollo-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolloEntity> getAllBolloEntities() {
        return bolloService.findAll();
    }

    /**
     * @return Iterable<CarburanteEntity>
     */
    @GetMapping(value = "/get-all-carburante-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CarburanteEntity> getAllCarburanteEntities() {
        return carburanteService.findAll();
    }

    /**
     * @return Iterable<FornitureTrasportiEntity>
     */
    @GetMapping(value = "/get-all-forniture-trasporti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FornitureTrasportiEntity> getAllFornitureTrasportiEntities() {
        return fornitureTrasportiService.findAll();
    }

    /**
     * @return Iterable<PrestitoAutoEntity>
     */
    @GetMapping(value = "/get-all-prestiti-auto-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PrestitoAutoEntity> getAllPrestitoAutoEntities() {
        return prestitoAutoService.findAll();
    }

    /**
     * @return Iterable<RiparazioniEntity>
     */
    @GetMapping(value = "/get-all-riparazioni-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RiparazioniEntity> getAllRiparazioniEntities() {
        return riparazioniService.findAll();
    }

    /**
     * @return Iterable<TrasportoPubblicoEntity>
     */
    @GetMapping(value = "/get-all-trasporto-pubblico-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TrasportoPubblicoEntity> getAllTrasportoPubblicoEntities() {
        return trasportoPubblicoService.findAll();
    }

    /**
     * @param ids
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-altro-trasporti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroTraspotiEntities(@RequestBody Iterable<Integer> ids) {
        altroTrasportiService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-bollo-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolloEntities(@RequestBody Iterable<Integer> ids) {
        bolloService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-carburante-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllCarburanteEntities(@RequestBody Iterable<Integer> ids) {
        carburanteService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-forniture-trasporti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFornitureTrasportiEntities(@RequestBody Iterable<Integer> ids) {
        fornitureTrasportiService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-prestito-auto-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllPrestitoAutoEntity(@RequestBody Iterable<Integer> ids) {
        prestitoAutoService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-riparazioni-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllRiparazioniEntities(@RequestBody Iterable<Integer> ids) {
        riparazioniService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-trasporto-pubblico-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllTrasportoPubblicoEntity(@RequestBody Iterable<Integer> ids) {
        trasportoPubblicoService.deleteAllById(ids);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-selected-altro-trasporti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroTrasportiEntity(@RequestBody AltroTrasportiEntity entity) throws NotFoundException {
        altroTrasportiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-bollo-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolloEntity(@RequestBody BolloEntity entity) throws NotFoundException {
        bolloService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-carburante-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneCarburanteEntity(@RequestBody CarburanteEntity entity) throws NotFoundException {
        carburanteService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-forniture-trasporti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFornitureTrasportiEntity(@RequestBody FornitureTrasportiEntity entity)
            throws NotFoundException {
        fornitureTrasportiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-prestito-auto-entity-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOnePrestitoAutoEntity(@RequestBody PrestitoAutoEntity entity) throws NotFoundException {
        prestitoAutoService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-riparazioni-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneRiparazioniAutoEntity(@RequestBody RiparazioniEntity entity) throws NotFoundException {
        riparazioniService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-trasporto-pubblico-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSoftwareEntity(@RequestBody TrasportoPubblicoEntity entity) throws NotFoundException {
        trasportoPubblicoService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/get-one-selected-trasporti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneVestitiFigliEntity(@RequestBody TrasportiUsciteEntity entity) throws NotFoundException {
        if (!entity.getAltroEntities().isEmpty()) {
            altroTrasportiService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getBolloEntities().isEmpty()) {
            bolloService.deleteAll(entity.getBolloEntities());
        }
        if (!entity.getCarburanteEntities().isEmpty()) {
            carburanteService.deleteAll(entity.getCarburanteEntities());
        }
        if (!entity.getFornitureEntities().isEmpty()) {
            fornitureTrasportiService.deleteAll(entity.getFornitureEntities());
        }
        if (!entity.getPrestitoAutoEntities().isEmpty()) {
            prestitoAutoService.deleteAll(entity.getPrestitoAutoEntities());
        }
        if (!entity.getRiparazioniEntities().isEmpty()) {
            riparazioniService.deleteAll(entity.getRiparazioniEntities());
        }
        if (!entity.getTrasportoPubblicoEntities().isEmpty()) {
            trasportoPubblicoService.deleteAll(entity.getTrasportoPubblicoEntities());
        }
    }

    /**
     * @param entity
     * @return AltroTrasportiEntity
     */
    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altro-trasporti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroTrasportiEntity saveOneAltroTrasportiEntity(@RequestBody AltroTrasportiEntity entity) {
        return altroTrasportiService.save(entity);
    }

    /**
     * @param entity
     * @return BolloEntity
     */
    @PutMapping(value = "/save-one-bollo-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BolloEntity saveOneBolloEntity(@RequestBody BolloEntity entity) {
        return bolloService.save(entity);
    }

    /**
     * @param entity
     * @return CarburanteEntity
     */
    @PutMapping(value = "/save-one-carburante-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CarburanteEntity saveOneCarburanteEntity(@RequestBody CarburanteEntity entity) {
        return carburanteService.save(entity);
    }

    /**
     * @param entity
     * @return FornitureTrasportiEntity
     */
    @PutMapping(value = "/save-one-forniture-trasporti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FornitureTrasportiEntity saveOneFornitureTrasportiEntity(@RequestBody FornitureTrasportiEntity entity) {
        return fornitureTrasportiService.save(entity);
    }

    /**
     * @param entity
     * @return PrestitoAutoEntity
     */
    @PutMapping(value = "/save-one-prestito-auto-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PrestitoAutoEntity saveOnePrestitoAutoEntity(@RequestBody PrestitoAutoEntity entity) {
        return prestitoAutoService.save(entity);
    }

    /**
     * @param entity
     * @return RiparazioniEntity
     */
    @PutMapping(value = "/save-one-riparazioni-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RiparazioniEntity saveOneRiparazioneEntity(@RequestBody RiparazioniEntity entity) {
        return riparazioniService.save(entity);
    }

    /**
     * @param entity
     * @return TrasportoPubblicoEntity
     */
    @PutMapping(value = "/save-one-trasporto-pubblico-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TrasportoPubblicoEntity saveOneTrasportoPubblicoEntity(@RequestBody TrasportoPubblicoEntity entity) {
        return trasportoPubblicoService.save(entity);
    }

    /**
     * @param entity
     * @return TrasportiUsciteEntity
     */
    @PutMapping(value = "/save-one-trasporti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TrasportiUsciteEntity saveOneFigliEntity(@RequestBody TrasportiUsciteEntity entity) {
        altroTrasportiService.saveAll(entity.getAltroEntities());
        bolloService.saveAll(entity.getBolloEntities());
        carburanteService.saveAll(entity.getCarburanteEntities());
        fornitureTrasportiService.saveAll(entity.getFornitureEntities());
        prestitoAutoService.saveAll(entity.getPrestitoAutoEntities());
        riparazioniService.saveAll(entity.getRiparazioniEntities());
        trasportoPubblicoService.saveAll(entity.getTrasportoPubblicoEntities());

        return entity;
    }
}
