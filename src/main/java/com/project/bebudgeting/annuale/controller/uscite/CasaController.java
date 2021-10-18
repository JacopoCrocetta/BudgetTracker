package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.TraslocoEntity;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.AffittoService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.AltroCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.ArredamentoService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.FornitureCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.ManutenzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.MiglioramentiService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.TraslocoService;

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

@Api(value = "Casa", tags = "Casa", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/casa")
public class CasaController {
    @Autowired
    AffittoService affittoService;

    @Autowired
    AltroCasaService altroCasaService;

    @Autowired
    ArredamentoService arredamentoService;

    @Autowired
    FornitureCasaService fornitureCasaService;

    @Autowired
    ManutenzioneService manutenzioneService;

    @Autowired
    MiglioramentiService miglioramentiService;

    @Autowired
    TraslocoService traslocoService;

    // GET ALL
    @GetMapping(value = "/get-all-affitto-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AffittoEntity> getAllAffittoEntities() {
        return affittoService.findAll();
    }

    @GetMapping(value = "/get-all-altro-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroCasaEntity> getAllAltroCasaEntities() {
        return altroCasaService.findAll();
    }

    @GetMapping(value = "/get-all-arredamento-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ArredamentoEntity> getAllArredamentoCasaEntities() {
        return arredamentoService.findAll();
    }

    @GetMapping(value = "/get-all-forniture-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FornitureCasaEntity> getAllFornitureCasaEntities() {
        return fornitureCasaService.findAll();
    }

    @GetMapping(value = "/get-all-manutenzione-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ManutenzioneEntity> getAllManutenzioneCasaEntities() {
        return manutenzioneService.findAll();
    }

    @GetMapping(value = "/get-all-miglioramenti-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MiglioramentiEntity> getAllMiglioramentiCasaEntities() {
        return miglioramentiService.findAll();
    }

    @GetMapping(value = "/get-all-trasloco-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TraslocoEntity> getAllTraslocoCasaEntities() {
        return traslocoService.findAll();
    }

    // DELETE ALL

    /*
     * @Autowired FornitureCasaService fornitureCasaService;
     * 
     * @Autowired ManutenzioneService manutenzioneService;
     * 
     * @Autowired MiglioramentiService miglioramentiService;
     * 
     * @Autowired TraslocoService traslocoService;
     */
    @DeleteMapping(value = "/delete-all-affitto-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAffittoEntities(@RequestBody Iterable<Integer> ids) {
        affittoService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-altro-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroCasaService(@RequestBody Iterable<Integer> ids) {
        altroCasaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-altre-bollette-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllArredamentoEntities(@RequestBody Iterable<Integer> ids) {
        arredamentoService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-forniture-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFornitureCasaEntities(@RequestBody Iterable<Integer> ids) {
        fornitureCasaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-manutenzione-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllManutenzioneCasaEntities(@RequestBody Iterable<Integer> ids) {
        manutenzioneService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-gas-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteGASEntities(@RequestBody Iterable<Integer> ids) {
        miglioramentiService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-bollette-internet-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllBolletteInternetEntities(@RequestBody Iterable<Integer> ids) {
        traslocoService.deleteAllById(ids);
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
