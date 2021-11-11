package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.BolletteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.AltreBolletteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteAcquaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteElettricitaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteGASEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteInternetEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteRifiutiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTelefonoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.AltreBolletteService;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteAcquaService;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteElettricitaService;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteGASService;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteInternetService;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteRifiutiService;
import com.project.bebudgeting.service.annuali.usciteservice.bolletteservice.BolletteTelefonoService;

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

@Api(value = "Bollette", tags = "Bollette", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/bollette")
public class BolletteController {
    @Autowired
    AltreBolletteService altreBolletteService;

    @Autowired
    BolletteAcquaService bolletteAcquaService;

    @Autowired
    BolletteElettricitaService bolletteElettricitaService;

    @Autowired
    BolletteGASService bolletteGASService;

    @Autowired
    BolletteInternetService bolletteInternetService;

    @Autowired
    BolletteRifiutiService bolletteRifiutiService;

    @Autowired
    BolletteTelefonoService bolletteTelefonoService;

    // GET ALL
    @GetMapping(value = "/get-all-altre-bollette-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltreBolletteEntity> getAllAltreBolletteEntities() {
        return altreBolletteService.findAll();
    }

    @GetMapping(value = "/get-all-bollette-acqua-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteAcquaEntity> getAllBolletteAcquaEntities() {
        return bolletteAcquaService.findAll();
    }

    @GetMapping(value = "/get-all-bollette-elettriche-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteElettricitaEntity> getAllElettricitaEntities() {
        return bolletteElettricitaService.findAll();
    }

    @GetMapping(value = "/get-all-bollette-gas-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteGASEntity> getAllBolletteGasEntities() {
        return bolletteGASService.findAll();
    }

    @GetMapping(value = "/get-all-bollette-internet-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteInternetEntity> getAllBolletteInternetEntities() {
        return bolletteInternetService.findAll();
    }

    @GetMapping(value = "/get-all-bollette-rifiuti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteRifiutiEntity> getAllBolletteRifiutiEntities() {
        return bolletteRifiutiService.findAll();
    }

    @GetMapping(value = "/get-all-bollette-telefono-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteTelefonoEntity> getAllBolletteTelefonoEntities() {
        return bolletteTelefonoService.findAll();
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-altre-bollette-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltreBolletteEntities(@RequestBody Iterable<Integer> ids) {
        altreBolletteService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-acqua-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteAcquaEntities(@RequestBody Iterable<Integer> ids) {
        bolletteAcquaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-gas-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteGasEntities(@RequestBody Iterable<Integer> ids) {
        bolletteAcquaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-elettriche-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BolletteElettricitaEntity> deleteAllBolletteElettricheEntities(@RequestBody Iterable<Integer> ids) {
        altreBolletteService.deleteAllById(ids);
        return bolletteElettricitaService.findAll();
    }

    @DeleteMapping(value = "/delete-all-bollette-internet-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteInternetEntities(@RequestBody Iterable<Integer> ids) {
        bolletteInternetService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-rifiuti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteRifiutiEntities(@RequestBody Iterable<Integer> ids) {
        bolletteRifiutiService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-telefono-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteTelefonoEntities(@RequestBody Iterable<Integer> ids) {
        bolletteTelefonoService.deleteAllById(ids);
    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-altre-bollette-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltreBolletteEntity(@RequestBody AltreBolletteEntity entityToDelete) throws NotFoundException {
        altreBolletteService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-acqua-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteAcquaEntity(@RequestBody BolletteAcquaEntity entityToDelete) throws NotFoundException {
        bolletteAcquaService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-elettrica-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteElettricheEntity(@RequestBody BolletteElettricitaEntity entityToDelete)
            throws NotFoundException {
        bolletteElettricitaService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-gas-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteGASEntity(@RequestBody BolletteGASEntity entityToDelete) throws NotFoundException {
        bolletteGASService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-internet-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteInternetEntity(@RequestBody BolletteInternetEntity entityToDelete)
            throws NotFoundException {
        bolletteInternetService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-rifiuti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteRifiutiEntity(@RequestBody BolletteRifiutiEntity entityToDelete)
            throws NotFoundException {
        bolletteRifiutiService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-telefono-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteTelefonoEntity(@RequestBody BolletteTelefonoEntity entityToDelete)
            throws NotFoundException {
        bolletteTelefonoService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazione(@RequestBody BolletteEntity entityToDelete) throws NotFoundException {
        if (!entityToDelete.getAltreBolletteEntities().isEmpty()) {
            altreBolletteService.deleteAll(entityToDelete.getAltreBolletteEntities());
        }
        if (!entityToDelete.getBolletteAcquaEntities().isEmpty()) {
            bolletteAcquaService.deleteAll(entityToDelete.getBolletteAcquaEntities());
        }
        if (!entityToDelete.getBolletteElettricitaEntities().isEmpty()) {
            bolletteElettricitaService.deleteAll(entityToDelete.getBolletteElettricitaEntities());
        }
        if (!entityToDelete.getBolletteGASEntities().isEmpty()) {
            bolletteGASService.deleteAll(entityToDelete.getBolletteGASEntities());
        }
        if (!entityToDelete.getBolletteInternetEntities().isEmpty()) {
            bolletteInternetService.deleteAll(entityToDelete.getBolletteInternetEntities());
        }
        if (!entityToDelete.getBolletteRifiutiEntities().isEmpty()) {
            bolletteRifiutiService.deleteAll(entityToDelete.getBolletteRifiutiEntities());
        }
        if (!entityToDelete.getBolletteTelefonoEntities().isEmpty()) {
            bolletteTelefonoService.deleteAll(entityToDelete.getBolletteTelefonoEntities());
        }
    }

    // SAVE ONE
    @PutMapping(value = "/save-one-altre-bollette-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltreBolletteEntity addOneAltreBolletteEntity(@RequestBody AltreBolletteEntity entity) {
        return altreBolletteService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-acqua-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteAcquaEntity AddOneBolletteAcquaEntity(@RequestBody BolletteAcquaEntity entity) {
        return bolletteAcquaService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-elettriche-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteElettricitaEntity addOneBolletteElettricitaEntity(@RequestBody BolletteElettricitaEntity entity) {
        return bolletteElettricitaService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-gas-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteGASEntity addOneAssicurazioneSaluteEntity(@RequestBody BolletteGASEntity entity) {
        return bolletteGASService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-internet-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteInternetEntity addOneAssicurazioneVitaEntity(@RequestBody BolletteInternetEntity entity) {
        return bolletteInternetService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-rifiuti-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteRifiutiEntity addOneBolletteRifiutEntity(@RequestBody BolletteRifiutiEntity entity) {
        return bolletteRifiutiService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-telefono-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteTelefonoEntity addOneBolletteTelefoEntity(@RequestBody BolletteTelefonoEntity entity) {
        return bolletteTelefonoService.save(entity);
    }

    // SAVE MORE ENTITY
    @PutMapping(value = "/save-one-salario-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BolletteEntity addOneSalarioEntity(@RequestBody BolletteEntity bolletteEntity) {
        Iterable<AltreBolletteEntity> altreBolletteEntities = bolletteEntity.getAltreBolletteEntities();
        Iterable<BolletteAcquaEntity> bolletteAcquaEntities = bolletteEntity.getBolletteAcquaEntities();
        Iterable<BolletteElettricitaEntity> bolletteElettricitaEntities = bolletteEntity
                .getBolletteElettricitaEntities();
        Iterable<BolletteGASEntity> bolletteGASEntities = bolletteEntity.getBolletteGASEntities();
        Iterable<BolletteInternetEntity> bolletteInternetEntities = bolletteEntity.getBolletteInternetEntities();
        Iterable<BolletteRifiutiEntity> bolletteRifiutiEntities = bolletteEntity.getBolletteRifiutiEntities();
        Iterable<BolletteTelefonoEntity> bolletteTelefonoEntities = bolletteEntity.getBolletteTelefonoEntities();

        altreBolletteService.saveAll(altreBolletteEntities);
        bolletteAcquaService.saveAll(bolletteAcquaEntities);
        bolletteElettricitaService.saveAll(bolletteElettricitaEntities);
        bolletteGASService.saveAll(bolletteGASEntities);
        bolletteInternetService.saveAll(bolletteInternetEntities);
        bolletteRifiutiService.saveAll(bolletteRifiutiEntities);
        bolletteTelefonoService.saveAll(bolletteTelefonoEntities);

        return bolletteEntity;
    }
}
