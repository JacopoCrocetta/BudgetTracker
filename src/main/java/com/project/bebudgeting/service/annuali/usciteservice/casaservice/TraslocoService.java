package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.TraslocoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.TraslocoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraslocoService {
    @Autowired
    TraslocoRepository repository;

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
    public void delete(TraslocoEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<TraslocoEntity> entities) {
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
     * @return Iterable<TraslocoEntity>
     */
    public Iterable<TraslocoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TraslocoEntity>
     */
    public Iterable<TraslocoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TraslocoEntity>
     */
    public Optional<TraslocoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return TraslocoEntity
     */
    public TraslocoEntity save(TraslocoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TraslocoEntity>
     */
    public Iterable<TraslocoEntity> saveAll(Iterable<TraslocoEntity> entities) {
        return repository.saveAll(entities);
    }
}
