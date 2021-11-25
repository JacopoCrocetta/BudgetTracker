package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.AttivitaOutsideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttivitaOutsideService {
    @Autowired
    AttivitaOutsideRepository repository;

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
    public void delete(AttivitaOutsideEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AttivitaOutsideEntity> entities) {
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
     * @return Iterable<AttivitaOutsideEntity>
     */
    public Iterable<AttivitaOutsideEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AttivitaOutsideEntity>
     */
    public Iterable<AttivitaOutsideEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AttivitaOutsideEntity>
     */
    public Optional<AttivitaOutsideEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AttivitaOutsideEntity
     */
    public AttivitaOutsideEntity save(AttivitaOutsideEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AttivitaOutsideEntity>
     */
    public Iterable<AttivitaOutsideEntity> saveAll(Iterable<AttivitaOutsideEntity> entities) {
        return repository.saveAll(entities);
    }
}
