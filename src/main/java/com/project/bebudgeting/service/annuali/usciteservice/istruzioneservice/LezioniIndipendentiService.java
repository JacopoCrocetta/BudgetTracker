package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.LezioniIndipendentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LezioniIndipendentiService {
    @Autowired
    LezioniIndipendentiRepository repository;

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
    public void delete(LezioniIndipendentiEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<LezioniIndipendentiEntity> entities) {
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
     * @return Iterable<LezioniIndipendentiEntity>
     */
    public Iterable<LezioniIndipendentiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LezioniIndipendentiEntity>
     */
    public Iterable<LezioniIndipendentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LezioniIndipendentiEntity>
     */
    public Optional<LezioniIndipendentiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return LezioniIndipendentiEntity
     */
    public LezioniIndipendentiEntity save(LezioniIndipendentiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LezioniIndipendentiEntity>
     */
    public Iterable<LezioniIndipendentiEntity> saveAll(Iterable<LezioniIndipendentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
