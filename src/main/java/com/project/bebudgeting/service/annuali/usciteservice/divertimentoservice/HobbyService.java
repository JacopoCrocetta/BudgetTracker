package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.HobbyEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.HobbyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbyService {
    @Autowired
    HobbyRepository repository;

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
    public void delete(HobbyEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<HobbyEntity> entities) {
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
     * @return Iterable<HobbyEntity>
     */
    public Iterable<HobbyEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<HobbyEntity>
     */
    public Iterable<HobbyEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<HobbyEntity>
     */
    public Optional<HobbyEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return HobbyEntity
     */
    public HobbyEntity save(HobbyEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<HobbyEntity>
     */
    public Iterable<HobbyEntity> saveAll(Iterable<HobbyEntity> entities) {
        return repository.saveAll(entities);
    }
}
