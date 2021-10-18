package com.project.bebudgeting.annuale.controller.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AltreAssicurazioniService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneAutoService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneSaluteService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneVitaService;

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

@Api(value = "Assicurazione", tags = "Assicurazione", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/assicurazione")
public class AssicurazioneController {
    @Autowired
    AltreAssicurazioniService altreAssicurazioniService;

    @Autowired
    AssicurazioneAutoService assicurazioneAutoService;

    @Autowired
    AssicurazioneCasaService assicurazioneCasaService;

    @Autowired
    AssicurazioneSaluteService assicurazioneSaluteService;

    @Autowired
    AssicurazioneVitaService assicurazioneVitaService;

    // FIND ALL
    @GetMapping(value = "/get-all-altre-assicuraioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltreAssicurazioniEntity> getAllAltreAssicuraioniEntity() {
        return altreAssicurazioniService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-auto-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneAutoEntity> getAllAssicuraioniAutoEntity() {
        return assicurazioneAutoService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-casa-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneCasaEntity> getAllAssicurazioniCasaEntity() {
        return assicurazioneCasaService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-salute-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneSaluteEntity> getAllAssicurazioneSaluteEntity() {
        return assicurazioneSaluteService.findAll();
    }

    @GetMapping(value = "/get-all-assicuraioni-vita-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneVitaEntity> getAllAssicurazioneVitaEntity() {
        return assicurazioneVitaService.findAll();
    }

    @GetMapping(value = "/get-all-assicurazioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneEntity getAllAssicurazioniEntity() {
        AssicurazioneEntity response = new AssicurazioneEntity();
        response.setAltreAssicurazioniEntities((List<AltreAssicurazioniEntity>) altreAssicurazioniService.findAll());
        response.setAssicurazioneAutoEntities((List<AssicurazioneAutoEntity>) assicurazioneAutoService.findAll());
        response.setAssicurazioneCasaEntities((List<AssicurazioneCasaEntity>) assicurazioneCasaService.findAll());
        response.setAssicurazioneSaluteEntities((List<AssicurazioneSaluteEntity>) assicurazioneSaluteService.findAll());
        response.setAssicurazioneVitaEntities((List<AssicurazioneVitaEntity>) assicurazioneVitaService.findAll());
        return response;
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltreAssicurazioni(@RequestBody List<AltreAssicurazioniEntity> entitiesToDelete) {
        altreAssicurazioniService.deleteAll(entitiesToDelete);
    }

    @DeleteMapping(value = "/delete-all-assicurazioni-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioniAuto(@RequestBody List<AssicurazioneAutoEntity> entitiesToDelete) {
        assicurazioneAutoService.deleteAll(entitiesToDelete);
    }

    @DeleteMapping(value = "/delete-all-assicurazioni-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioneCasa(@RequestBody List<AssicurazioneCasaEntity> entitiesToDelete) {
        assicurazioneCasaService.deleteAll(entitiesToDelete);
    }

    @DeleteMapping(value = "/delete-all-assicurazioni-salute-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioneSalute(@RequestBody List<AssicurazioneSaluteEntity> entitiesToDelete) {
        assicurazioneSaluteService.deleteAll(entitiesToDelete);
    }

    @DeleteMapping(value = "/delete-all-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioneVita(@RequestBody List<AssicurazioneVitaEntity> entitiesToDelete) {
        assicurazioneVitaService.deleteAll(entitiesToDelete);
    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltreAssicurazioni(@RequestBody AltreAssicurazioniEntity entityToDelete)
            throws NotFoundException {
        altreAssicurazioniService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-assicurazioni-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioniAuto(@RequestBody AssicurazioneAutoEntity entityToDelete)
            throws NotFoundException {
        assicurazioneAutoService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-assicurazioni-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioneCasa(@RequestBody AssicurazioneCasaEntity entityToDelete)
            throws NotFoundException {
        assicurazioneCasaService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-assicurazioni-salute-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioneSalute(@RequestBody AssicurazioneSaluteEntity entityToDelete)
            throws NotFoundException {
        assicurazioneSaluteService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-assicurazione-vita-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioneVita(@RequestBody AssicurazioneVitaEntity entityToDelete)
            throws NotFoundException {
        assicurazioneVitaService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazione(@RequestBody AssicurazioneEntity entityToDelete) throws NotFoundException {
        if (!entityToDelete.getAltreAssicurazioniEntities().isEmpty()) {
            altreAssicurazioniService.deleteAll(entityToDelete.getAltreAssicurazioniEntities());
        }
        if (!entityToDelete.getAssicurazioneAutoEntities().isEmpty()) {
            assicurazioneAutoService.deleteAll(entityToDelete.getAssicurazioneAutoEntities());
        }
        if (!entityToDelete.getAssicurazioneCasaEntities().isEmpty()) {
            assicurazioneCasaService.deleteAll(entityToDelete.getAssicurazioneCasaEntities());
        }
        if (!entityToDelete.getAssicurazioneSaluteEntities().isEmpty()) {
            assicurazioneSaluteService.deleteAll(entityToDelete.getAssicurazioneSaluteEntities());
        }
        if (!entityToDelete.getAssicurazioneVitaEntities().isEmpty()) {
            assicurazioneVitaService.deleteAll(entityToDelete.getAssicurazioneVitaEntities());
        }
    }

    // SAVE ONE
    @PutMapping(value = "/save-one-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltreAssicurazioniEntity addOneAltroSalarioEntity(@RequestBody AltreAssicurazioniEntity entity) {
        return altreAssicurazioniService.save(entity);
    }

    @PutMapping(value = "/save-one-assicurazione-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneAutoEntity addOneAssicurazioneAutoEntity(@RequestBody AssicurazioneAutoEntity entity) {
        return assicurazioneAutoService.save(entity);
    }

    @PutMapping(value = "/save-one-assicurazione-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneCasaEntity addOneAssicurazioneCasaEntity(@RequestBody AssicurazioneCasaEntity entity) {
        return assicurazioneCasaService.save(entity);
    }

    @PutMapping(value = "/save-one-assicurazione-salute-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneSaluteEntity addOneAssicurazioneSaluteEntity(@RequestBody AssicurazioneSaluteEntity entity) {
        return assicurazioneSaluteService.save(entity);
    }

    @PutMapping(value = "/save-one-assicurazione-vita-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneVitaEntity addOneAssicurazioneVitaEntity(@RequestBody AssicurazioneVitaEntity entity) {
        return assicurazioneVitaService.save(entity);
    }

    // SAVE MORE ENTITY
    @PutMapping(value = "/save-one-salario-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneEntity addOneSalarioEntity(@RequestBody AssicurazioneEntity assicurazioneEntity) {
        Iterable<AltreAssicurazioniEntity> altreAssicurazioniEntities = assicurazioneEntity
                .getAltreAssicurazioniEntities();
        Iterable<AssicurazioneAutoEntity> assicurazioniAutoEntities = assicurazioneEntity
                .getAssicurazioneAutoEntities();
        Iterable<AssicurazioneCasaEntity> assicurazioneCasaEntities = assicurazioneEntity
                .getAssicurazioneCasaEntities();
        Iterable<AssicurazioneSaluteEntity> assicurazioneSaluteEntities = assicurazioneEntity
                .getAssicurazioneSaluteEntities();
        Iterable<AssicurazioneVitaEntity> assicurazioneVitaEntities = assicurazioneEntity
                .getAssicurazioneVitaEntities();

        altreAssicurazioniService.saveAll(altreAssicurazioniEntities);
        assicurazioneAutoService.saveAll(assicurazioniAutoEntities);
        assicurazioneCasaService.saveAll(assicurazioneCasaEntities);
        assicurazioneSaluteService.saveAll(assicurazioneSaluteEntities);
        assicurazioneVitaService.saveAll(assicurazioneVitaEntities);

        return assicurazioneEntity;
    }
}
