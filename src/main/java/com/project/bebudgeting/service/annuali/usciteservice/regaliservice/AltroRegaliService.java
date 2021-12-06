package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.AltroRegaliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.AltroRegaliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroRegaliService {
    @Autowired
    AltroRegaliRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entity
     */
    public void delete(AltroRegaliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroRegaliEntity> entities) {
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
     * @return Iterable<AltroRegaliEntity>
     */
    public Iterable<AltroRegaliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroRegaliEntity>
     */
    public Iterable<AltroRegaliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroRegaliEntity>
     */
    public Optional<AltroRegaliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroRegaliEntity
     */
    public AltroRegaliEntity save(AltroRegaliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroRegaliEntity>
     */
    public Iterable<AltroRegaliEntity> saveAll(Iterable<AltroRegaliEntity> entities) {
        return repository.saveAll(entities);
    }
}
