package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.FarmaciEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.FarmaciRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmaciService {
    @Autowired
    FarmaciRepository repository;

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
    public void delete(FarmaciEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<FarmaciEntity> entities) {
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
     * @return Iterable<FarmaciEntity>
     */

    public Iterable<FarmaciEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FarmaciEntity>
     */
    public Iterable<FarmaciEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FarmaciEntity>
     */
    public Optional<FarmaciEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return FarmaciEntity
     */
    public FarmaciEntity save(FarmaciEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FarmaciEntity>
     */
    public Iterable<FarmaciEntity> saveAll(Iterable<FarmaciEntity> entities) {
        return repository.saveAll(entities);
    }
}
