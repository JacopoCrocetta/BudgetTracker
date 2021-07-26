package com.project.bebudgeting.annuale.service;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.repository.EntrateAnnualiRepository;
import com.project.bebudgeting.annuale.service.entrateservice.AltreEntrateService;
import com.project.bebudgeting.annuale.service.entrateservice.SalarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EntrateAnnualiService {
    @Autowired
    EntrateAnnualiRepository repository;

    @Autowired
    SalarioService salarioService;

    @Autowired
    AltreEntrateService altreEntrateService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(EntrateAnnualiEntity entityToDelete) {
        entityToDelete.getAltreEntrateEntities().forEach(altreEntrateEntity -> {
            try {
                altreEntrateService.delete(altreEntrateEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        entityToDelete.getSalarioEntities().forEach(salarioEntity -> {
            try {
                salarioService.delete(salarioEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        altreEntrateService.deleteAll();
        salarioService.deleteAll();
        repository.deleteAll();
    }

    public void deleteAll(Iterable<EntrateAnnualiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(entityToDelete -> {
            if (!entityToDelete.getAltreEntrateEntities().isEmpty()) {
                altreEntrateService.deleteAll(entityToDelete.getAltreEntrateEntities());
            }
            if (!entityToDelete.getSalarioEntities().isEmpty()) {
                salarioService.deleteAll(entityToDelete.getSalarioEntities());
            }
        });
        repository.deleteAll(entitiesToDelete);
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            if (repository.findById(id).isPresent()
                    || !repository.findById(id).get().getAltreEntrateEntities().isEmpty()) {
                repository.findById(id).get().getAltreEntrateEntities().forEach(altreEntrateEntity -> {
                    try {
                        altreEntrateService.deleteById(id);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(id).isPresent() || !repository.findById(id).get().getSalarioEntities().isEmpty()) {
                repository.findById(id).get().getSalarioEntities().forEach(salarioEntity -> {
                    try {
                        salarioService.deleteById(id);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
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
    public Iterable<EntrateAnnualiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<EntrateAnnualiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<EntrateAnnualiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public EntrateAnnualiEntity save(EntrateAnnualiEntity entityToSave) {
        entityToSave.getAltreEntrateEntities()
                .forEach(altreEntrateEntity -> altreEntrateService.save(altreEntrateEntity));
        entityToSave.getSalarioEntities().forEach(salarioEntity -> salarioService.save(salarioEntity));
        return repository.save(entityToSave);
    }

    public Iterable<EntrateAnnualiEntity> saveAll(Iterable<EntrateAnnualiEntity> entitiesToSave) {
        entitiesToSave.forEach(this::save);
        return entitiesToSave;
    }
}