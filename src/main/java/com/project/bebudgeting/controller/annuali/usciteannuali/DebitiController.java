package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.DebitiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.PrestitiPerStudiareEntity;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.AltriPrestitiService;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.AltroDebitiService;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.CarteCreditoService;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.ImposteLocaliService;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.ImposteStataliService;
import com.project.bebudgeting.service.annuali.usciteservice.debitiservice.PrestitiPerStudioService;

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

@Api(value = "Debiti", tags = "Debiti", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/debiti")
public class DebitiController {
    @Autowired
    AltriPrestitiService altriPrestitiService;

    @Autowired
    AltroDebitiService altroDebitiService;

    @Autowired
    CarteCreditoService carteCreditoService;

    @Autowired
    ImposteLocaliService imposteLocaliService;

    @Autowired
    ImposteStataliService imposteStataliService;

    @Autowired
    PrestitiPerStudioService prestitiPerStudioService;

    // GET ALL
    @GetMapping(value = "/get-all-altri-prestiti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltriPrestitiEntity> getAllAltriPrestitiEntity() {
        return altriPrestitiService.findAll();
    }

    @GetMapping(value = "/get-all-altri-debiti-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroDebitiEntity> getAllAltriDebitiEntity() {
        return altroDebitiService.findAll();
    }

    @GetMapping(value = "/get-all-carte-credito-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CarteCreditoEntity> getAllCarteCreditoEntity() {
        return carteCreditoService.findAll();
    }

    @GetMapping(value = "/get-all-imposte-locali-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ImposteLocaliEntity> getAllImposteLocaliEntity() {
        return imposteLocaliService.findAll();
    }

    @GetMapping(value = "/get-all-imposte-statali-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ImposteStataliEntity> getAllImposteStataliEntity() {
        return imposteStataliService.findAll();
    }

    @GetMapping(value = "/get-all-prestiti-studio-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PrestitiPerStudiareEntity> getAllPrestitiPerStudioEntity() {
        return prestitiPerStudioService.findAll();
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-altri-prestiti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltriPrestitiEntity(@RequestBody Iterable<Integer> ids) {
        altriPrestitiService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-altri-debiti-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltriDebitiEntity(@RequestBody Iterable<Integer> ids) {
        altroDebitiService.findAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-carte-credito-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllCarteCreditoEntity(@RequestBody Iterable<Integer> ids) {
        carteCreditoService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-imposte-locali-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllImposteLocaliEntity(@RequestBody Iterable<Integer> ids) {
        imposteLocaliService.deleteAllById(ids);

    }

    @DeleteMapping(value = "/delete-all-selected-imposte-statali-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllImposteStataliEntity(@RequestBody Iterable<Integer> ids) {
        imposteStataliService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-prestiti-studio-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllPrestitiPerStudioEntity(@RequestBody Iterable<Integer> ids) {
        prestitiPerStudioService.deleteAllById(ids);
    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-selected-altri-prestiti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltriPrestitiEntity(@RequestBody AltriPrestitiEntity entity) throws NotFoundException {
        altriPrestitiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-altri-debiti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltriDebitiEntity(@RequestBody AltroDebitiEntity entity) throws NotFoundException {
        altroDebitiService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-carte-credito-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneCarteCreditoEntity(@RequestBody CarteCreditoEntity entity) throws NotFoundException {
        carteCreditoService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-imposte-locali-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneImposteLocaliEntity(@RequestBody ImposteLocaliEntity entity) throws NotFoundException {
        imposteLocaliService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-imposte-statali-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneImposteStataliEntity(@RequestBody ImposteStataliEntity entity) throws NotFoundException {
        imposteStataliService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-prestiti-studio-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOnePrestitiPerStudio(@RequestBody PrestitiPerStudiareEntity entity) throws NotFoundException {
        prestitiPerStudioService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-debiti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneDebitiEntity(@RequestBody DebitiEntity entity) {
        if (!entity.getAltriPrestitiEntities().isEmpty()) {
            altriPrestitiService.deleteAll(entity.getAltriPrestitiEntities());
        }
        if (!entity.getAltroEntities().isEmpty()) {
            altroDebitiService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getCarteCreditoEntities().isEmpty()) {
            carteCreditoService.deleteAll(entity.getCarteCreditoEntities());
        }
        if (!entity.getImposteLocaliEntities().isEmpty()) {
            imposteLocaliService.deleteAll(entity.getImposteLocaliEntities());
        }
        if (!entity.getImposteStataliEntities().isEmpty()) {
            imposteStataliService.deleteAll(entity.getImposteStataliEntities());
        }
        if (!entity.getPrestitiPerStudiareEntities().isEmpty()) {
            prestitiPerStudioService.deleteAll(entity.getPrestitiPerStudiareEntities());
        }
    }

    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altri-prestiti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltriPrestitiEntity saveOneAltriPrestitiEntity(@RequestBody AltriPrestitiEntity entity) {
        return altriPrestitiService.save(entity);
    }

    @PutMapping(value = "/save-one-altri-debiti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroDebitiEntity saveOneAltroDebitiEntity(@RequestBody AltroDebitiEntity entity) {
        return altroDebitiService.save(entity);
    }

    @PutMapping(value = "/save-one-carte-credito-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CarteCreditoEntity saveOneCarteCreditoEntity(@RequestBody CarteCreditoEntity entity) {
        return carteCreditoService.save(entity);
    }

    @PutMapping(value = "/save-one-imposte-locali-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImposteLocaliEntity saveOneImposteLocaliEntity(@RequestBody ImposteLocaliEntity entity) {
        return imposteLocaliService.save(entity);
    }

    @PutMapping(value = "/save-one-imposte-statali-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImposteStataliEntity saveOneImposteStataliEntity(@RequestBody ImposteStataliEntity entity) {
        return imposteStataliService.save(entity);
    }

    @PutMapping(value = "/save-one-prestiti-studio-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PrestitiPerStudiareEntity saveOnePrestitiPerStudiareEntity(@RequestBody PrestitiPerStudiareEntity entity) {
        return prestitiPerStudioService.save(entity);
    }

    // SAVE MORE ENTITY
    @RequestMapping(value = "/save-one-debiti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DebitiEntity saveOneDebitiEntity(@RequestBody DebitiEntity entity) {
        Iterable<AltriPrestitiEntity> altriPrestitiEntities = entity.getAltriPrestitiEntities();
        Iterable<AltroDebitiEntity> altroDebitiEntities = entity.getAltroEntities();
        Iterable<CarteCreditoEntity> carteCreditoEntities = entity.getCarteCreditoEntities();
        Iterable<ImposteLocaliEntity> imposteLocaliEntities = entity.getImposteLocaliEntities();
        Iterable<ImposteStataliEntity> imposteStataliEntities = entity.getImposteStataliEntities();
        Iterable<PrestitiPerStudiareEntity> prestitiPerStudiareEntities = entity.getPrestitiPerStudiareEntities();

        altriPrestitiService.saveAll(altriPrestitiEntities);
        altroDebitiService.saveAll(altroDebitiEntities);
        carteCreditoService.saveAll(carteCreditoEntities);
        imposteLocaliService.saveAll(imposteLocaliEntities);
        imposteStataliService.saveAll(imposteStataliEntities);
        prestitiPerStudioService.saveAll(prestitiPerStudiareEntities);

        return entity;
    }
}
