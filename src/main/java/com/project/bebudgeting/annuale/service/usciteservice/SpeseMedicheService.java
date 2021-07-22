package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.SpeseMedicheEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.SpeseMedicheRepository;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.AltreSpeseMedicheService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.CureSpecialisticheService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.DottoriService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.EmergenzeService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.FarmaciService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseMedicheService {
    @Autowired
    SpeseMedicheRepository repository;

    @Autowired
    AltreSpeseMedicheService altreSpeseMedicheService;

    @Autowired
    CureSpecialisticheService cureSpecialisticheService;

    @Autowired
    DottoriService dottoriService;

    @Autowired
    EmergenzeService emergenzeService;

    @Autowired
    FarmaciService farmaciService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altreSpeseMedicheService.deleteAll();
        cureSpecialisticheService.deleteAll();
        dottoriService.deleteAll();
        emergenzeService.deleteAll();
        farmaciService.deleteAll();
        repository.deleteAll();
    }

    public void delete(SpeseMedicheEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (!entity.getAltroEntities().isEmpty()) {
                entity.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altreSpeseMedicheService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getCureSpecialisticheEntities().isEmpty()) {
                entity.getCureSpecialisticheEntities().forEach(cureEntity -> {
                    try {
                        cureSpecialisticheService.delete(cureEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getDottoriEntities().isEmpty()) {
                entity.getDottoriEntities().forEach(dottoriEntity -> {
                    try {
                        dottoriService.delete(dottoriEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getEmergenzeEntities().isEmpty()) {
                entity.getEmergenzeEntities().forEach(emergenzeEntity -> {
                    try {
                        emergenzeService.delete(emergenzeEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getFarmaciEntities().isEmpty()) {
                entity.getFarmaciEntities().forEach(farmaciEntity -> {
                    try {
                        farmaciService.delete(farmaciEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.delete(entity);
        } else {
            throw new NotFoundException("msg");
        }
    }

    public void deleteAll(Iterable<SpeseMedicheEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id) || repository.findById(id).isPresent()) {
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(entity -> {
                    try {
                        altreSpeseMedicheService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getCureSpecialisticheEntities().isEmpty()) {
                repository.findById(id).get().getCureSpecialisticheEntities().forEach(entity -> {
                    try {
                        cureSpecialisticheService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getDottoriEntities().isEmpty()) {
                repository.findById(id).get().getDottoriEntities().forEach(entity -> {
                    try {
                        dottoriService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getEmergenzeEntities().isEmpty()) {
                repository.findById(id).get().getEmergenzeEntities().forEach(entity -> {
                    try {
                        emergenzeService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getFarmaciEntities().isEmpty()) {
                repository.findById(id).get().getFarmaciEntities().forEach(entity -> {
                    try {
                        farmaciService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<SpeseMedicheEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SpeseMedicheEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SpeseMedicheEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SpeseMedicheEntity save(SpeseMedicheEntity entity) {
        altreSpeseMedicheService.saveAll(entity.getAltroEntities());
        cureSpecialisticheService.saveAll(entity.getCureSpecialisticheEntities());
        dottoriService.saveAll(entity.getDottoriEntities());
        emergenzeService.saveAll(entity.getEmergenzeEntities());
        farmaciService.saveAll(entity.getFarmaciEntities());
        return repository.save(entity);
    }

    public Iterable<SpeseMedicheEntity> saveAll(Iterable<SpeseMedicheEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
