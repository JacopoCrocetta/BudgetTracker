package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.CasaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.TraslocoEntity;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.AffittoService;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.AltroCasaService;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.ArredamentoService;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.FornitureCasaService;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.ManutenzioneService;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.MiglioramentiService;
import com.project.bebudgeting.service.annuali.usciteservice.casaservice.TraslocoService;

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

    /**
     * @return Iterable<AffittoEntity>
     */
    // GET ALL
    @GetMapping(value = "/get-all-affitto-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AffittoEntity> getAllAffittoEntities() {
        return affittoService.findAll();
    }

    /**
     * @return Iterable<AltroCasaEntity>
     */
    @GetMapping(value = "/get-all-altro-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroCasaEntity> getAllAltroCasaEntities() {
        return altroCasaService.findAll();
    }

    /**
     * @return Iterable<ArredamentoEntity>
     */
    @GetMapping(value = "/get-all-arredamento-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ArredamentoEntity> getAllArredamentoCasaEntities() {
        return arredamentoService.findAll();
    }

    /**
     * @return Iterable<FornitureCasaEntity>
     */
    @GetMapping(value = "/get-all-forniture-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FornitureCasaEntity> getAllFornitureCasaEntities() {
        return fornitureCasaService.findAll();
    }

    /**
     * @return Iterable<ManutenzioneEntity>
     */
    @GetMapping(value = "/get-all-manutenzione-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ManutenzioneEntity> getAllManutenzioneCasaEntities() {
        return manutenzioneService.findAll();
    }

    /**
     * @return Iterable<MiglioramentiEntity>
     */
    @GetMapping(value = "/get-all-miglioramenti-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MiglioramentiEntity> getAllMiglioramentiCasaEntities() {
        return miglioramentiService.findAll();
    }

    /**
     * @return Iterable<TraslocoEntity>
     */
    @GetMapping(value = "/get-all-trasloco-casa-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TraslocoEntity> getAllTraslocoCasaEntities() {
        return traslocoService.findAll();
    }

    /**
     * @param ids
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-affitto-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAffittoEntities(@RequestBody Iterable<Integer> ids) {
        affittoService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-altro-casa-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroCasaService(@RequestBody Iterable<Integer> ids) {
        altroCasaService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-arredamento-casa-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllArredamentoEntities(@RequestBody Iterable<Integer> ids) {
        arredamentoService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-forniture-casa-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFornitureCasaEntities(@RequestBody Iterable<Integer> ids) {
        fornitureCasaService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-manutenzione-casa-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllManutenzioneCasaEntities(@RequestBody Iterable<Integer> ids) {
        manutenzioneService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-miglioramenti-casa-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllMiglioramentiCasaEntities(@RequestBody Iterable<Integer> ids) {
        miglioramentiService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-trasloco-casa-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllTraslocoCasaEntities(@RequestBody Iterable<Integer> ids) {
        traslocoService.deleteAllById(ids);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-affitto-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAffittoCasaEntity(@RequestBody AffittoEntity entityToDelete) throws NotFoundException {
        affittoService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-altro-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroCasaEntity(@RequestBody AltroCasaEntity entityToDelete) throws NotFoundException {
        altroCasaService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-arredamento-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneArredamentoCasaEntity(@RequestBody ArredamentoEntity entityToDelete) throws NotFoundException {
        arredamentoService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-forniture-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFornitureCasaEntity(@RequestBody FornitureCasaEntity entityToDelete) throws NotFoundException {
        fornitureCasaService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-manutenzione-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneManutenzioneCasaEntity(@RequestBody ManutenzioneEntity entityToDelete)
            throws NotFoundException {
        manutenzioneService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-miglioramenti-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneMiglioramentiCasaEntity(@RequestBody MiglioramentiEntity entityToDelete)
            throws NotFoundException {
        miglioramentiService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-trasloco-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneTraslocoCasaEntity(@RequestBody TraslocoEntity entityToDelete) throws NotFoundException {
        traslocoService.delete(entityToDelete);
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneCasaEntity(@RequestBody CasaEntity entityToDelete) throws NotFoundException {
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

    /**
     * @param entity
     * @return AffittoEntity
     */
    // SAVE ONE
    @PutMapping(value = "/save-one-affitto-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AffittoEntity addOneAffittoEntity(@RequestBody AffittoEntity entity) {
        return affittoService.save(entity);
    }

    /**
     * @param entity
     * @return AltroCasaEntity
     */
    @PutMapping(value = "/save-one-altro-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroCasaEntity addOneAltroCasaEntity(@RequestBody AltroCasaEntity entity) {
        return altroCasaService.save(entity);
    }

    /**
     * @param entity
     * @return ArredamentoEntity
     */
    @PutMapping(value = "/save-one-arredamento-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArredamentoEntity addOneArredamentoEntity(@RequestBody ArredamentoEntity entity) {
        return arredamentoService.save(entity);
    }

    /**
     * @param entity
     * @return FornitureCasaEntity
     */
    @PutMapping(value = "/save-one-forniture-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FornitureCasaEntity addOneFornitureCasaEntity(@RequestBody FornitureCasaEntity entity) {
        return fornitureCasaService.save(entity);
    }

    /**
     * @param entity
     * @return ManutenzioneEntity
     */
    @PutMapping(value = "/save-one-manutenzione-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManutenzioneEntity addOneManutenzioneEntity(@RequestBody ManutenzioneEntity entity) {
        return manutenzioneService.save(entity);
    }

    /**
     * @param entity
     * @return MiglioramentiEntity
     */
    @PutMapping(value = "/save-one-miglioramenti-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MiglioramentiEntity addOneMiglioramentiEntity(@RequestBody MiglioramentiEntity entity) {
        return miglioramentiService.save(entity);
    }

    /**
     * @param entity
     * @return TraslocoEntity
     */
    @PutMapping(value = "/save-one-trasloco-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TraslocoEntity addOneTraslocoCasaEntity(@RequestBody TraslocoEntity entity) {
        return traslocoService.save(entity);
    }

    /**
     * @param casaEntity
     * @return CasaEntity
     */
    // SAVE MORE ENTITY
    @PutMapping(value = "/save-one-casa-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CasaEntity addOneCasaEntity(@RequestBody CasaEntity casaEntity) {
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
