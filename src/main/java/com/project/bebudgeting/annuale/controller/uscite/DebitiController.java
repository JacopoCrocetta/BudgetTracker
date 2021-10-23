package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.entity.uscite.DebitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.PrestitiPerStudiareEntity;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.AltriPrestitiService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.AltroDebitiService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.CarteCreditoService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.ImposteLocaliService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.ImposteStataliService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.PrestitiPerStudioService;

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

    @GetMapping(value = "/get-all-altri-debiti-entity")
    public Iterable<AltroDebitiEntity> getAllAltriDebitiEntity() {
        return altroDebitiService.findAll();
    }

    @GetMapping()
    public Iterable<CarteCreditoEntity> getAllCarteCreditoEntity() {
        return carteCreditoService.findAll();
    }

    @GetMapping()
    public Iterable<ImposteLocaliEntity> getAllImposteLocaliEntity() {
        return imposteLocaliService.findAll();
    }

    @GetMapping()
    public Iterable<ImposteStataliEntity> getAllImposteStataliEntity() {
        return imposteStataliService.findAll();
    }

    @GetMapping()
    public Iterable<PrestitiPerStudiareEntity> getAllPrestitiPerStudioEntity() {
        return prestitiPerStudioService.findAll();
    }

    // DELETE ALL
    @DeleteMapping()
    public void deleteAllAltriPrestitiEntity(@RequestBody Iterable<Integer> ids) {
        altriPrestitiService.deleteAllById(ids);
    }

    @DeleteMapping()
    public void deleteAllAltriDebitiEntity(@RequestBody Iterable<Integer> ids) {
        altroDebitiService.findAllById(ids);
    }

    @DeleteMapping()
    public void deleteAllCarteCreditoEntity(@RequestBody Iterable<Integer> ids) {
        carteCreditoService.deleteAllById(ids);
    }

    @DeleteMapping
    public void deleteAllImposteLocaliEntity(@RequestBody Iterable<Integer> ids) {
        imposteLocaliService.deleteAllById(ids);

    }

    @DeleteMapping
    public void deleteAllImposteStataliEntity(@RequestBody Iterable<Integer> ids) {
        imposteStataliService.deleteAllById(ids);
    }

    @DeleteMapping
    public void deleteAllPrestitiPerStudioEntity(@RequestBody Iterable<Integer> ids) {
        prestitiPerStudioService.deleteAllById(ids);
    }

    // DELETE ONE ENTITY
    @DeleteMapping
    public void deleteOneAltriPrestitiEntity(@RequestBody AltriPrestitiEntity entity) throws NotFoundException {
        altriPrestitiService.delete(entity);
    }

    @DeleteMapping
    public void deleteOneAltriDebitiEntity(@RequestBody AltroDebitiEntity entity) throws NotFoundException {
        altroDebitiService.delete(entity);
    }

    @DeleteMapping
    public void deleteOneCarteCreditoEntity(@RequestBody CarteCreditoEntity entity) throws NotFoundException {
        carteCreditoService.delete(entity);
    }

    @DeleteMapping
    public void deleteOneImposteLocaliEntity(@RequestBody ImposteLocaliEntity entity) throws NotFoundException {
        imposteLocaliService.delete(entity);
    }

    @DeleteMapping
    public void deleteOneImposteStataliEntity(@RequestBody ImposteStataliEntity entity) throws NotFoundException {
        imposteStataliService.delete(entity);
    }

    @DeleteMapping
    public void deleteOnePrestitiPerStudio(@RequestBody PrestitiPerStudiareEntity entity) throws NotFoundException {
        prestitiPerStudioService.delete(entity);
    }

    @DeleteMapping
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
    @PutMapping
    public AltriPrestitiEntity saveOnePrestitiEntity(@RequestBody AltriPrestitiEntity entity) {
        return altriPrestitiService.save(entity);
    }

    @PutMapping
    public AltroDebitiEntity saveOneAltroDebitiEntity(@RequestBody AltroDebitiEntity entity) {
        return altroDebitiService.save(entity);
    }

    @PutMapping
    public CarteCreditoEntity saveOneCarteCreditoEntity(@RequestBody CarteCreditoEntity entity) {
        return carteCreditoService.save(entity);
    }

    @PutMapping
    public ImposteLocaliEntity saveOneImposteLocaliEntity(@RequestBody ImposteLocaliEntity entity) {
        return imposteLocaliService.save(entity);
    }

    @PutMapping
    public ImposteStataliEntity saveOneImposteStataliEntity(@RequestBody ImposteStataliEntity entity) {
        return imposteStataliService.save(entity);
    }

    @PutMapping
    public PrestitiPerStudiareEntity saveOnePrestitiPerStudiareEntity(@RequestBody PrestitiPerStudiareEntity entity) {
        return prestitiPerStudioService.save(entity);
    }

    // SAVE MORE ENTITY
    @RequestMapping
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
