package com.project.bebudgeting.controller.annuali.usciteannuali;

import java.util.ArrayList;

import com.project.bebudgeting.entity.annuali.uscite.AnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.AlimentiAnimaliDomesticiService;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.AltroAnimaliDomesticiService;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.FornitureAnimaliDomesticiService;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.GiocattoliAnimaliDomesticiService;
import com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice.VeterinarioAnimaliDomesticiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import javassist.NotFoundException;

@Api(value = "Animali Domestici", tags = "Animali Domestici", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/animali-domestici")
public class AnimaliDomesticiController {
    @Autowired
    AlimentiAnimaliDomesticiService alimentiAnimaliDomesticiService;

    @Autowired
    AltroAnimaliDomesticiService altroAnimaliDomesticiService;

    @Autowired
    FornitureAnimaliDomesticiService fornitureAnimaliDomesticiService;

    @Autowired
    GiocattoliAnimaliDomesticiService giocattoliAnimaliDomesticiService;

    @Autowired
    VeterinarioAnimaliDomesticiService veterinarioAnimaliDomestici;

    /**
     * @return Iterable<AlimentiAnimaliDomesticiEntity>
     */
    // Find
    @GetMapping(value = "/get-all-alimenti-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlimentiAnimaliDomesticiEntity> getAllAlimentiAnimaliDomestici() {
        return alimentiAnimaliDomesticiService.findAll();
    }

    /**
     * @return Iterable<AltroAnimaliDomesticiEntity>
     */
    @GetMapping(value = "/get-all-altro-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroAnimaliDomesticiEntity> getAllAltroAnimaliDomestici() {
        return altroAnimaliDomesticiService.findAll();
    }

    /**
     * @return Iterable<FornitureAnimaliDomesticiEntity>
     */
    @GetMapping(value = "/get-all-forniture-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FornitureAnimaliDomesticiEntity> getAllFornitureAnimaliDOmestici() {
        return fornitureAnimaliDomesticiService.findAll();
    }

    /**
     * @return Iterable<GiocattoliAnimaliDomesticiEntity>
     */
    @GetMapping(value = "/get-all-giocattoli-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GiocattoliAnimaliDomesticiEntity> getAllGiocattoliAnimaliDomestici() {
        return giocattoliAnimaliDomesticiService.findAll();
    }

    /**
     * @return Iterable<VeterinarioAnimaliDomesticiEntity>
     */
    @GetMapping(value = "/get-all-veterinario-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<VeterinarioAnimaliDomesticiEntity> getAllVeterinarioAnimaliDomestici() {
        return veterinarioAnimaliDomestici.findAll();
    }

    /**
     * @param id
     * @return AnimaliDomesticiEntity
     */
    @GetMapping(value = "/get-one-animali-domestici-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnimaliDomesticiEntity findOneAnimaliDomesticiEntity(@RequestParam int id) {
        AnimaliDomesticiEntity ret = new AnimaliDomesticiEntity();

        ArrayList<AlimentiAnimaliDomesticiEntity> alimentiAnimaliDomesticiEntities = new ArrayList<>();
        ArrayList<AltroAnimaliDomesticiEntity> altroAnimaliDomesticiEntities = new ArrayList<>();
        ArrayList<FornitureAnimaliDomesticiEntity> fornitureAnimaliDomesticiEntities = new ArrayList<>();
        ArrayList<GiocattoliAnimaliDomesticiEntity> giocattoliAnimaliDomesticiEntities = new ArrayList<>();
        ArrayList<VeterinarioAnimaliDomesticiEntity> veterinarioAnimaliDomesticiEntities = new ArrayList<>();

        alimentiAnimaliDomesticiEntities.add(alimentiAnimaliDomesticiService.findById(id).get());
        altroAnimaliDomesticiEntities.add(altroAnimaliDomesticiService.findById(id).get());
        fornitureAnimaliDomesticiEntities.add(fornitureAnimaliDomesticiService.findById(id).get());
        giocattoliAnimaliDomesticiEntities.add(giocattoliAnimaliDomesticiService.findById(id).get());
        veterinarioAnimaliDomesticiEntities.add(veterinarioAnimaliDomestici.findById(id).get());

        ret.setAlimentiEntities(alimentiAnimaliDomesticiEntities);
        ret.setAltroEntities(altroAnimaliDomesticiEntities);
        ret.setFornitureEntities(fornitureAnimaliDomesticiEntities);
        ret.setGiocattoliEntities(giocattoliAnimaliDomesticiEntities);
        ret.setVeterinarioEntities(veterinarioAnimaliDomesticiEntities);
        return ret;
    }

    // DELETE ALL ENTITY
    @DeleteMapping(value = "/delete-all-alimenti-animali-domestici")
    public void deleteAllAlimentiAnimaliDomestici() {
        alimentiAnimaliDomesticiService.deleteAll();
    }

    @DeleteMapping(value = "/delete-all-altro-animali-domestici")
    public void deleteAllAltroDomestici() {
        altroAnimaliDomesticiService.deleteAll();
    }

    @DeleteMapping(value = "/delete-all-forniture-animali-domestici")
    public void deleteAllFornitureDomestici() {
        fornitureAnimaliDomesticiService.deleteAll();
    }

    @DeleteMapping(value = "/delete-all-giocattoli-animali-domestici")
    public void deleteAllGiocattoliDomestici() {
        giocattoliAnimaliDomesticiService.deleteAll();
    }

    @DeleteMapping(value = "/delete-all-veterinario-animali-domestici")
    public void deleteAllVeterinarioAnimaliDomestici() {
        veterinarioAnimaliDomestici.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-alimenti-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAlimentiAnimaliEntity(@RequestBody AlimentiAnimaliDomesticiEntity entity)
            throws NotFoundException {
        alimentiAnimaliDomesticiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-altro-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroAnimaliDomesticiEntity(@RequestBody AltroAnimaliDomesticiEntity entity)
            throws NotFoundException {
        altroAnimaliDomesticiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-forniture-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFornitureAnimaliDomesticiEntity(@RequestBody FornitureAnimaliDomesticiEntity entity)
            throws NotFoundException {
        fornitureAnimaliDomesticiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-giocattoli-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneGiocattoliAnimaliDomesticiEntity(@RequestBody GiocattoliAnimaliDomesticiEntity entity)
            throws NotFoundException {
        giocattoliAnimaliDomesticiService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-veterinario-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneVeterinarioAnimaliDomesticiEntity(@RequestBody VeterinarioAnimaliDomesticiEntity entity)
            throws NotFoundException {
        veterinarioAnimaliDomestici.delete(entity);
    }

    /**
     * @param entity
     */
    @DeleteMapping(value = "/delete-one-animali-domestici-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAnimaliDomesticiEntity(@RequestBody AnimaliDomesticiEntity entity) {
        if (!entity.getAlimentiEntities().isEmpty()) {
            alimentiAnimaliDomesticiService.deleteAll(entity.getAlimentiEntities());
        }
        if (!entity.getAltroEntities().isEmpty()) {
            altroAnimaliDomesticiService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getFornitureEntities().isEmpty()) {
            fornitureAnimaliDomesticiService.deleteAll(entity.getFornitureEntities());
        }
        if (!entity.getGiocattoliEntities().isEmpty()) {
            giocattoliAnimaliDomesticiService.deleteAll(entity.getGiocattoliEntities());
        }
        if (!entity.getVeterinarioEntities().isEmpty()) {
            veterinarioAnimaliDomestici.deleteAll(entity.getVeterinarioEntities());
        }
    }

    /**
     * @param entity
     * @return AlimentiAnimaliDomesticiEntity
     */
    // SAVE ONE
    @PutMapping(value = "/save-one-alimenti-animali-domestici-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AlimentiAnimaliDomesticiEntity addOneAltroSalarioEntity(@RequestBody AlimentiAnimaliDomesticiEntity entity) {
        return alimentiAnimaliDomesticiService.save(entity);
    }

    /**
     * @param addOneAltroAnimaliDomestiicEntity(
     * @return AltroAnimaliDomesticiEntity
     */
    @PutMapping(value = "/save-one-altro-amimali-domestici-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroAnimaliDomesticiEntity addOneAltroAnimaliDomestiicEntity(
            @RequestBody AltroAnimaliDomesticiEntity entity) {
        return altroAnimaliDomesticiService.save(entity);
    }

    /**
     * @param addOneFornitureAnimaliDomesticiEntity(
     * @return FornitureAnimaliDomesticiEntity
     */
    @PutMapping(value = "/save-one-forniture-animali-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FornitureAnimaliDomesticiEntity addOneFornitureAnimaliDomesticiEntity(
            @RequestBody FornitureAnimaliDomesticiEntity entity) {
        return fornitureAnimaliDomesticiService.save(entity);
    }

    /**
     * @param addOneGiocattoliAnimaliDomesticiEntity(
     * @return GiocattoliAnimaliDomesticiEntity
     */
    @PutMapping(value = "/save-one-giocattoli-animali-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GiocattoliAnimaliDomesticiEntity addOneGiocattoliAnimaliDomesticiEntity(
            @RequestBody GiocattoliAnimaliDomesticiEntity entity) {
        return giocattoliAnimaliDomesticiService.save(entity);
    }

    /**
     * @param addOneAssicurazioneVitaEntity(
     * @return VeterinarioAnimaliDomesticiEntity
     */
    @PutMapping(value = "/save-one-assicurazione-vita-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public VeterinarioAnimaliDomesticiEntity addOneAssicurazioneVitaEntity(
            @RequestBody VeterinarioAnimaliDomesticiEntity entity) {
        return veterinarioAnimaliDomestici.save(entity);
    }

    /**
     * @param addOneAnimaliDomesticiEntity(
     * @return AnimaliDomesticiEntity
     */
    // SAVE MORE ENTITY
    @PutMapping(value = "/save-one-animali-domestici-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimaliDomesticiEntity addOneAnimaliDomesticiEntity(
            @RequestBody AnimaliDomesticiEntity animaliDomesticiEntity) {
        Iterable<AlimentiAnimaliDomesticiEntity> alimentiAlimentiEntities = animaliDomesticiEntity
                .getAlimentiEntities();
        Iterable<AltroAnimaliDomesticiEntity> altroAnimaliDomesticiEntities = animaliDomesticiEntity.getAltroEntities();
        Iterable<FornitureAnimaliDomesticiEntity> fornitureAnimaliDomesticiEntities = animaliDomesticiEntity
                .getFornitureEntities();
        Iterable<GiocattoliAnimaliDomesticiEntity> giocattoliAnimaliDomesticiEntities = animaliDomesticiEntity
                .getGiocattoliEntities();
        Iterable<VeterinarioAnimaliDomesticiEntity> veterinarioAnimaliDomesticiEntities = animaliDomesticiEntity
                .getVeterinarioEntities();

        alimentiAnimaliDomesticiService.saveAll(alimentiAlimentiEntities);
        altroAnimaliDomesticiService.saveAll(altroAnimaliDomesticiEntities);
        fornitureAnimaliDomesticiService.saveAll(fornitureAnimaliDomesticiEntities);
        giocattoliAnimaliDomesticiService.saveAll(giocattoliAnimaliDomesticiEntities);
        veterinarioAnimaliDomestici.saveAll(veterinarioAnimaliDomesticiEntities);

        return animaliDomesticiEntity;
    }

}
