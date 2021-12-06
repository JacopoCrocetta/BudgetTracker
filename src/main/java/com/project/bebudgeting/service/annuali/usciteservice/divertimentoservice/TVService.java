package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TVEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.TVRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TVService {
    @Autowired
    TVRepository repository;

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
    public void delete(TVEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<TVEntity> entities) {
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
     * @return Iterable<TVEntity>
     */
    public Iterable<TVEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TVEntity>
     */
    public Iterable<TVEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TVEntity>
     */
    public Optional<TVEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return TVEntity
     */
    public TVEntity save(TVEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TVEntity>
     */
    public Iterable<TVEntity> saveAll(Iterable<TVEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
