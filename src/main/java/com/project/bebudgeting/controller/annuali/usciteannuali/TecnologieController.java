package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.TecnologiaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.AltroTecnologiaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HardwareEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HostingEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.ServiziOnlineEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.SoftwareEntity;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.AltroTecnologiaService;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.HardwareService;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.HostingService;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.ServiziOnlineService;
import com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice.SoftwareService;

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

@Api(value = "Tecnologia", tags = "Tecnologia", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/tecnologie")
public class TecnologieController {
    @Autowired
    AltroTecnologiaService altroTecnologiaService;

    @Autowired
    HardwareService hardwareService;

    @Autowired
    HostingService hostingService;

    @Autowired
    ServiziOnlineService serviziOnlineService;

    @Autowired
    SoftwareService softwareService;

    // FIND ALL
    @GetMapping(value = "/get-all-altro-tecnologia-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroTecnologiaEntity> getAllAltroTecnologiaEntities() {
        return altroTecnologiaService.findAll();
    }

    @GetMapping(value = "/get-all-hardware-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HardwareEntity> getAllHardwareEntities() {
        return hardwareService.findAll();
    }

    @GetMapping(value = "/get-all-hosting-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HostingEntity> getAllHostingEntities() {
        return hostingService.findAll();
    }

    @GetMapping(value = "/get-all-servizi-online-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ServiziOnlineEntity> getAllServiziOnlineEntities() {
        return serviziOnlineService.findAll();
    }

    @GetMapping(value = "/get-all-software-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SoftwareEntity> getAllSoftwareEntity() {
        return softwareService.findAll();
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-altro-tecnologia-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroTecnologiaEntities(@RequestBody Iterable<Integer> ids) {
        altroTecnologiaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-hardware-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllHardwareEntities(@RequestBody Iterable<Integer> ids) {
        hardwareService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-hosting-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllHostingEntities(@RequestBody Iterable<Integer> ids) {
        hostingService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-servizi-online-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllServiziOnlineEntities(@RequestBody Iterable<Integer> ids) {
        serviziOnlineService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-giocattoli-figli-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllGiocattoliFigliEntity(@RequestBody Iterable<Integer> ids) {
        softwareService.deleteAllById(ids);
    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-selected-altro-tecnologia-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroTecnologiaEntity(@RequestBody AltroTecnologiaEntity entity) throws NotFoundException {
        altroTecnologiaService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-hardware-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneHardwareEntity(@RequestBody HardwareEntity entity) throws NotFoundException {
        hardwareService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-hosting-entitiy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneHostingEntity(@RequestBody HostingEntity entity) throws NotFoundException {
        hostingService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-servizi-online-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneServiziOnlineEntity(@RequestBody ServiziOnlineEntity entity) throws NotFoundException {
        serviziOnlineService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-software-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSoftwareEntity(@RequestBody SoftwareEntity entity) throws NotFoundException {
        softwareService.delete(entity);
    }

    @DeleteMapping(value = "/get-one-selected-tecnologia-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneVestitiFigliEntity(@RequestBody TecnologiaEntity entity) throws NotFoundException {
        if (!entity.getAltroEntities().isEmpty()) {
            altroTecnologiaService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getHardwareEntities().isEmpty()) {
            hardwareService.deleteAll(entity.getHardwareEntities());
        }
        if (!entity.getHostingEntities().isEmpty()) {
            hostingService.deleteAll(entity.getHostingEntities());
        }
        if (!entity.getServiziOnlineEntities().isEmpty()) {
            serviziOnlineService.deleteAll(entity.getServiziOnlineEntities());
        }
        if (!entity.getSoftwareEntities().isEmpty()) {
            softwareService.deleteAll(entity.getSoftwareEntities());
        }
    }

    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altro-tecnologia-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroTecnologiaEntity saveOneAltroTecnologiaEntity(@RequestBody AltroTecnologiaEntity entity) {
        return altroTecnologiaService.save(entity);
    }

    @PutMapping(value = "/save-one-hardware-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HardwareEntity saveOneAsiloFigliEntity(@RequestBody HardwareEntity entity) {
        return hardwareService.save(entity);
    }

    @PutMapping(value = "/save-one-hosting-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HostingEntity saveOneHostingEntity(@RequestBody HostingEntity entity) {
        return hostingService.save(entity);
    }

    @PutMapping(value = "/save-one-servizi-online-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ServiziOnlineEntity saveOneServiziOnlineEntityEntity(@RequestBody ServiziOnlineEntity entity) {
        return serviziOnlineService.save(entity);
    }

    @PutMapping(value = "/save-one-software-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SoftwareEntity saveOneSoftwareEntity(@RequestBody SoftwareEntity entity) {
        return softwareService.save(entity);
    }

    @PutMapping(value = "/save-one-figli-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TecnologiaEntity saveOneFigliEntity(@RequestBody TecnologiaEntity entity) {
        altroTecnologiaService.saveAll(entity.getAltroEntities());
        hardwareService.saveAll(entity.getHardwareEntities());
        hostingService.saveAll(entity.getHostingEntities());
        serviziOnlineService.saveAll(entity.getServiziOnlineEntities());
        softwareService.saveAll(entity.getSoftwareEntities());

        return entity;
    }
}
