package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AltroSpeseQuotidianeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.AltroSpeseQuotidianeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreSpeseQuotidianeService {
    @Autowired
    AltroSpeseQuotidianeRepository repository;

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
    public void delete(AltroSpeseQuotidianeEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroSpeseQuotidianeEntity> entities) {
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
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    public Iterable<AltroSpeseQuotidianeEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    public Iterable<AltroSpeseQuotidianeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroSpeseQuotidianeEntity>
     */
    public Optional<AltroSpeseQuotidianeEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroSpeseQuotidianeEntity
     */
    public AltroSpeseQuotidianeEntity save(AltroSpeseQuotidianeEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    public Iterable<AltroSpeseQuotidianeEntity> saveAll(Iterable<AltroSpeseQuotidianeEntity> entities) {
        return repository.saveAll(entities);
    }
}
