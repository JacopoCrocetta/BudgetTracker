package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.EmergenzeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergenzeService {
    @Autowired
    EmergenzeRepository repository;

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
    public void delete(EmergenzeEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<EmergenzeEntity> entities) {
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
     * @return Iterable<EmergenzeEntity>
     */
    public Iterable<EmergenzeEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<EmergenzeEntity>
     */
    public Iterable<EmergenzeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<EmergenzeEntity>
     */
    public Optional<EmergenzeEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return EmergenzeEntity
     */
    public EmergenzeEntity save(EmergenzeEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<EmergenzeEntity>
     */
    public Iterable<EmergenzeEntity> saveAll(Iterable<EmergenzeEntity> entities) {
        return repository.saveAll(entities);
    }
}
