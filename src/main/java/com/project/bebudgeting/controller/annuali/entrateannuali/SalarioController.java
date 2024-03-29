package com.project.bebudgeting.controller.annuali.entrateannuali;

import java.util.ArrayList;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.SalarioEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.ManceEntity;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.AltroSalarioService;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.BonusService;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.BustaPagaService;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.CommissioniService;
import com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice.ManceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Salario", tags = "Salario", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/salario")
public class SalarioController {

    @Autowired
    AltroSalarioService altroSalarioService;

    @Autowired
    BonusService bonusService;

    @Autowired
    BustaPagaService bustaPagaService;

    @Autowired
    CommissioniService commissioniService;

    @Autowired
    ManceService manceService;

    // FIND ALL ENTITY
    /**
     * @return Iterable<AltroSalarioEntity>
     */
    @GetMapping(value = "/get-all-altro-salario-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroSalarioEntity> findAllAltroSalarioEntities() {
        return altroSalarioService.findAll();
    }

    /**
     * @return Iterable<BustaPagaEntity>
     */
    @GetMapping(value = "/get-all-busta-paga-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BustaPagaEntity> findAllBustaPagaEntities() {
        return bustaPagaService.findAll();
    }

    /**
     * @return Iterable<BonusEntity>
     */
    @GetMapping(value = "/get-all-bonus-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BonusEntity> findAllBonusEntities() {
        return bonusService.findAll();
    }

    /**
     * @return Iterable<CommissioniEntity>
     */
    @GetMapping(value = "/get-all-commissioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CommissioniEntity> findAllCommissioniEntities() {
        return commissioniService.findAll();
    }

    /**
     * @return Iterable<ManceEntity>
     */
    @GetMapping(value = "/get-all-mance-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ManceEntity> findAllManceEntities() {
        return manceService.findAll();
    }

    /**
     * @return SalarioEntity
     */
    @GetMapping(value = "/get-all-salario-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public SalarioEntity findAllSalarioEntities() {
        SalarioEntity ret = new SalarioEntity();
        ret.setAltroSalarioEntity((ArrayList<AltroSalarioEntity>) altroSalarioService.findAll());
        ret.setBonusEntity((ArrayList<BonusEntity>) bonusService.findAll());
        ret.setBustaPagaEntity((ArrayList<BustaPagaEntity>) bustaPagaService.findAll());
        ret.setCommissioniEntity((ArrayList<CommissioniEntity>) commissioniService.findAll());
        ret.setManceEntity((ArrayList<ManceEntity>) manceService.findAll());
        return ret;
    }

    // FIND ONE ENTITY
    /**
     * @param id
     * @return Optional<BustaPagaEntity>
     */
    @GetMapping(value = "/get-one-busta-paga-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BustaPagaEntity> getOneBustaPagaEntity(@RequestParam int id) {
        return bustaPagaService.findById(id);
    }

    /**
     * @param id
     * @return Optional<BonusEntity>
     */
    @GetMapping(value = "/get-one-bonus-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BonusEntity> getOneBonusEntity(@RequestParam int id) {
        return bonusService.findById(id);
    }

    /**
     * @param id
     * @return Optional<CommissioniEntity>
     */
    @GetMapping(value = "/get-one-commissioni-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<CommissioniEntity> getCommissioniEntity(@RequestParam int id) {
        return commissioniService.findById(id);
    }

    /**
     * @param id
     * @return Optional<ManceEntity>
     */
    @GetMapping(value = "/get-one-Mance-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ManceEntity> getOneManceEntity(@RequestParam int id) {
        return manceService.findById(id);
    }

