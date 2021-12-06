package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.AltroSpeseMedicheEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.AltroSpeseMedicheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreSpeseMedicheService {
    @Autowired
    AltroSpeseMedicheRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entity
     */
    public void delete(AltroSpeseMedicheEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroSpeseMedicheEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            this.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<AltroSpeseMedicheEntity>
     */
    public Iterable<AltroSpeseMedicheEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroSpeseMedicheEntity>
     */
    public Iterable<AltroSpeseMedicheEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroSpeseMedicheEntity>
     */
    public Optional<AltroSpeseMedicheEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroSpeseMedicheEntity
     */
    public AltroSpeseMedicheEntity save(AltroSpeseMedicheEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroSpeseMedicheEntity>
     */
    public Iterable<AltroSpeseMedicheEntity> saveAll(Iterable<AltroSpeseMedicheEntity> entities) {
        return repository.saveAll(entities);
    }
}
