package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.FotografiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotografiaService {
    @Autowired
    FotografiaRepository repository;

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
    public void delete(FotografiaEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<FotografiaEntity> entities) {
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
     * @return Iterable<FotografiaEntity>
     */
    public Iterable<FotografiaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FotografiaEntity>
     */
    public Iterable<FotografiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FotografiaEntity>
     */
    public Optional<FotografiaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return FotografiaEntity
     */
    public FotografiaEntity save(FotografiaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FotografiaEntity>
     */
    public Iterable<FotografiaEntity> saveAll(Iterable<FotografiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
