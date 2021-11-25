package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.ArredamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArredamentoService {
    @Autowired
    ArredamentoRepository repository;

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
    public void delete(ArredamentoEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ArredamentoEntity> entities) {
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
     * @return Iterable<ArredamentoEntity>
     */
    public Iterable<ArredamentoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ArredamentoEntity>
     */
    public Iterable<ArredamentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ArredamentoEntity>
     */
    public Optional<ArredamentoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ArredamentoEntity
     */
    public ArredamentoEntity save(ArredamentoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ArredamentoEntity>
     */
    public Iterable<ArredamentoEntity> saveAll(Iterable<ArredamentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
