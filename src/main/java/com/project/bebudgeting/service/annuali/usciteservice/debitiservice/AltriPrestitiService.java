package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.AltriPrestitiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltriPrestitiService {
    @Autowired
    AltriPrestitiRepository repository;

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
    public void delete(AltriPrestitiEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltriPrestitiEntity> entities) {
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
     * @return Iterable<AltriPrestitiEntity>
     */
    public Iterable<AltriPrestitiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltriPrestitiEntity>
     */
    public Iterable<AltriPrestitiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltriPrestitiEntity>
     */
    public Optional<AltriPrestitiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltriPrestitiEntity
     */
    public AltriPrestitiEntity save(AltriPrestitiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltriPrestitiEntity>
     */
    public Iterable<AltriPrestitiEntity> saveAll(Iterable<AltriPrestitiEntity> entities) {
        return repository.saveAll(entities);
    }
}
