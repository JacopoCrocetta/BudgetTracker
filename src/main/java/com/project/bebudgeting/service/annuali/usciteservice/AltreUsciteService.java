package com.project.bebudgeting.service.annuali.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.AltreUsciteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.AltreUsciteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreUsciteService {
    @Autowired
    AltreUsciteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltreUsciteEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltreUsciteEntity> entitiesToDelete) {
        repository.deleteAll(entitiesToDelete);
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

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    // FIND
    public Iterable<AltreUsciteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltreUsciteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltreUsciteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltreUsciteEntity save(AltreUsciteEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AltreUsciteEntity> saveAll(Iterable<AltreUsciteEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
