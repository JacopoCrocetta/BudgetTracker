package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.SpeseMedicheFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeseMedicheFigliService {
    @Autowired
    SpeseMedicheFigliRepository repository;

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
    public void delete(SpeseMedicheFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SpeseMedicheFigliEntity> entities) {
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
     * @return Iterable<SpeseMedicheFigliEntity>
     */
    public Iterable<SpeseMedicheFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SpeseMedicheFigliEntity>
     */
    public Iterable<SpeseMedicheFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SpeseMedicheFigliEntity>
     */
    public Optional<SpeseMedicheFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return SpeseMedicheFigliEntity
     */
    public SpeseMedicheFigliEntity save(SpeseMedicheFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SpeseMedicheFigliEntity>
     */
    public Iterable<SpeseMedicheFigliEntity> saveAll(Iterable<SpeseMedicheFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
