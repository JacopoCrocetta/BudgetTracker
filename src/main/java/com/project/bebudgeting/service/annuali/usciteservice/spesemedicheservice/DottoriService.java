package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.DottoriRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DottoriService {
    @Autowired
    DottoriRepository repository;

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
    public void delete(DottoriEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<DottoriEntity> entities) {
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
     * @return Iterable<DottoriEntity>
     */
    public Iterable<DottoriEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<DottoriEntity>
     */
    public Iterable<DottoriEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<DottoriEntity>
     */
    public Optional<DottoriEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return DottoriEntity
     */
    public DottoriEntity save(DottoriEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<DottoriEntity>
     */
    public Iterable<DottoriEntity> saveAll(Iterable<DottoriEntity> entities) {
        return repository.saveAll(entities);
    }
}
