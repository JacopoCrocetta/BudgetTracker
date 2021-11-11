package com.project.bebudgeting.controller.annuali.usciteannuali;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.AssicurazioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AltreAssicurazioniService;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneAutoService;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneCasaService;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneSaluteService;
import com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice.AssicurazioneVitaService;

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

    /**
     * @return Iterable<AltreAssicurazioniEntity>
     */
    // FIND ALL
    @GetMapping(value = "/get-all-altre-assicuraioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltreAssicurazioniEntity> getAllAltreAssicuraioniEntity() {
        return altreAssicurazioniService.findAll();
    }

    /**
     * @return Iterable<AssicurazioneAutoEntity>
     */
    @GetMapping(value = "/get-all-assicuraioni-auto-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneAutoEntity> getAllAssicuraioniAutoEntity() {
        return assicurazioneAutoService.findAll();
    }

    /**
     * @return Iterable<AssicurazioneCasaEntity>
     */
    @GetMapping(value = "/get-all-assicuraioni-casa-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneCasaEntity> getAllAssicurazioniCasaEntity() {
        return assicurazioneCasaService.findAll();
    }

    /**
     * @return Iterable<AssicurazioneSaluteEntity>
     */
    @GetMapping(value = "/get-all-assicuraioni-salute-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneSaluteEntity> getAllAssicurazioneSaluteEntity() {
        return assicurazioneSaluteService.findAll();
    }

    /**
     * @return Iterable<AssicurazioneVitaEntity>
     */
    @GetMapping(value = "/get-all-assicuraioni-vita-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AssicurazioneVitaEntity> getAllAssicurazioneVitaEntity() {
        return assicurazioneVitaService.findAll();
    }

    /**
     * @return AssicurazioneEntity
     */
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

    /**
     * @param entitiesToDelete
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltreAssicurazioni(@RequestBody List<AltreAssicurazioniEntity> entitiesToDelete) {
        altreAssicurazioniService.deleteAll(entitiesToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    @DeleteMapping(value = "/delete-all-assicurazioni-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioniAuto(@RequestBody List<AssicurazioneAutoEntity> entitiesToDelete) {
        assicurazioneAutoService.deleteAll(entitiesToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    @DeleteMapping(value = "/delete-all-assicurazioni-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioneCasa(@RequestBody List<AssicurazioneCasaEntity> entitiesToDelete) {
        assicurazioneCasaService.deleteAll(entitiesToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    @DeleteMapping(value = "/delete-all-assicurazioni-salute-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioneSalute(@RequestBody List<AssicurazioneSaluteEntity> entitiesToDelete) {
        assicurazioneSaluteService.deleteAll(entitiesToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    @DeleteMapping(value = "/delete-all-assicurazione-vita-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAssicurazioneVita(@RequestBody List<AssicurazioneVitaEntity> entitiesToDelete) {
        assicurazioneVitaService.deleteAll(entitiesToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltreAssicurazioni(@RequestBody AltreAssicurazioniEntity entityToDelete)
            throws NotFoundException {
        altreAssicurazioniService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-assicurazioni-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioniAuto(@RequestBody AssicurazioneAutoEntity entityToDelete)
            throws NotFoundException {
        assicurazioneAutoService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-assicurazioni-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioneCasa(@RequestBody AssicurazioneCasaEntity entityToDelete)
            throws NotFoundException {
        assicurazioneCasaService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-assicurazioni-salute-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioneSalute(@RequestBody AssicurazioneSaluteEntity entityToDelete)
            throws NotFoundException {
        assicurazioneSaluteService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-assicurazione-vita-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazioneVita(@RequestBody AssicurazioneVitaEntity entityToDelete)
            throws NotFoundException {
        assicurazioneVitaService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
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

    /**
     * @param entity
     * @return AltreAssicurazioniEntity
     */
    // SAVE ONE
    @PutMapping(value = "/save-one-altre-assicurazioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltreAssicurazioniEntity addOneAltroSalarioEntity(@RequestBody AltreAssicurazioniEntity entity) {
        return altreAssicurazioniService.save(entity);
    }

    /**
     * @param entity
     * @return AssicurazioneAutoEntity
     */
    @PutMapping(value = "/save-one-assicurazione-auto-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneAutoEntity addOneAssicurazioneAutoEntity(@RequestBody AssicurazioneAutoEntity entity) {
        return assicurazioneAutoService.save(entity);
    }

    /**
     * @param entity
     * @return AssicurazioneCasaEntity
     */
    @PutMapping(value = "/save-one-assicurazione-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneCasaEntity addOneAssicurazioneCasaEntity(@RequestBody AssicurazioneCasaEntity entity) {
        return assicurazioneCasaService.save(entity);
    }

    /**
     * @param entity
     * @return AssicurazioneSaluteEntity
     */
    @PutMapping(value = "/save-one-assicurazione-salute-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneSaluteEntity addOneAssicurazioneSaluteEntity(@RequestBody AssicurazioneSaluteEntity entity) {
        return assicurazioneSaluteService.save(entity);
    }

    /**
     * @param entity
     * @return AssicurazioneVitaEntity
     */
    @PutMapping(value = "/save-one-assicurazione-vita-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AssicurazioneVitaEntity addOneAssicurazioneVitaEntity(@RequestBody AssicurazioneVitaEntity entity) {
        return assicurazioneVitaService.save(entity);
    }

    /**
     * @param assicurazioneEntity
     * @return AssicurazioneEntity
     */
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
