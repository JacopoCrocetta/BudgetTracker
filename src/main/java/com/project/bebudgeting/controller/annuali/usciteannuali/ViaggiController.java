package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.ViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AltroViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.DivertimentoViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.HotelEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.TrasportiViaggiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.AlimentiViaggiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.AltroViaggiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.BigliettiAereiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.DivertimentoViaggiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.HotelService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.TrasportiViaggiService;

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

@Api(value = "Viaggi", tags = "Viaggi", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/viaggi")
public class ViaggiController {
    @Autowired
    AlimentiViaggiService alimentiViaggiService;

    @Autowired
    AltroViaggiService altroViaggiService;

    @Autowired
    BigliettiAereiService bigliettiAereiService;

    @Autowired
    DivertimentoViaggiService divertimentoViaggiService;

    @Autowired
    HotelService hotelService;

    @Autowired
    TrasportiViaggiService trasportiViaggiService;

    // FIND ALL
    /**
     * @return Iterable<AlimentiViaggiEntity>
     */
    @GetMapping(value = "get-all-alimenti-viaggi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlimentiViaggiEntity> getAllAlimentiViaggiEntities() {
        return alimentiViaggiService.findAll();
    }

    /**
     * @return Iterable<AltroViaggiEntity>
     */
    @GetMapping(value = "get-all-altro-viaggi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroViaggiEntity> getAllAltroViaggiEntities() {
        return altroViaggiService.findAll();
    }

    /**
     * @return Iterable<BigliettiAereiEntity>
     */
    @GetMapping(value = "/get-all-biglietti-aerei-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BigliettiAereiEntity> getAllBigliettiAereiEntities() {
        return bigliettiAereiService.findAll();
    }

    /**
     * @return Iterable<DivertimentoViaggiEntity>
     */
    @GetMapping(value = "/get-all-divertimento-viaggi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DivertimentoViaggiEntity> getAllDivertimentoViaggiEntities() {
        return divertimentoViaggiService.findAll();
    }

    /**
     * @return Iterable<HotelEntity>
     */
    @GetMapping(value = "/get-all-hotel-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HotelEntity> getAllHotelEntities() {
        return hotelService.findAll();
    }

    /**
     * @return Iterable<TrasportiViaggiEntity>
     */
    @GetMapping(value = "/get-all-trasporti-viaggi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TrasportiViaggiEntity> getAllTrasportiViaggiEntities() {
        return trasportiViaggiService.findAll();
    }

    // DELETE ALL
    /**
     * @param ids
     */
    @DeleteMapping(value = "delete-all-alimenti-viaggi-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllSelectedAlimentiViaggiEntities(@RequestBody Iterable<Integer> ids) {
        alimentiViaggiService.deleteAllById(ids);
    }

    /**
     * @return Iterable<AltroViaggiEntity>
     */
    @DeleteMapping(value = "delete-all-altro-viaggi-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroViaggiEntity> deleteAllSelectedAltroViaggiEntities() {
        return altroViaggiService.findAll();
    }

    /**
     * @return Iterable<BigliettiAereiEntity>
     */
    @DeleteMapping(value = "/delete-all-biglietti-aerei-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BigliettiAereiEntity> deleteAllBigliettiAereiEntities() {
        return bigliettiAereiService.findAll();
    }

    /**
     * @return Iterable<DivertimentoViaggiEntity>
     */
    @DeleteMapping(value = "/delete-all-divertimento-viaggi-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DivertimentoViaggiEntity> deleteAllDivertimentoViaggiEntities() {
        return divertimentoViaggiService.findAll();
    }

    /**
     * @return Iterable<HotelEntity>
     */
    @DeleteMapping(value = "/delete-all-hotel-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HotelEntity> deleteAllHotelEntities() {
        return hotelService.findAll();
    }

    /**
     * @return Iterable<TrasportiViaggiEntity>
     */
    @DeleteMapping(value = "/delete-all-trasporti-viaggi-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TrasportiViaggiEntity> deleteAllTrasportiViaggiEntities() {
        return trasportiViaggiService.findAll();
    }

    // DELETE ONE ENTITY
    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "delete-one-alimenti-viaggi-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAlimentiViaggiEntities(@RequestBody AlimentiViaggiEntity entity) throws NotFoundException {
        alimentiViaggiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "delete-one-altro-viaggi-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroViaggiEntity(@RequestBody AltroViaggiEntity entity) throws NotFoundException {
        altroViaggiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-biglietti-aerei-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBigliettiAereiEntity(@RequestBody BigliettiAereiEntity entity) throws NotFoundException {
        bigliettiAereiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-divertimento-viaggi-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneDivertimentoViaggiEntity(@RequestBody DivertimentoViaggiEntity entity)
            throws NotFoundException {
        divertimentoViaggiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-hotel-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneHotelEntity(@RequestBody HotelEntity entity) throws NotFoundException {
        hotelService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-trasporti-viaggi-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneTrasportiViaggiEntity(@RequestBody TrasportiViaggiEntity entity) throws NotFoundException {
        trasportiViaggiService.delete(entity);
    }

    /**
     * @param entity
     */
    @DeleteMapping(value = "/delete-one-viaggi-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneViaggiEntity(@RequestBody ViaggiEntity entity) {
        if (!entity.getAltroEntities().isEmpty()) {
            altroViaggiService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getAlimentiEntities().isEmpty()) {
            alimentiViaggiService.deleteAll(entity.getAlimentiEntities());
        }
        if (!entity.getBigliettiAereiEntities().isEmpty()) {
            bigliettiAereiService.deleteAll(entity.getBigliettiAereiEntities());
        }
        if (!entity.getDivertimentoEntities().isEmpty()) {
            divertimentoViaggiService.deleteAll(entity.getDivertimentoEntities());
        }
        if (!entity.getHotelEntities().isEmpty()) {
            hotelService.deleteAll(entity.getHotelEntities());
        }
        if (!entity.getTrasportiEntities().isEmpty()) {
            trasportiViaggiService.deleteAll(entity.getTrasportiEntities());
        }
    }

    // SAVE ONE ENTITY
    /**
     * @param entity
     * @return AltroViaggiEntity
     */
    @PutMapping(value = "/save-one-altro-viaggi-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroViaggiEntity saveOneAltroViaggiEntity(@RequestBody AltroViaggiEntity entity) {
        return altroViaggiService.save(entity);
    }

    /**
     * @param entity
     * @return AlimentiViaggiEntity
     */
    @PutMapping(value = "/save-one-alimenti-viaggi-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AlimentiViaggiEntity saveOneAlimentiViaggiEntity(@RequestBody AlimentiViaggiEntity entity) {
        return alimentiViaggiService.save(entity);
    }

    /**
     * @param entity
     * @return BigliettiAereiEntity
     */
    @PutMapping(value = "/save-one-biglietti-aerei-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BigliettiAereiEntity saveOneBigliettiAereiEntity(@RequestBody BigliettiAereiEntity entity) {
        return bigliettiAereiService.save(entity);
    }

    /**
     * @param entity
     * @return DivertimentoViaggiEntity
     */
    @PutMapping(value = "/save-one-divertimento-viaggi-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DivertimentoViaggiEntity saveOneDivertimentoViaggiEntity(@RequestBody DivertimentoViaggiEntity entity) {
        return divertimentoViaggiService.save(entity);
    }

    /**
     * @param entity
     * @return HotelEntity
     */
    @PutMapping(value = "/save-one-hotel-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HotelEntity saveOneHotelEntity(@RequestBody HotelEntity entity) {
        return hotelService.save(entity);
    }

    /**
     * @param entity
     * @return TrasportiViaggiEntity
     */
    @PutMapping(value = "/save-one-tras[prti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TrasportiViaggiEntity saveOneTrasportiEntity(@RequestBody TrasportiViaggiEntity entity) {
        return trasportiViaggiService.save(entity);
    }

    /**
     * @param entity
     * @return ViaggiEntity
     */
    @PutMapping(value = "/save-one-viaggi-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ViaggiEntity saveOneViaggiEntity(@RequestBody ViaggiEntity entity) {
        alimentiViaggiService.saveAll(entity.getAlimentiEntities());
        altroViaggiService.saveAll(entity.getAltroEntities());
        bigliettiAereiService.saveAll(entity.getBigliettiAereiEntities());
        divertimentoViaggiService.saveAll(entity.getDivertimentoEntities());
        hotelService.saveAll(entity.getHotelEntities());
        trasportiViaggiService.saveAll(entity.getTrasportiEntities());

        return entity;
    }
}
