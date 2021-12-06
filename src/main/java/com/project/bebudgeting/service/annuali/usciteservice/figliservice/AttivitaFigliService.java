package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AttivitaFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.AttivitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttivitaFigliService {
    @Autowired
    AttivitaRepository repository;

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
    public void delete(AttivitaFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AttivitaFigliEntity> entities) {
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
     * @return Iterable<AttivitaFigliEntity>
     */
    public Iterable<AttivitaFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AttivitaFigliEntity>
     */
    public Iterable<AttivitaFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AttivitaFigliEntity>
     */
    public Optional<AttivitaFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AttivitaFigliEntity
     */
    public AttivitaFigliEntity save(AttivitaFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AttivitaFigliEntity>
     */
    public Iterable<AttivitaFigliEntity> saveAll(Iterable<AttivitaFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
