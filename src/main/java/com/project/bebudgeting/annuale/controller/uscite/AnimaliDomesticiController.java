package com.project.bebudgeting.annuale.controller.uscite;

import java.util.ArrayList;

import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.AlimentiAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.AltroAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.FornitureAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.GiocattoliAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.VeterinarioAnimaliDomesticiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    // Find
    @GetMapping(value = "/get-all-alimenti-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlimentiAnimaliDomesticiEntity> getAllAlimentiAnimaliDomestici() {
        return alimentiAnimaliDomesticiService.findAll();
    }

    @GetMapping(value = "/get-all-altro-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroAnimaliDomesticiEntity> getAllAltroAnimaliDomestici() {
        return altroAnimaliDomesticiService.findAll();
    }

    @GetMapping(value = "/get-all-forniture-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FornitureAnimaliDomesticiEntity> getAllFornitureAnimaliDOmestici() {
        return fornitureAnimaliDomesticiService.findAll();
    }

    @GetMapping(value = "/get-all-giocattoli-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GiocattoliAnimaliDomesticiEntity> getAllGiocattoliAnimaliDomestici() {
        return giocattoliAnimaliDomesticiService.findAll();
    }

    @GetMapping(value = "/get-all-veterinario-animali-domestici", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<VeterinarioAnimaliDomesticiEntity> getAllVeterinarioAnimaliDomestici() {
        return veterinarioAnimaliDomestici.findAll();
    }

    @GetMapping(value = "/get-one-animali-domestici-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnimaliDomesticiEntity findOneSalarioEntity(@RequestParam int id) {
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

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-alimenti-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAlimentiAnimaliEntity(@RequestBody AlimentiAnimaliDomesticiEntity entity)
            throws NotFoundException {
        alimentiAnimaliDomesticiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-altro-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroAnimaliDomesticiEntity(@RequestBody AltroAnimaliDomesticiEntity entity)
            throws NotFoundException {
        altroAnimaliDomesticiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-forniture-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFornitureAnimaliDomesticiEntity(@RequestBody FornitureAnimaliDomesticiEntity entity)
            throws NotFoundException {
        fornitureAnimaliDomesticiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-giocattoli-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneGiocattoliAnimaliDomesticiEntity(@RequestBody GiocattoliAnimaliDomesticiEntity entity)
            throws NotFoundException {
        giocattoliAnimaliDomesticiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-veterinario-animali-domestici", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneVeterinarioAnimaliDomesticiEntity(@RequestBody VeterinarioAnimaliDomesticiEntity entity)
            throws NotFoundException {
        veterinarioAnimaliDomestici.delete(entity);
    }
}
