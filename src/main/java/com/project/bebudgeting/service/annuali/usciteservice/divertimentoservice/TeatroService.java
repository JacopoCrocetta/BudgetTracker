package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TeatroEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.TeatroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeatroService {
    @Autowired
    TeatroRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entity
     */
    public void delete(TeatroEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<TeatroEntity> entities) {
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
     * @return Iterable<TeatroEntity>
     */
    public Iterable<TeatroEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TeatroEntity>
     */
    public Iterable<TeatroEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TeatroEntity>
     */
    public Optional<TeatroEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return TeatroEntity
     */
    public TeatroEntity save(TeatroEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TeatroEntity>
     */
    public Iterable<TeatroEntity> saveAll(Iterable<TeatroEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
