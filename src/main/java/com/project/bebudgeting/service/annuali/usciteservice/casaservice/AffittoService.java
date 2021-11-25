package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.AffittoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffittoService {
    @Autowired
    AffittoRepository repository;

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
    public void delete(AffittoEntity entity) {
        repository.delete(entity);

    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AffittoEntity> entities) {
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
     * @return Iterable<AffittoEntity>
     */
    public Iterable<AffittoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AffittoEntity>
     */
    public Iterable<AffittoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AffittoEntity>
     */
    public Optional<AffittoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AffittoEntity
     */
    public AffittoEntity save(AffittoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AffittoEntity>
     */
    public Iterable<AffittoEntity> saveAll(Iterable<AffittoEntity> entities) {
        return repository.saveAll(entities);
    }
}
