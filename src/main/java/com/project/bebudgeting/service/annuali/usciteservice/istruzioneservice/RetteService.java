package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.RetteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.RetteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetteService {
    @Autowired
    RetteRepository repository;

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
    public void delete(RetteEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<RetteEntity> entities) {
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
     * @return Iterable<RetteEntity>
     */
    public Iterable<RetteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RetteEntity>
     */
    public Iterable<RetteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RetteEntity>
     */
    public Optional<RetteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return RetteEntity
     */
    public RetteEntity save(RetteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RetteEntity>
     */
    public Iterable<RetteEntity> saveAll(Iterable<RetteEntity> entities) {
        return repository.saveAll(entities);
    }
}
