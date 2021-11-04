package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.entity.uscite.CasaEntity;
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
    @DeleteMapping(value = "/delete-all-affitto-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAffittoEntities(@RequestBody Iterable<Integer> ids) {
        affittoService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-altro-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroCasaService(@RequestBody Iterable<Integer> ids) {
        altroCasaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-arredamento-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
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
    @DeleteMapping(value = "/delete-one-affitto-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltreBolletteEntity(@RequestBody AffittoEntity entityToDelete) throws NotFoundException {
        affittoService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-altro-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteAcquaEntity(@RequestBody AltroCasaEntity entityToDelete) throws NotFoundException {
        altroCasaService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-arredamento-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteElettricheEntity(@RequestBody ArredamentoEntity entityToDelete)
            throws NotFoundException {
        arredamentoService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-forniture-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteGASEntity(@RequestBody FornitureCasaEntity entityToDelete) throws NotFoundException {
        fornitureCasaService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-manutenzione-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteInternetEntity(@RequestBody ManutenzioneEntity entityToDelete)
            throws NotFoundException {
        manutenzioneService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-miglioramenti-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteRifiutiEntity(@RequestBody MiglioramentiEntity entityToDelete)
            throws NotFoundException {
        miglioramentiService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-trasloco-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneBolletteTelefonoEntity(@RequestBody TraslocoEntity entityToDelete) throws NotFoundException {
        traslocoService.delete(entityToDelete);
    }

    @DeleteMapping(value = "/delete-one-bollette-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAssicurazione(@RequestBody CasaEntity entityToDelete) throws NotFoundException {
        if (!entityToDelete.getAffittoEntities().isEmpty()) {
            affittoService.deleteAll(entityToDelete.getAffittoEntities());
        }
        if (!entityToDelete.getAltroEntities().isEmpty()) {
            altroCasaService.deleteAll(entityToDelete.getAltroEntities());
        }
        if (!entityToDelete.getArredamentoEntities().isEmpty()) {
            arredamentoService.deleteAll(entityToDelete.getArredamentoEntities());
        }
        if (!entityToDelete.getManutenzioneEntities().isEmpty()) {
            manutenzioneService.deleteAll(entityToDelete.getManutenzioneEntities());
        }
        if (!entityToDelete.getMiglioramentiEntities().isEmpty()) {
            miglioramentiService.deleteAll(entityToDelete.getMiglioramentiEntities());
        }
        if (!entityToDelete.getTraslocoEntities().isEmpty()) {
            traslocoService.deleteAll(entityToDelete.getTraslocoEntities());
        }
    }

    // SAVE ONE
    @PutMapping(value = "/save-one-affitto-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AffittoEntity addOneAffittoEntity(@RequestBody AffittoEntity entity) {
        return affittoService.save(entity);
    }

    @PutMapping(value = "/save-one-altro-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroCasaEntity addOneAltroCasaEntity(@RequestBody AltroCasaEntity entity) {
        return altroCasaService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-elettriche-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArredamentoEntity addOneArredamentoEntity(@RequestBody ArredamentoEntity entity) {
        return arredamentoService.save(entity);
    }

    @PutMapping(value = "/save-one-forniture-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FornitureCasaEntity addOneFornitureCasaEntity(@RequestBody FornitureCasaEntity entity) {
        return fornitureCasaService.save(entity);
    }

    @PutMapping(value = "/save-one-manutenzione-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManutenzioneEntity addOneManutenzioneEntity(@RequestBody ManutenzioneEntity entity) {
        return manutenzioneService.save(entity);
    }

    @PutMapping(value = "/save-one-miglioramenti-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MiglioramentiEntity addOneMiglioramentiEntity(@RequestBody MiglioramentiEntity entity) {
        return miglioramentiService.save(entity);
    }

    @PutMapping(value = "/save-one-bollette-telefono-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TraslocoEntity addOneBolletteTelefoEntity(@RequestBody TraslocoEntity entity) {
        return traslocoService.save(entity);
    }

    // SAVE MORE ENTITY
    @PutMapping(value = "/save-one-salario-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CasaEntity addOneSalarioEntity(@RequestBody CasaEntity casaEntity) {
        Iterable<AffittoEntity> affittoEntities = casaEntity.getAffittoEntities();
        Iterable<AltroCasaEntity> altroCasaEntities = casaEntity.getAltroEntities();
        Iterable<ArredamentoEntity> arredamentoEntities = casaEntity.getArredamentoEntities();
        Iterable<FornitureCasaEntity> fornitureEntities = casaEntity.getFornitureEntities();
        Iterable<ManutenzioneEntity> manutenzioneEntities = casaEntity.getManutenzioneEntities();
        Iterable<MiglioramentiEntity> miglioramentiEntities = casaEntity.getMiglioramentiEntities();
        Iterable<TraslocoEntity> traslocoEntities = casaEntity.getTraslocoEntities();

        affittoService.saveAll(affittoEntities);
        altroCasaService.saveAll(altroCasaEntities);
        arredamentoService.saveAll(arredamentoEntities);
        fornitureCasaService.saveAll(fornitureEntities);
        manutenzioneService.saveAll(manutenzioneEntities);
        miglioramentiService.saveAll(miglioramentiEntities);
        traslocoService.saveAll(traslocoEntities);

        return casaEntity;
    }
}
