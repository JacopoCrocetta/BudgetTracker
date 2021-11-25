package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.PartiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartiteService {
    @Autowired
    PartiteRepository repository;

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
    public void delete(PartiteEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<PartiteEntity> entities) {
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
     * @return Iterable<PartiteEntity>
     */
    public Iterable<PartiteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<PartiteEntity>
     */
    public Iterable<PartiteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<PartiteEntity>
     */
    public Optional<PartiteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return PartiteEntity
     */
    public PartiteEntity save(PartiteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<PartiteEntity>
     */
    public Iterable<PartiteEntity> saveAll(Iterable<PartiteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
