package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AsiloFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.AsiloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsiloService {
    @Autowired
    AsiloRepository repository;

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
    public void delete(AsiloFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AsiloFigliEntity> entities) {
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
     * @return Iterable<AsiloFigliEntity>
     */
    public Iterable<AsiloFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AsiloFigliEntity>
     */
    public Iterable<AsiloFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AsiloFigliEntity>
     */
    public Optional<AsiloFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AsiloFigliEntity
     */
    public AsiloFigliEntity save(AsiloFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AsiloFigliEntity>
     */
    public Iterable<AsiloFigliEntity> saveAll(Iterable<AsiloFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
