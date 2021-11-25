package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.ConcertiOSpettacoliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertiOSpettacoliService {
    @Autowired
    ConcertiOSpettacoliRepository repository;

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
    public void delete(ConcertiOSpettacoliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ConcertiOSpettacoliEntity> entities) {
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
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    public Iterable<ConcertiOSpettacoliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    public Iterable<ConcertiOSpettacoliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ConcertiOSpettacoliEntity>
     */
    public Optional<ConcertiOSpettacoliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ConcertiOSpettacoliEntity
     */
    public ConcertiOSpettacoliEntity save(ConcertiOSpettacoliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    public Iterable<ConcertiOSpettacoliEntity> saveAll(Iterable<ConcertiOSpettacoliEntity> entities) {
        return repository.saveAll(entities);
    }
}
