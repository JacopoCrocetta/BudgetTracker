package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.ScuolaFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.ScuolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScuolaFigliService {
    @Autowired
    ScuolaRepository repository;

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
    public void delete(ScuolaFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ScuolaFigliEntity> entities) {
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
     * @return Iterable<ScuolaFigliEntity>
     */
    public Iterable<ScuolaFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ScuolaFigliEntity>
     */
    public Iterable<ScuolaFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ScuolaFigliEntity>
     */
    public Optional<ScuolaFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ScuolaFigliEntity
     */
    public ScuolaFigliEntity save(ScuolaFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ScuolaFigliEntity>
     */
    public Iterable<ScuolaFigliEntity> saveAll(Iterable<ScuolaFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