    /**
     * @param id
     * @return SalarioEntity
     */
    @GetMapping(value = "/get-one-Salario-entity", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SalarioEntity findOneSalarioEntity(@RequestParam int id) {
        SalarioEntity ret = new SalarioEntity();

        ArrayList<AltroSalarioEntity> altroSalarioEntities = new ArrayList<>();
        ArrayList<BonusEntity> bonusEntities = new ArrayList<>();
        ArrayList<BustaPagaEntity> bustaPagaEntities = new ArrayList<>();
        ArrayList<CommissioniEntity> commissioniEntities = new ArrayList<>();
        ArrayList<ManceEntity> manceEntities = new ArrayList<>();

        altroSalarioEntities.add(altroSalarioService.findById(id).get());
        bonusEntities.add(bonusService.findById(id).get());
        bustaPagaEntities.add(bustaPagaService.findById(id).get());
        commissioniEntities.add(commissioniService.findById(id).get());
        manceEntities.add(manceService.findById(id).get());

        ret.setAltroSalarioEntity(altroSalarioEntities);
        ret.setBonusEntity(bonusEntities);
        ret.setBustaPagaEntity(bustaPagaEntities);
        ret.setCommissioniEntity(commissioniEntities);
        ret.setManceEntity(manceEntities);
        return ret;
    }

    // SAVE ONE ENTITY
    /**
     * @param entity
     * @return AltroSalarioEntity
     */
    @PutMapping(value = "/save-one-altro-salario-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AltroSalarioEntity addOneAltroSalarioEntity(@RequestBody AltroSalarioEntity entity) {
        return altroSalarioService.save(entity);
    }

    /**
     * @param entity
     * @return BustaPagaEntity
     */
    @PutMapping(value = "/save-one-busta-paga-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BustaPagaEntity addOneBustaPagaEntity(@RequestBody BustaPagaEntity entity) {
        return bustaPagaService.save(entity);
    }

    /**
     * @param entity
     * @return BonusEntity
     */
    @PutMapping(value = "/save-one-bonus-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BonusEntity addOneBonusEntity(@RequestBody BonusEntity entity) {
        return bonusService.save(entity);
    }

    /**
     * @param entity
     * @return CommissioniEntity
     */
    @PutMapping(value = "/save-one-commissioni-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommissioniEntity addOneCommissioniEntity(@RequestBody CommissioniEntity entity) {
        return commissioniService.save(entity);
    }

    /**
     * @param entity
     * @return ManceEntity
     */
    @PutMapping(value = "/save-one-mance-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManceEntity addOneManceEntity(@RequestBody ManceEntity entity) {
        return manceService.save(entity);
    }

    // SAVE MORE ENTITY
    /**
     * @param salarioEntity
     * @return SalarioEntity
     */
    @PutMapping(value = "/save-one-salario-entity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SalarioEntity addOneSalarioEntity(@RequestBody SalarioEntity salarioEntity) {
        Iterable<AltroSalarioEntity> altroSalarioIterable = salarioEntity.getAltroSalarioEntity();
        Iterable<BonusEntity> bonusIterable = salarioEntity.getBonusEntity();
        Iterable<BustaPagaEntity> bustaPagaIterable = salarioEntity.getBustaPagaEntity();
        Iterable<CommissioniEntity> commissioniIterable = salarioEntity.getCommissioniEntity();
        Iterable<ManceEntity> manceIterable = salarioEntity.getManceEntity();

        altroSalarioService.saveAll(altroSalarioIterable);
        bonusService.saveAll(bonusIterable);
        bustaPagaService.saveAll(bustaPagaIterable);
        commissioniService.saveAll(commissioniIterable);
        manceService.saveAll(manceIterable);

        return salarioEntity;
    }

    // DELETE
    /**
     * @param salarioEntity
     * @return ResponseEntity<String>
     */
    @DeleteMapping(value = "/delete-one-salario-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteOneSalarioEntity(@RequestBody SalarioEntity salarioEntity) {
        Iterable<AltroSalarioEntity> altroSalarioIterable = salarioEntity.getAltroSalarioEntity();
        Iterable<BonusEntity> bonusIterable = salarioEntity.getBonusEntity();
        Iterable<BustaPagaEntity> bustaPagaIterable = salarioEntity.getBustaPagaEntity();
        Iterable<CommissioniEntity> commissioniIterable = salarioEntity.getCommissioniEntity();
        Iterable<ManceEntity> manceIterable = salarioEntity.getManceEntity();

        if (altroSalarioService.deleteAll(altroSalarioIterable) && bonusService.deleteAll(bonusIterable)
                && bustaPagaService.deleteAll(bustaPagaIterable) && commissioniService.deleteAll(commissioniIterable)
                && manceService.deleteAll(manceIterable)) {
            return ((BodyBuilder) new ResponseEntity<String>(HttpStatus.ACCEPTED))
                    .body("Operazioni eseguite e cancellate");
        } else {
            return ((BodyBuilder) new ResponseEntity<String>(HttpStatus.BAD_REQUEST))
                    .body("Operazioni non eseguite e cancellate");
        }
    }
}
