package com.project.bebudgeting.annuale.controller.entrate;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.ManceEntity;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.AltroSalarioService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.BonusService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.BustaPagaService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.CommissioniService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.ManceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value = "/getAllBustaPagaEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BustaPagaEntity> findAllBustaPagaEntity() {
        return bustaPagaService.findAll();
    }

    @GetMapping(value = "/getAllBonusEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BonusEntity> findAllBonusEntity() {
        return bonusService.findAll();
    }

    @GetMapping(value = "/getAllCommissioniEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CommissioniEntity> findAllCommissioniEntity() {
        return commissioniService.findAll();
    }

    @GetMapping(value = "/getAllManceEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ManceEntity> findAllManceEntity() {
        return manceService.findAll();
    }

    // FIND ONE ENTITY
    @GetMapping(value = "/getOneBustaPagaEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BustaPagaEntity> getOneBustaPagaEntity(@RequestParam int id) {
        return bustaPagaService.findById(id);
    }

    @GetMapping(value = "/getOneBonusEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BonusEntity> getOneBonusEntity(@RequestParam int id) {
        return bonusService.findById(id);
    }

    @GetMapping(value = "/getOneCommissioniEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<CommissioniEntity> getCommissioniEntity(@RequestParam int id) {
        return commissioniService.findById(id);
    }

    @GetMapping(value = "/getOneManceEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ManceEntity> getOneManceEntity(@RequestParam int id) {
        return manceService.findById(id);
    }

    // SAVE ONE ENTITY
    @PutMapping(value = "/saveOneBustaPagaEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BustaPagaEntity addOneBustaPagaEntity(@RequestBody BustaPagaEntity entity) {
        return bustaPagaService.save(entity);
    }

    @PutMapping(value = "/saveOneBonusEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BonusEntity addOneBonusEntity(@RequestBody BonusEntity entity) {
        return bonusService.save(entity);
    }

    @PutMapping(value = "/saveOneCommissioniEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommissioniEntity addOneCommissioniEntity(@RequestBody CommissioniEntity entity) {
        return commissioniService.save(entity);
    }

    @PutMapping(value = "/saveOneManceEntity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManceEntity addOneManceEntity(@RequestBody ManceEntity entity) {
        return manceService.save(entity);
    }
}
