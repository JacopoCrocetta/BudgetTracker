package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.AltreUsciteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.AltreUsciteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreUsciteService {
    @Autowired
    AltreUsciteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltreUsciteEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltreUsciteEntity> entitiesToDelete) {
        repository.deleteAll(entitiesToDelete);
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            this.deleteById(id);
        });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
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
