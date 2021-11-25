package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.SportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {
    @Autowired
    SportRepository repository;

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
    public void delete(SportEntity entity) {
        repository.delete(entity);

    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SportEntity> entities) {
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
     * @return Iterable<SportEntity>
     */
    public Iterable<SportEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SportEntity>
     */
    public Iterable<SportEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SportEntity>
     */
    public Optional<SportEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return SportEntity
     */
    public SportEntity save(SportEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SportEntity>
     */
    public Iterable<SportEntity> saveAll(Iterable<SportEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
