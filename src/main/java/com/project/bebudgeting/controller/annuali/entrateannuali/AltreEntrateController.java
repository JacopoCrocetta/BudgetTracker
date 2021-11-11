package com.project.bebudgeting.controller.annuali.entrateannuali;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.AltreEntrateEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.AltroEService;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.DividendiService;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.InteressiService;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.RegaliAltreEntrateService;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.RimborsiService;
import com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice.TrasferimentoRisparmiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Altre Entrate", tags = "Altre Entrate", description = "REST APIs related to Altre Entrate Entity")
@RestController
@RequestMapping("/altre-entrate")
public class AltreEntrateController {
    @Autowired
    AltroEService altroEService;

    @Autowired
    DividendiService dividendiService;

    @Autowired
    InteressiService interessiService;

    @Autowired
    RegaliAltreEntrateService regaliAltreEntrateService;

    @Autowired
    RimborsiService rimborsiService;

    @Autowired
    TrasferimentoRisparmiService trasferimentoRisparmiService;

    // FIND ALL ENTITY
    @GetMapping(value = "/find-all-altro-eservice", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroAltreEntrateEntity> findAllAltroEntrateEntity() {
        return altroEService.findAll();
    }

    @GetMapping(value = "/find-all-dividendi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DividendiEntity> findAllDividendiEntity() {
        return dividendiService.findAll();
    }

    @GetMapping(value = "/find-all-interessi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<InteressiEntity> findAllInteressiEntity() {
        return interessiService.findAll();
    }

    @GetMapping(value = "/find-all-regali-altre-entrate-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RegaliAltreEntrateEntity> findAllRegaliAltreEntrateEntity() {
        return regaliAltreEntrateService.findAll();
    }

    @GetMapping(value = "/find-all-rimborsi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RimborsiEntity> findAllRimborsiEntities() {
        return rimborsiService.findAll();
    }

    @GetMapping(value = "/find-all-trasferimento-risparmi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TrasferimentoRisparmiEntity> findAllTrasferimentoRisparmiEntities() {
        return trasferimentoRisparmiService.findAll();
    }

    @GetMapping(value = "/find-all-altre-entrate-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public AltreEntrateEntity findAllALtreEntrateEntities() {
        AltreEntrateEntity ret = new AltreEntrateEntity();
        ret.setAltroEntities((List<AltroAltreEntrateEntity>) altroEService.findAll());
        ret.setDividendiEntities((List<DividendiEntity>) dividendiService.findAll());
        ret.setInteressiEntities((List<InteressiEntity>) interessiService.findAll());
        ret.setRegaliEntities((List<RegaliAltreEntrateEntity>) regaliAltreEntrateService.findAll());
        ret.setRimborsiEntities((List<RimborsiEntity>) rimborsiService.findAll());
        ret.setTrasferimentoRisparmiEntities(
                (List<TrasferimentoRisparmiEntity>) trasferimentoRisparmiService.findAll());
        return ret;
    }

    // FIND ONE ENTITY
    @GetMapping(value = "/find-one-altro-altre-entrate-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<AltroAltreEntrateEntity> findOneAltroAltreEntrateEntity(@RequestParam int id) {
        return altroEService.findById(id);
    }

    @GetMapping(value = "/find-one-dividendi-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<DividendiEntity> findOneDividendiEntity(@RequestParam int id) {
        return dividendiService.findById(id);
    }

    @GetMapping(value = "/find-one-interessi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<InteressiEntity> findOneInteressiEntities(@RequestParam int id) {
        return interessiService.findById(id);
    }

    @GetMapping(value = "/find-one-regali-altre-entrate-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<RegaliAltreEntrateEntity> findOneRegaliAltreEntrateEntity(@RequestParam int id) {
        return regaliAltreEntrateService.findById(id);
    }

    @GetMapping(value = "/find-one-rimborsi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<RimborsiEntity> findOneRimborsiEntities(@RequestParam int id) {
        return rimborsiService.findById(id);
    }

    @GetMapping(value = "/find-one-trasferimento-risparmi-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<TrasferimentoRisparmiEntity> findOneTrasferimentoRisparmiEntities(@RequestParam int id) {
        return trasferimentoRisparmiService.findById(id);
    }

    @GetMapping(value = "/find-one-altre-entrate-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public AltreEntrateEntity findOneAltreEntrateEntity(@RequestParam int id) {
        AltreEntrateEntity ret = new AltreEntrateEntity();

        ArrayList<AltroAltreEntrateEntity> altroAltreEntrateEntities = new ArrayList<>();
        ArrayList<DividendiEntity> dividendiEntities = new ArrayList<>();
        ArrayList<InteressiEntity> interessiEntities = new ArrayList<>();
        ArrayList<RegaliAltreEntrateEntity> regaliAltreEntrateEntities = new ArrayList<>();
        ArrayList<RimborsiEntity> rimborsiEntities = new ArrayList<>();
        ArrayList<TrasferimentoRisparmiEntity> trasferimentoRisparmiEntities = new ArrayList<>();

        altroAltreEntrateEntities.add(altroEService.findById(id).get());
        dividendiEntities.add(dividendiService.findById(id).get());
        interessiEntities.add(interessiService.findById(id).get());
        regaliAltreEntrateEntities.add(regaliAltreEntrateService.findById(id).get());
        rimborsiEntities.add(rimborsiService.findById(id).get());
        trasferimentoRisparmiEntities.add(trasferimentoRisparmiService.findById(id).get());

        ret.setAltroEntities(altroAltreEntrateEntities);
        ret.setDividendiEntities(dividendiEntities);
        ret.setInteressiEntities(interessiEntities);
        ret.setRegaliEntities(regaliAltreEntrateEntities);
        ret.setRimborsiEntities(rimborsiEntities);
        ret.setTrasferimentoRisparmiEntities(trasferimentoRisparmiEntities);
        return ret;
    }

    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altro-altre-entrate-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroAltreEntrateEntity saveOneAltroAltreEntrateEntity(@RequestBody AltroAltreEntrateEntity entity) {
        return altroEService.save(entity);
    }

    @PutMapping(value = "/save-one-dividendo-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DividendiEntity saveOneDividendoEntity(@RequestBody DividendiEntity entity) {
        return dividendiService.save(entity);
    }

    @PutMapping(value = "/save-one-interessi-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InteressiEntity saveOneInteressiEntity(@RequestBody InteressiEntity entity) {
        return interessiService.save(entity);
    }

    @PutMapping(value = "/save-one-RegaliAltreEntrateEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegaliAltreEntrateEntity saveOneRegaliAltreEntrateEntity(@RequestBody RegaliAltreEntrateEntity entity) {
        return regaliAltreEntrateService.save(entity);
    }

    @PutMapping(value = "/save-one-RimborsiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RimborsiEntity saveOneRimborsiEntity(@RequestBody RimborsiEntity entity) {
        return rimborsiService.save(entity);
    }

    @PutMapping(value = "/save-one-TrasferimentoRisparmiEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrasferimentoRisparmiEntity saveOneTrasferimentoRisparmiEntity(
            @RequestBody TrasferimentoRisparmiEntity entity) {
        return trasferimentoRisparmiService.save(entity);
    }

    // SAVE MORE ENTITY
    @PutMapping(value = "/save-altra-entrata-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltreEntrateEntity addOneAltreEntrateEntity(@RequestBody AltreEntrateEntity altreEntrateEntity) {
        Iterable<AltroAltreEntrateEntity> altroAltreEntrateEntities = altreEntrateEntity.getAltroEntities();
        Iterable<DividendiEntity> dividendiEntities = altreEntrateEntity.getDividendiEntities();
        Iterable<InteressiEntity> interessiEntities = altreEntrateEntity.getInteressiEntities();
        Iterable<RegaliAltreEntrateEntity> regaliAltreEntrateEntities = altreEntrateEntity.getRegaliEntities();
        Iterable<RimborsiEntity> rimborsiEntities = altreEntrateEntity.getRimborsiEntities();
        Iterable<TrasferimentoRisparmiEntity> tIterable = altreEntrateEntity.getTrasferimentoRisparmiEntities();

        altroEService.saveAll(altroAltreEntrateEntities);
        dividendiService.saveAll(dividendiEntities);
        interessiService.saveAll(interessiEntities);
        regaliAltreEntrateService.saveAll(regaliAltreEntrateEntities);
        rimborsiService.saveAll(rimborsiEntities);
        trasferimentoRisparmiService.saveAll(tIterable);

        return altreEntrateEntity;
    }
}
