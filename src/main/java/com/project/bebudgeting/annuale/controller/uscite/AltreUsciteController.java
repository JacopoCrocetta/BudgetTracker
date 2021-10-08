package com.project.bebudgeting.annuale.controller.uscite;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.AltreUsciteEntity;
import com.project.bebudgeting.annuale.service.usciteservice.AltreUsciteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

@Api(value = "Altre Uscite", tags = "Altre Uscite", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/altre-uscite")
public class AltreUsciteController {
    @Autowired
    AltreUsciteService altreUsciteService;

    // FIND
    @GetMapping(value = "/get-all-altre-uscite", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltreUsciteEntity> getAllUsciteEntity() {
        return altreUsciteService.findAll();
    }

    @GetMapping(value = "/get-all-altre-uscite-by-ids", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltreUsciteEntity> findAllById(@RequestBody Iterable<Integer> ids) {
        return altreUsciteService.findAllById(ids);
    }

    @GetMapping(value = "/get-altre-uscite-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<AltreUsciteEntity> findById(@RequestParam int id) {
        return altreUsciteService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "/delete-all-entity")
    public void deleteAll() {
        altreUsciteService.deleteAll();
    }

    @DeleteMapping(value = "/delete-all-selected-entity")
    public void deleteAllSelectedEntity(@RequestBody Iterable<AltreUsciteEntity> entitiesToDelete) {
        altreUsciteService.deleteAll(entitiesToDelete);
    }

    @DeleteMapping(value = "/delete-all-selected-entity-by-id")
    public void deleteAllSelectedEntityByIds(@RequestBody Iterable<Integer> ids) {
        altreUsciteService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-one-uscite-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEntity(@RequestBody AltreUsciteEntity entity) throws NotFoundException {
        altreUsciteService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-uscite-entity-by-id")
    public void deleteOneEntityNyId(@RequestParam int id) throws NotFoundException {
        altreUsciteService.deleteById(id);
    }

    // SAVE
    @PutMapping(value = "/insert-one-entity")
    public AltreUsciteEntity saveOneEntity(@RequestBody AltreUsciteEntity entity) {
        return altreUsciteService.save(entity);
    }

    @PutMapping(value = "/insert-more-entity")
    public Iterable<AltreUsciteEntity> saveAll(@RequestBody Iterable<AltreUsciteEntity> entitiesToSave) {
        return altreUsciteService.saveAll(entitiesToSave);
    }
}
