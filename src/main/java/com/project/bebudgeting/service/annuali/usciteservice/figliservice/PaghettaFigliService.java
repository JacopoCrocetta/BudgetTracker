package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.PaghettaFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.PaghettaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaghettaFigliService {
    @Autowired
    PaghettaRepository repository;

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
    public void delete(PaghettaFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<PaghettaFigliEntity> entities) {
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
     * @return Iterable<PaghettaFigliEntity>
     */
    public Iterable<PaghettaFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<PaghettaFigliEntity>
     */
    public Iterable<PaghettaFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<PaghettaFigliEntity>
     */
    public Optional<PaghettaFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return PaghettaFigliEntity
     */
    public PaghettaFigliEntity save(PaghettaFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<PaghettaFigliEntity>
     */
    public Iterable<PaghettaFigliEntity> saveAll(Iterable<PaghettaFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
